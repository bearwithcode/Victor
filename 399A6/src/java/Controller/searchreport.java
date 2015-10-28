/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.Ecinfo;
import Model.Ecperformances;
import Model.Ecpresentations;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Victor
 */
public class searchreport extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        String title = request.getParameter("title");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("399A6PU");
        EntityManager em = emf.createEntityManager();
        
        Ecpresentations epre = (Ecpresentations)em.createNamedQuery("Ecpresentations.findByTitle").setParameter("title", title).getSingleResult();
        List<Ecperformances> epers = epre.getEcperformancesList();
        List<Ecinfo> einfo = epre.getEcinfoList();
        
        
        request.setAttribute("basic", epre);
        request.setAttribute("time", epers);
        request.setAttribute("sup", einfo);
        RequestDispatcher view = request.getRequestDispatcher("searchreport.jsp");
        view.forward(request, response);
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
