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
import models.Airport;
import models.Route;

/**
 *
 * @author Victor
 */
public class createroute extends HttpServlet {

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
            String source = request.getParameter("source");
            String destination = request.getParameter("destination");
            String cshare = request.getParameter("cshare");
            String stops = request.getParameter("stops");
            String international = request.getParameter("international");
            
            utx.begin();
            EntityManager em = emf.createEntityManager();
            Route rt = new Route();
            Airport aps = em.getReference(Airport.class, source);
            Airport apd = em.getReference(Airport.class, destination);
            rt.setSourceAirport(aps);
            rt.setDestinationAirport(apd);
            rt.setCodeShare(cshare);
            if(!stops.equals("")){
                rt.setStops(Integer.parseInt(stops));
            }
            if(!international.equals("")){
                if(international.equals("1")){
                    rt.setInternationalFlight(true);
                }
            }
            else{
                rt.setInternationalFlight(false);
            }
            em.persist(rt);
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
