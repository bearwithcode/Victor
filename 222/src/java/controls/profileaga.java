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
import models.Agentprofiles;

/**
 *
 * @author Victor
 */
public class profileaga extends HttpServlet {

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
        List<Agentprofiles> agents = em.createNamedQuery("Agentprofiles.findAll",Agentprofiles.class).getResultList();
        
        PrintWriter out = response.getWriter(); 
        out.println("<table class=\"table form-control\">\n" +
"                    <tr>\n" +
"                        <th>Agency name</th>\n" +
"                        <th>Modification</th>\n" +
"                    </tr>");
        for(Agentprofiles agent:agents){
            out.println("<tr><td>" + agent.getTravelAgent()  +"</td><td><button onclick='changeAprofile(" + agent.getAgentId() + ")' type='button' class='btn btn-info ' data-toggle='modal' data-target='#changeAP'>view and change</button></td></tr>");
        }
        
        out.println(" \n" +
"                </table>");
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
            String agance = request.getParameter("traname");
            String phonedis = request.getParameter("dis");
            String phonenum = request.getParameter("phnum");
            String phone = phonedis + "-" + phonenum;
            
            String email = request.getParameter("aemail");
            
            Agentprofiles ap = new Agentprofiles();
            utx.begin();
            EntityManager em = emf.createEntityManager();
            ap.setTravelAgent(agance);
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
