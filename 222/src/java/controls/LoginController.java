/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controls;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Login;

/**
 *
 * @author Victor
 */
public class LoginController extends HttpServlet {
    @PersistenceUnit(unitName="222PU")
    private EntityManagerFactory emf;
    

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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        EntityManager em = emf.createEntityManager();
        String jpql1 = "SELECT Logini FROM Login Logini WHERE Logini.username = ?1 AND Logini.password = ?2";
        Query query = em.createQuery(jpql1);
        query.setParameter(1, username);
        query.setParameter(2, password);
        List<Login> result = (List<Login>)query.getResultList();
        
        if(result.isEmpty()){
            String error = "please check username and password correct";
            request.setAttribute("msg", error);
            RequestDispatcher view = request.getRequestDispatcher("welcome.jsp");
            view.forward(request, response);
            em.close();
        }
        else{
            String role = result.get(0).getRole();
            HttpSession session = request.getSession(true);
            session.setAttribute("username", username);
            RequestDispatcher view = null;
            em.close();
            switch(role){
                case "customer":
                    session.setAttribute("role", role);
                    view = request.getRequestDispatcher("customer.jsp");
                    view.forward(request, response);
                    break;
                case "admin":
                    view = request.getRequestDispatcher("admin.jsp");
                    view.forward(request, response);
                    break;
                case "bookingmanager":
                    view = request.getRequestDispatcher("bookingmanager.jsp");
                    view.forward(request, response);
                    break;
                case "profilemanager":
                    view = request.getRequestDispatcher("profilemanager.jsp");
                    view.forward(request, response);
                    break;
                case "servicemanager":
                    view = request.getRequestDispatcher("servicemanager.jsp");
                    view.forward(request, response);
                    break;
                case "flightmanager":
                    view = request.getRequestDispatcher("flightmanager.jsp");
                    view.forward(request, response);
                    break;
            }
            
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
