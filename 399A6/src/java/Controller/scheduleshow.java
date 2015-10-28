/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.Ecperformances;
import Model.Ecpresentations;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.servlet.RequestDispatcher;
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

/**
 *
 * @author Victor
 */
public class scheduleshow extends HttpServlet {

    @PersistenceUnit(unitName="399A6PU")
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
        RequestDispatcher view = request.getRequestDispatcher("scheduleshow.jsp");
        view.forward(request, response);
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
            String sid = request.getParameter("showid");
            String title = request.getParameter("title");
            String venue = request.getParameter("ve");
            String genre = request.getParameter("st");
            String sds = request.getParameter("sd");
            String eds = request.getParameter("ed");
            
            String com = request.getParameter("com");
            String des = request.getParameter("des");
            
            String per = request.getParameter("per");
            
            List<String> stime = new ArrayList<String>();
            List<String> sdate = new ArrayList<String>();
            
            String buff[] = per.split(";");
            for(String substr:buff){
                if(substr == "")
                    break;
                substr = substr.trim();
                String elestr[] = substr.split(",");
                if(elestr.length < 2)
                    break;
                stime.add(elestr[1].trim());
                sdate.add(elestr[0].trim());
            }
            
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date sd = null,ed = null;
            
            sd = df.parse(sds);
            ed = df.parse(eds);    
                  
                  
            Ecpresentations ecpre = new Ecpresentations(sid,venue,sd,ed,genre,title,com,des);
            
            List<Ecperformances> ecperformancesList = new ArrayList<Ecperformances>();
            
            for(int i = 0;i < stime.size();i ++){    
                Ecperformances temp = new Ecperformances();
                temp.setShowid(ecpre);
                temp.setShowtime(stime.get(i));
                temp.setShowdate(df.parse(sdate.get(i)));
                ecperformancesList.add(temp);
            }
            
            ecpre.setEcperformancesList(ecperformancesList);
            utx.begin();
            EntityManager em = emf.createEntityManager();
            em.persist(ecpre);
            utx.commit();
            em.close();
            
            request.setAttribute("title", title);
            request.setAttribute("sid", sid);
            RequestDispatcher view = request.getRequestDispatcher("schedulereport.jsp");
            view.forward(request, response);
        
        } catch (NotSupportedException ex) {
            ex.addSuppressed(ex);
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
