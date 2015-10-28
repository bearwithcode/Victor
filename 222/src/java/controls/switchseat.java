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
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import models.Seat;
import models.Ticket;

/**
 *
 * @author Victor
 */
public class switchseat extends HttpServlet {

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
        String tkid = request.getParameter("tkid");
        
        EntityManager em = emf.createEntityManager();
        Ticket tk = em.getReference(Ticket.class, Integer.parseInt(tkid));
        em.refresh(tk);
        List<Seat> seats = tk.getScheduleID().getPlaneID().getSeatList();
        
        PrintWriter out = response.getWriter(); 
        out.println("<tr><th>select</th><th>seatnumber</th><th>select</th><th>seatnumber</th><th>select</th><th>seatnumber</th></tr>");
        
        int row = 1;
        for(int i = 0;i < seats.size();i ++){
            if(row == 1)
                out.println("<tr>");
            if(seats.get(i).getOccupied() == true)
                out.println("<td><button onclick = 'switchseatid(" + seats.get(i).getSeatId() + ")' class = 'btn btn-warning' disabled>select</button></td>");
            else
                out.println("<td><button onclick = 'switchseatid(" + seats.get(i).getSeatId() + ")' class = 'btn btn-info'>select</button></td>");
            
            if(seats.get(i).getSeatClass().equals("first")){
                out.println("<td class=\"success\">" + seats.get(i).getSeatNumber() + "</td>");
            }
            else if(seats.get(i).getSeatClass().equals("business")){
                out.println("<td class=\"info\">" + seats.get(i).getSeatNumber() + "</td>");
            }
            else if(seats.get(i).getSeatClass().equals("economy")){
                out.println("<td class=\"warning\">" + seats.get(i).getSeatNumber() + "</td>");
            }
            else if(seats.get(i).getSeatClass().equals("premium")){
                out.println("<td class=\"danger\">" + seats.get(i).getSeatNumber() + "</td>");
            }
            row ++;
            if(row == 4){
                out.println("</tr>");
                row = 1;
            }           
                
        }
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
            String ticketid = request.getParameter("ticketid");
            String nseatid = request.getParameter("nseatid");
            
            utx.begin();
            EntityManager em = emf.createEntityManager();
            Ticket tk = em.getReference(Ticket.class, Integer.parseInt(ticketid));
            Seat old = tk.getSeatId();
            old.setOccupied(false);
            Seat newseat = em.getReference(Seat.class, Integer.parseInt(nseatid));
            newseat.setOccupied(true);
            tk.setSeatId(newseat);
            em.persist(tk);
            utx.commit();
            String newseatnum = newseat.getSeatNumber();
            PrintWriter out = response.getWriter(); 
            out.println(newseatnum);
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
