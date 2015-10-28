/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controls;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;
import models.Customer;
import models.Login;
import models.Ticket;

/**
 *
 * @author Victor
 */
public class changeseat extends HttpServlet {

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
        out.println("<tr><td>change</td><td>seatnumber</td></tr>");
        
        for(Ticket tk:tickets){
            out.println("<tr><td><button data-toggle='modal' data-target='#confirmseatchange' onclick = 'changeseat(" + tk.getTicketID() + ")' class='btn btn-info'>change seat</button>" + 
                    "</td><td id = '" + tk.getTicketID() + "n'>" + tk.getSeatId().getSeatNumber() + "</td></tr>");
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
