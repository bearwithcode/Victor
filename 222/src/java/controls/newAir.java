/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controls;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;
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


/**
 *
 * @author Victor
 */
public class newAir extends HttpServlet {
   
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
        "    <th>Remove</th><th>ID</th><th>Name</th><th>City</th><th>Country</th><th>ITIA</th><th>Latitude</th><th>Longitude</th><th>Altitude</th><th>Timezone</th><th>DST</th>\n" +
        "    </tr>");
            
            for(Airport airport:airports){
                out.println("<tr id='" + airport.getIata() + "'><td><button onclick = 'confirmremoveair(\"" + 
                        airport.getIata() +"\")' type='button' class='btn btn-warning ' data-toggle='modal' data-target='#deleteAR' >remove</button></td><td>" + 
                        airport.getAirportID() + "</td><td>" + airport.getName() + "</td><td>" + airport.getCity() + "</td><td>" + airport.getCountry() +
                        "</td><td>" + airport.getIata() + "</td><td>" + airport.getLatitude() + "</td><td>" + airport.getLongitude() + 
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
        try {
            String airname = request.getParameter("airname");
            String aircity = request.getParameter("aircity");
            String aircou = request.getParameter("aircou");
            String airIata = request.getParameter("airIata");
            String airLat = request.getParameter("airLat");
            String airLon = request.getParameter("airLon");
            String altitude = request.getParameter("altitude");
            String timezone = request.getParameter("timezone");
            String dst = request.getParameter("dst");
            
            Random random = new Random();
            int airiD = random.nextInt(9999);
            
            utx.begin();
            EntityManager em = emf.createEntityManager();
            Airport apt = new Airport();
            apt.setAirportID(airiD);
            apt.setName(airname);
            apt.setCity(aircity);
            apt.setCountry(aircou);
            apt.setIata(airIata);
            apt.setLatitude(Double.parseDouble(airLat));
            apt.setLongitude(Double.parseDouble(airLon));
            apt.setAltitude(Integer.parseInt(altitude));
            apt.setTimeZone(timezone);
            apt.setDst(dst);
            em.persist(apt);
            utx.commit();
            PrintWriter out = response.getWriter();
            out.print(airiD + ":" +airIata);
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
