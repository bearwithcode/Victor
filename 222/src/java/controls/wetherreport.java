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
import models.Schedule;

/**
 *
 * @author Victor
 */
public class wetherreport extends HttpServlet {
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
        List<Schedule> schs = em.createNamedQuery("Schedule.findAll").getResultList();
        
        PrintWriter out = response.getWriter(); 
        out.println("<tr><th>re-arrange</th><th>schedule ID</th><th>departure date</th><th>Arrive date</th></tr>");
        
        for(Schedule sch:schs){
            String ds[] = sch.getDepartDate().toString().split(" ");
            String as[] = sch.getArriveDate().toString().split(" ");
            out.println("<tr><td><button data-toggle='modal' data-target='#changedatewt' class='btn btn-warning' onclick='getidforre(" + sch.getScheduleID() + ")'>re-arrange</button></td><td>" + sch.getScheduleID() + "</td><td id='" 
                    + sch.getScheduleID() + "dw'>" + ds[0] + " " + ds[1] + " " + ds[2] + "</td><td id = '" + sch.getScheduleID() +"aw'>" 
                    + as[0] + " " + as[1] + " " + as[2] + "</td></tr>");
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
        String chw = request.getParameter("chw");
        String depdatew = request.getParameter("depdatew");
        String adatew = request.getParameter("adatew");
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        
        Date dep = df.parse(depdatew);
        Date ar = df.parse(adatew);
        
        utx.begin();
        EntityManager em = emf.createEntityManager();
        Schedule sch = em.getReference(Schedule.class, Integer.parseInt(chw));
        sch.setDepartDate(dep);
        sch.setArriveDate(ar);
        em.persist(sch);
        utx.commit();
        String Darray[] = sch.getDepartDate().toString().split(" ");
        String Aarray[] = sch.getArriveDate().toString().split(" ");
        
        String destring = Darray[0] + " " + Darray[1] + " " + Darray[2];
        String astring = Aarray[0] + " " + Aarray[1] + " " + Aarray[2];
        String result = destring + ":" + astring;
        PrintWriter out = response.getWriter();
        out.print(result);
        em.close();
        
    } catch (ParseException ex) {
        Logger.getLogger(wetherreport.class.getName()).log(Level.SEVERE, null, ex);
    } catch (NotSupportedException ex) {
        Logger.getLogger(wetherreport.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SystemException ex) {
        Logger.getLogger(wetherreport.class.getName()).log(Level.SEVERE, null, ex);
    } catch (RollbackException ex) {
        Logger.getLogger(wetherreport.class.getName()).log(Level.SEVERE, null, ex);
    } catch (HeuristicMixedException ex) {
        Logger.getLogger(wetherreport.class.getName()).log(Level.SEVERE, null, ex);
    } catch (HeuristicRollbackException ex) {
        Logger.getLogger(wetherreport.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SecurityException ex) {
        Logger.getLogger(wetherreport.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalStateException ex) {
        Logger.getLogger(wetherreport.class.getName()).log(Level.SEVERE, null, ex);
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
