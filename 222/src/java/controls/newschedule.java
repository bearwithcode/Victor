/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controls;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import models.Airplane;
import models.Route;
import models.Schedule;

/**
 *
 * @author Victor
 */
public class newschedule extends HttpServlet {

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
        List<Route> rts = em.createNamedQuery("Route.findAll",Route.class).getResultList();
        
        PrintWriter out = response.getWriter();
        out.println("<tr><th>choose route</th><th>Route ID</th><th>sourceAirport</th><th>destinationAirport</th></tr>");
        
        for(Route rt:rts){
            out.println("<tr><td><button class='btn btn-info' onclick='renderroute(" + rt.getRouteID() + ")'>choose</button></td>" +
                    "<td>" + rt.getRouteID() +"</td><td id = '" + rt.getRouteID() + "s'>" + rt.getSourceAirport().getName() + "</td><td>" + rt.getDestinationAirport().getName() + "</td></tr>");
        }
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
            String Choroute = request.getParameter("Choroute");
            String Chopid = request.getParameter("Chopid");
            String depdates = request.getParameter("depdate");
            String deptime = request.getParameter("deptime");
            String ardates = request.getParameter("ardate");
            String artime = request.getParameter("artime");
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            Date depdate = df.parse(depdates);
            Date ardate = df.parse(ardates);
            
            utx.begin();
            EntityManager em = emf.createEntityManager();
            Route rt = em.getReference(Route.class, Integer.parseInt(Choroute));
            Airplane ap = em.getReference(Airplane.class, Integer.parseInt(Chopid));
            
            Schedule sch = new Schedule();
            sch.setRouteID(rt);
            sch.setPlaneID(ap);
            sch.setDepartDate(depdate);
            sch.setArriveDate(ardate);
            sch.setDepartTime(deptime);
            sch.setArriveTime(artime);
            em.persist(sch);
            utx.commit();
        } catch (NotSupportedException ex) {
            ex.printStackTrace();
        } catch (SystemException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
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
