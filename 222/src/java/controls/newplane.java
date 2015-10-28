/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controls;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import models.Fleet;
import models.Seat;

/**
 *
 * @author Victor
 */
public class newplane extends HttpServlet {


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
        String fid = request.getParameter("fleetid");
        
        EntityManager em = emf.createEntityManager();       
        Fleet ft = em.getReference(Fleet.class, Integer.parseInt(fid));
        em.refresh(ft);
        List<Airplane> aps = ft.getAirplaneList();
        
         PrintWriter out = response.getWriter(); 
         out.println("<tr><th>Plane ID</th><th>firstClass</th><th>businessClass</th><th>premiumClass</th><th>economyClass</th><th>total</th></tr>");
         
         for(Airplane ap:aps){
             out.println("<tr><td>" + ap.getPlaneID() + "</td><td>" + ap.getFirstClass() + "</td><td>" + ap.getBusinessClass() + "</td><td>" + ap.getPremiumClass() + "</td><td>" + ap.getEconomyClass() +"</td><td>" + ap.getTotal() + "</td></tr>");
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
            String fleetid = request.getParameter("choosing3");
            String fclass = request.getParameter("fclass");
            String bclass = request.getParameter("bclass");
            String eclass = request.getParameter("eclass");
            String pclass = request.getParameter("pclass");
            
            int fclassn = Integer.parseInt(fclass);
            int bclassn = Integer.parseInt(bclass);
            int eclassn = Integer.parseInt(eclass);
            int pclassn = Integer.parseInt(pclass);
            
            int total = fclassn + bclassn + eclassn + pclassn;
            
            utx.begin();
            EntityManager em = emf.createEntityManager();
            Airplane ap = new Airplane();
            Fleet ft = em.getReference(Fleet.class, Integer.parseInt(fleetid));
            int isv = ft.getInService();
            ft.setInService(isv + 1);
            ap.setOnefleet(ft);
            ap.setFirstClass(fclassn);
            ap.setBusinessClass(bclassn);
            ap.setEconomyClass(eclassn);
            ap.setPremiumClass(pclassn);
            ap.setTotal(total);
            
            List<Seat> seats = new ArrayList<Seat>();
            int f = 0,b = 0,e = 0,p = 0;
            for(int i = 0;i < total; i++){
                Seat s = new Seat();
                if(i < fclassn){
                    s.setPlaneID(ap);
                    s.setSeatClass("first");
                    s.setSeatNumber(f + "F");                    
                    f ++;
                }
                else if(i >= fclassn && i < fclassn + bclassn){
                    s.setPlaneID(ap);
                    s.setSeatClass("business");
                    s.setSeatNumber(b + "B");
                    b ++;
                }
                else if(i >= fclassn + bclassn && i < fclassn + bclassn + eclassn){
                    s.setPlaneID(ap);
                    s.setSeatClass("economy");
                    s.setSeatNumber(e + "E");
                    e ++;
                }
                else if(i >= fclassn + bclassn + eclassn){
                    s.setPlaneID(ap);
                    s.setSeatClass("premium");
                    s.setSeatNumber(p + "P");
                    p ++;
                }
                s.setOccupied(false);
                seats.add(s);
            }
            ap.setSeatList(seats);
            em.persist(ap);
            utx.commit();
            
            PrintWriter out = response.getWriter(); 
            out.println(isv + 1);
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
