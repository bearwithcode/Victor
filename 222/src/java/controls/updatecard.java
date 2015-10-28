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
import javax.servlet.http.HttpSession;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import models.Customer;
import models.Login;

/**
 *
 * @author Victor
 */
public class updatecard extends HttpServlet {
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
        String cardtype = request.getParameter("cretype");
        String cardnum = request.getParameter("ccn");
        
        HttpSession hs=request.getSession(true);
        String user = (String)hs.getAttribute("username");
        utx.begin();
        EntityManager em = emf.createEntityManager();
        Login lg = em.find(Login.class, user);
        Customer cus = lg.getCustomer();
        cus.setCreditCardType(cardtype);
        cus.setCreditCardNum(cardnum);
        
        em.persist(cus);
        utx.commit();
        em.close();
        PrintWriter out = response.getWriter();
        out.println("<label class='success'>update success</lable>");
    } catch (NotSupportedException ex) {
        ex.printStackTrace();
    } catch (SystemException ex) {
        ex.printStackTrace();
    } catch (RollbackException ex) {
        Logger.getLogger(updatecard.class.getName()).log(Level.SEVERE, null, ex);
    } catch (HeuristicMixedException ex) {
        Logger.getLogger(updatecard.class.getName()).log(Level.SEVERE, null, ex);
    } catch (HeuristicRollbackException ex) {
        Logger.getLogger(updatecard.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SecurityException ex) {
        Logger.getLogger(updatecard.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalStateException ex) {
        Logger.getLogger(updatecard.class.getName()).log(Level.SEVERE, null, ex);
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
