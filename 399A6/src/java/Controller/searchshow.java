/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.Ecpresentations;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Victor
 */
public class searchshow extends HttpServlet {


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
        RequestDispatcher view = request.getRequestDispatcher("searchshow.jsp");
        view.forward(request, response);
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
        
        String st = request.getParameter("st");
        String ve = request.getParameter("ve");
        String sds = request.getParameter("sd");
        String eds = request.getParameter("ed");
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date sd = null,ed = null;
        try {
            sd = df.parse(sds);
            ed = df.parse(eds);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("399A6PU");
        EntityManager em = emf.createEntityManager();
        
        String jpql1 = "SELECT Ecpre FROM Ecpresentations Ecpre WHERE Ecpre.venue = ?1 AND Ecpre.genre = ?2 AND Ecpre.startseason >= ?3 AND Ecpre.endseason <= ?4";
        Query query = em.createQuery(jpql1);
        query.setParameter(1, ve);
        query.setParameter(2, st);
        query.setParameter(3, sd,TemporalType.DATE);
        query.setParameter(4, ed,TemporalType.DATE);
        
        List<Ecpresentations> result = (List<Ecpresentations>)query.getResultList();
        request.setAttribute("listshow", result);
        request.setAttribute("len", result.size());
        RequestDispatcher view = request.getRequestDispatcher("searchshow.jsp");
        view.forward(request, response);
        em.close();
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
