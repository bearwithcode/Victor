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
import javax.transaction.UserTransaction;
import models.Customer;

/**
 *
 * @author Victor
 */
public class profilecus extends HttpServlet {


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
        EntityManager em = emf.createEntityManager();
        List<Customer> cus = em.createNamedQuery("Customer.findAll",Customer.class).getResultList();
        
        PrintWriter out = response.getWriter(); 
        out.println("<table class=\"table form-control\">\n" +
"                    <tr>\n" +
"                        <th>First Name</th>\n" +
"                        <th>Last name</th>\n" +
"                        <th>Modification</th>\n" +
"                    </tr>");
        for(Customer cu:cus){
            out.println("<tr><td>" + cu.getFirstName() + "</td><td>" + cu.getLastName() +"</td><td><button onclick='changeCprofile(" + cu.getCustomerId() + ")' type='button' class='btn btn-info ' data-toggle='modal' data-target='#changeCu'>view and change</button></td></tr>");
        }
        out.println("</table>");
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
