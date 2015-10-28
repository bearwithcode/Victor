/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controls;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import models.Airplane;
import models.Customer;
import models.Login;
import models.Route;
import models.Schedule;
import models.Seat;
import models.Ticket;

/**
 *
 * @author Victor
 */
public class newticket extends HttpServlet {

    @PersistenceUnit(unitName="222PU")
    private EntityManagerFactory emf;
    @Resource
    private UserTransaction utx;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String schid = request.getParameter("schid");
        EntityManager em = emf.createEntityManager();
        Schedule sch = em.getReference(Schedule.class, Integer.parseInt(schid));
        Airplane ap = sch.getPlaneID();
        em.refresh(ap);
        List<Seat> seats = ap.getSeatList();
        
        PrintWriter out = response.getWriter(); 
        out.println("<tr><th>select</th><th>seatnumber</th><th>select</th><th>seatnumber</th><th>select</th><th>seatnumber</th></tr>");
        
        int row = 1;
        for(int i = 0;i < seats.size();i ++){
            if(row == 1){
                out.print("<tr>");
            }
            
            if(seats.get(i).getOccupied() == true){
                out.print("<td><button onclick = 'getseatid(" + seats.get(i).getSeatId() + ")' class = 'btn btn-warning' disabled>select</button></td>");
            }
            else{
                out.print("<td><button onclick = 'getseatid(" + seats.get(i).getSeatId() + ")' class = 'btn btn-info'>select</button></td>");
            }
            
            if(seats.get(i).getSeatClass().equals("first")){
                out.print("<td class=\"success\">" + seats.get(i).getSeatNumber() + "</td>");
            }
            else if(seats.get(i).getSeatClass().equals("business")){
                out.print("<td class=\"info\">" + seats.get(i).getSeatNumber() + "</td>");
            }
            else if(seats.get(i).getSeatClass().equals("economy")){
                out.print("<td class=\"warning\">" + seats.get(i).getSeatNumber() + "</td>");
            }
            else if(seats.get(i).getSeatClass().equals("premium")){
                out.print("<td class=\"danger\">" + seats.get(i).getSeatNumber() + "</td>");
            }
            
            row += 1;
            if(row == 4){
                out.println("</tr>");
                row = 1;
            }
            
           
                    
        }
        em.close();
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String schid = request.getParameter("schid");
            String seatid = request.getParameter("seatid");
            
            HttpSession hs=request.getSession(true);
            String user = (String)hs.getAttribute("username");
            
            utx.begin();
            EntityManager em = emf.createEntityManager();
            Login lg = em.getReference(Login.class, user);
            Customer cus = lg.getCustomer();
            Schedule sch = em.getReference(Schedule.class, Integer.parseInt(schid));
            Route rt = sch.getRouteID();
            Seat st = em.getReference(Seat.class, Integer.parseInt(seatid));
            st.setOccupied(true);
            Ticket tk = new Ticket();
            
            tk.setCustomerId(cus);
            tk.setScheduleID(sch);
            tk.setSeatId(st);
            tk.setPayed(false);
            em.persist(tk);
            utx.commit();
            em.close();
            
        } catch (NotSupportedException ex) {
            ex.printStackTrace();
        } catch (SystemException ex) {
            ex.printStackTrace();
        } catch (RollbackException ex) {
            ex.printStackTrace();
        } catch (HeuristicMixedException ex) {
            ex.printStackTrace();
        } catch (HeuristicRollbackException ex) {
            ex.printStackTrace();
        } catch (SecurityException ex) {
            ex.printStackTrace();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
