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
import models.Customer;
import models.Login;
import models.Schedule;
import models.Ticket;

/**
 *
 * @author Victor
 */
public class deletebooking extends HttpServlet {

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
        HttpSession hs=request.getSession(true);
        String user = (String)hs.getAttribute("username");
        EntityManager em = emf.createEntityManager();
        
        Login lg = em.getReference(Login.class, user);
        em.refresh(lg);
        Customer cus = lg.getCustomer();
        
            em.refresh(cus);
        List<Ticket> tickets = cus.getTicketList();
        
        PrintWriter out = response.getWriter();
        out.println("<tr><th>delete ticket</th><th>ticket ID</th><th>source</th><th>destination</th><th>departure time</th></tr>");
        
        for(Ticket tk:tickets){
            Schedule sch = tk.getScheduleID();
            String source = sch.getRouteID().getSourceAirport().getName();
            String destination = sch.getRouteID().getDestinationAirport().getName();
            String[] splitds = sch.getDepartDate().toString().split(" ");
            String deptime = splitds[0] + " " + splitds[1] + " " + splitds[2] + " " + sch.getDepartTime();
            out.print("<tr id = '" + tk.getTicketID() + "'><td><button data-toggle='modal' data-target='#confirmdeltick' class='btn btn-info' onclick='confirmdeltick(" + tk.getTicketID() + ")'>delete</button></td>" +
                    "<td>" + tk.getTicketID() + "</td><td>" + source + "</td><td>" + destination + "</td><td>" + deptime + "</td></tr>");
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
            String ticketid = request.getParameter("dtkid");
            
            utx.begin();
            EntityManager em = emf.createEntityManager();
            Ticket tk = em.getReference(Ticket.class, Integer.parseInt(ticketid));
            tk.getSeatId().setOccupied(false);
            em.remove(tk);
            utx.commit();
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
