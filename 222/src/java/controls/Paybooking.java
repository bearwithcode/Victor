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
import models.Ticket;

/**
 *
 * @author Victor
 */
public class Paybooking extends HttpServlet {

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
        List<Ticket> tks = cus.getTicketList();        
        PrintWriter out = response.getWriter(); 
        out.println(
    "    <tr>\n" +
    "    <th>Pay</th><th>TicketID</th><th>payment status</th>\n" +
    "    </tr>");
        
        for(Ticket tk:tks){
            out.println("<tr><td><button data-toggle='modal' data-target='#confirmpaying' class='btn btn-info' onclick='buyticket(" + tk.getTicketID() + ")'>" + 
                    "Pay</button></td><td>" + tk.getTicketID() + "</td><td id='" + tk.getTicketID() + "p'>" + tk.getPayed() + "</td></tr>");
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
            int OK = 0;
            String payid = request.getParameter("paytkid");
            String cre = request.getParameter("confirmcre");
            utx.begin();
            EntityManager em = emf.createEntityManager();
            Ticket tk = em.getReference(Ticket.class, Integer.parseInt(payid));
            if(tk.getCustomerId().getCreditCardNum().equals(cre) == true){
                tk.setPayed(true);
                OK = 1;
            }
            
            em.persist(tk);
            utx.commit();
            em.close();
            
            PrintWriter out = response.getWriter(); 
            out.println(OK);
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
