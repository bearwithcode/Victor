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
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import models.Airplane;
import models.Airport;
import models.Route;
import models.Schedule;

/**
 *
 * @author Victor
 */
public class searchschedule extends HttpServlet {

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
        try {
            String sdates = request.getParameter("start");
            String edates = request.getParameter("end");
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            
            Date sdate = null,edate = null;
            sdate = df.parse(sdates);
            edate = df.parse(edates);
                    ;  
            EntityManager em = emf.createEntityManager();
            String jpql = "SELECT s FROM Schedule s WHERE s.departDate >= ?1 AND s.arriveDate <= ?2";
            Query query = em.createQuery(jpql);
            query.setParameter(1, sdate,TemporalType.DATE);
            query.setParameter(2, edate,TemporalType.DATE);
            
            List<Schedule> schs = (List<Schedule>)query.getResultList();
            PrintWriter out = response.getWriter(); 
            out.println("<tr><th>booking</td><th>departure time</th><th>arrive time</th><th>from</th><th>to</th><th>plane ID</th></tr>");
            for(Schedule sch:schs){
                Route temprt = sch.getRouteID();
                
                Airport fromA = temprt.getSourceAirport();
                String fromCou = fromA.getCountry();
                String fromCity = fromA.getCity();
                String from = fromCity + " " + fromCou;
                
                Airport toA = temprt.getDestinationAirport();
                String toCou = toA.getCountry();
                String tocity = toA.getCity();
                String to = tocity + " " + toCou;
                
                Airplane tempap = sch.getPlaneID();
                int planeid = tempap.getPlaneID();
                out.println("<tr><td><button onclick='fillforticket(" + sch.getScheduleID() + ")' class='btn btn-info ' data-toggle='modal' data-target='#confirmbooking'>book</button>" +
                        "</td><td>" + sch.getDepartTime() + "</td><td>" + sch.getArriveTime() + "</td><td>" + from + "</td><td>" + to + "</td><td>" + planeid + "</td></tr>");
            }
                
            em.close();
        } catch (ParseException ex) {
            Logger.getLogger(searchschedule.class.getName()).log(Level.SEVERE, null, ex);
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
