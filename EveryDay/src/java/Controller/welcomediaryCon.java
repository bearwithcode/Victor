/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
import model.Diary;
import static model.Diary_.diaryDate;
import model.Login;

/**
 *
 * @author victor
 */
public class welcomediaryCon extends HttpServlet {

    @PersistenceUnit(unitName = "EveryDayPU")
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
        String user = request.getRemoteUser();
        EntityManager em = emf.createEntityManager();

        final String NEW_FORMAT = "MM/dd/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(NEW_FORMAT);
        
        Map<String, Integer> diariesMap = new HashMap<String, Integer>();

        Login lg = em.find(Login.class, user);
        em.refresh(lg);
        List<Diary> diaries = null;
        diaries = lg.getDiaryList();

        for (Diary d : diaries) {
            if (diariesMap.containsKey(sdf.format(d.getDiaryDate()))) {
                diariesMap.put(sdf.format(d.getDiaryDate()), diariesMap.get(sdf.format(d.getDiaryDate())) + 1);
            } else {
                diariesMap.put(sdf.format(d.getDiaryDate()), 1);
            }
        }

        request.setAttribute("user", user);
        request.setAttribute("diaries", diariesMap);

        em.close();
        RequestDispatcher view = request.getRequestDispatcher("welcomeDiary.jsp");
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
        String timeS = request.getParameter("when");
        String content = request.getParameter("newcontent");
        String pic = request.getParameter("pic");
        String user = request.getRemoteUser();
        
        final String NEW_FORMAT = "MM/dd/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(NEW_FORMAT);
        try {
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            Date time = null;
            time = df.parse(timeS);
            utx.begin();
            EntityManager em = emf.createEntityManager();
            Login lg = em.find(Login.class, user);

            boolean find = false;
            List<Diary> nds = lg.getDiaryList();
            for (Diary d : nds) {
                if (sdf.format(d.getDiaryDate()).equals(timeS)) {
                    find = true;
                }
            }

            Diary d = new Diary(Integer.SIZE, time, content);
            if(pic != null)
                d.setPicy(pic);
            
            d.setUsername(lg);
            em.persist(d);
            utx.commit();

            PrintWriter out = response.getWriter();

            if (find == false) {
                out.print(timeS);
            } else {
                out.print("yesrec:" + timeS);
            }

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
        } catch (ParseException ex) {
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
