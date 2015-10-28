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
import models.Serviceinventory;

/**
 *
 * @author Victor
 */
public class GetIvlist extends HttpServlet {

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
        List<Serviceinventory> sis = em.createNamedQuery("Serviceinventory.findAll", Serviceinventory.class).getResultList();
        
        PrintWriter out = response.getWriter(); 
        out.println(
    "    <tr>\n" +
    "    <th>Change</th><th>Item</th><th>Cost</th><th>Availability</th>\n" +
    "    </tr>");
        
        for(Serviceinventory si:sis){
            out.println("<tr id='" + si.getServiceId() + "'><td><button onclick = 'confirmremove(" + si.getServiceId() +")' type='button' class='btn btn-warning ' data-toggle='modal' data-target='#confirmreit' >remove</button></td><td>" + si.getItem() + "</td><td>" + si.getCost() + "</td><td>" + si.getAvaliablity() + "</td></tr>");
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
