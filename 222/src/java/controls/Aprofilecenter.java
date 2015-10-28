/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controls;

import java.io.IOException;
import java.io.PrintWriter;
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
import models.Agentprofiles;

/**
 *
 * @author Victor
 */
public class Aprofilecenter extends HttpServlet {

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
        String agids = request.getParameter("AgentID");
        int agid = Integer.parseInt(agids);
        
        EntityManager em = emf.createEntityManager();
        Agentprofiles ap = em.find(Agentprofiles.class, agid);
        
        PrintWriter out = response.getWriter(); 
        out.println("<input name='thisid' type='text' value='" + agids +"' readonly >");
        
        out.println("<label for=\"traname1\">Travel Agancy</label>"+
                "<input value='" + ap.getTravelAgent() + "' class='form-control' type='text' name='traname1' id='traname1' required>");
        
        out.println("<label for=\"phone1\">Travel Agancy</label>"+
                "<input value='" + ap.getPhone() + "' class='form-control' type='text' name='phone1' id='phone1' required>");
        
        out.println("<label for=\"aemail1\">Email</label>"+
                "<input value='" + ap.getEmail() + "' class='form-control' type='text' name='aemail1' id='aemail1' required>");
        
        out.println("<input onclick='ajax5()' type=\"submit\" class=\"form-control btn-info\" value=\"Change Agancy Profile\">");
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
            String id = request.getParameter("thisid");
            String agname = request.getParameter("traname1");
            String phone = request.getParameter("phone1");
            String email = request.getParameter("aemail1");
            
             
            utx.begin();
            EntityManager em = emf.createEntityManager();
            Agentprofiles ap = em.find(Agentprofiles.class, Integer.parseInt(id));
            ap.setTravelAgent(agname);
            ap.setPhone(phone);
            ap.setEmail(email);
            em.persist(ap);
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
