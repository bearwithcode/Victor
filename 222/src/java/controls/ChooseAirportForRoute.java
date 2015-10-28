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
import models.Airport;

/**
 *
 * @author Victor
 */
public class ChooseAirportForRoute extends HttpServlet {
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
        List<Airport> airports = em.createNamedQuery("Airport.findAll",Airport.class).getResultList();
        
        PrintWriter out = response.getWriter(); 
            out.println(
        "    <tr>\n" +
        "    <th>manage</th><th>ID</th><th>Name</th><th>City</th><th>Country</th><th>ITIA</th><th>Latitude</th><th>Longitude</th><th>Altitude</th><th>Timezone</th><th>DST</th>\n" +
        "    </tr>");
            
        for(Airport airport:airports){
                out.println("<tr id='" + airport.getAirportID() + "'><td><button onclick='getiata(\"" + airport.getIata() + "\")' type='button' class='btn btn-warning ' data-toggle='modal' data-target='#addtoroute' >addroute</button></td><td>" + 
                        airport.getAirportID() + "</td><td>" + airport.getName() + "</td><td>" + airport.getCity() + "</td><td>" + airport.getCountry() +
                        "</td><td>" + airport.getIata() + "</td><td>" + 
                        airport.getLatitude() + "</td><td>" + airport.getLongitude() + 
                        "</td><td>" + airport.getAltitude() + "</td><td>" + airport.getTimeZone() + "</td><td>" + airport.getDst() + "</td></tr>");
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
