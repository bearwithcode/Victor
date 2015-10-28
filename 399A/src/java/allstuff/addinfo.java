/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package allstuff;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Victor
 */
public class addinfo extends HttpServlet {
   

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        RequestDispatcher header = request.getRequestDispatcher("header");
        header.include(request, response);
        
        String sid = request.getParameter("si");
        String title = request.getParameter("title");
        
        if(sid != null&&title != null){
            if(sid != ""&&title != ""){
                out.println("<h1>Details added to " + sid + " : " + title + "<2>");
            }
        }
        
        out.println("<form method='post' action='addinfo'>"+
                "<fieldset><legend>Show</legend>"+
                "<label for='si'>Show identifier</label>"+
                "<input type='text' id='si' name='si'>"+
                "</fieldset>"+
                "<fieldset><legend>Supplementary data</legend>"+
                "<table border='3' id='Myshow'>"+
                "<tr><th>Picture</th><th>Comment</th></tr></table>"+             
                "<input type='button' onclick='doAdd()' value='Add data'>"+
                "</fieldset>"+
                "<fieldset><legend>Action</legend>"+
                "<input type='submit' value='Add details'>"+
                "</fieldset></form>");
        
        RequestDispatcher footer = request.getRequestDispatcher("footer");
        footer.include(request, response);
        out.flush();
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
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            RequestDispatcher header = request.getRequestDispatcher("header");
            header.include(request, response);
            
            String showid = request.getParameter("si");
            
            String[] pics;
            pics = request.getParameterValues("pics[]");
            
            String[] comms;
            comms = request.getParameterValues("comms[]");
            
            String driver = getServletContext().getInitParameter("drivername");
            String db = getServletContext().getInitParameter("database");
            String user = getServletContext().getInitParameter("usr");
            String psd = getServletContext().getInitParameter("passwd");

            
            int success = 0;
            Class.forName(driver);
            Connection con = DriverManager.getConnection(db,user,psd);
            PreparedStatement ps = null;
            for(int i = 0;i < pics.length;i++){
                String sql = "INSERT INTO ecinfo(showid,details,picy) values(?,?,?)";
                ps = con.prepareStatement(sql);
                
                ps.setString(1, showid);
                ps.setString(2, comms[i]);
                ps.setString(3, pics[i]);
                success += ps.executeUpdate();
            }
                
            ps.close();
            con.close();
            
            if(success != 0){
                out.println("<h1>New information added</h1>");
                out.println("<hr><ul>");
                out.println("<li><a href='scheduleshow'>Schedule a  event</a></li>");
                out.println("<li><a href='addinfo'>Add more information to show</a></li>");
                out.println("</ul>");
            }
            
            RequestDispatcher footer = request.getRequestDispatcher("footer");
            footer.include(request, response);
            out.flush();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
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
