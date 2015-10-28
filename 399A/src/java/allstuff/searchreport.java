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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
public class searchreport extends HttpServlet {

    

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
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            RequestDispatcher header = request.getRequestDispatcher("header");
            header.include(request, response);
            
            String driver = getServletContext().getInitParameter("drivername");
            String db = getServletContext().getInitParameter("database");
            String user = getServletContext().getInitParameter("usr");
            String psd = getServletContext().getInitParameter("passwd");
            
            Class.forName(driver);
            Connection con = DriverManager.getConnection(db,user,psd);
            String title = request.getParameter("title");
            
            
            String sql1 = "SELECT * FROM ecpresentations where title = ?";
            PreparedStatement ps = con.prepareStatement(sql1);
            ps.setString(1, title);
            
            String showid = null,com = null,des = null,sd = null,ed = null;
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                showid = rs.getString("mykey");
                com = rs.getString("company");
                des = rs.getString("shortdescription");
                sd = rs.getString("startseason");
                ed = rs.getString("endseason");
            }
            
            String sql2 = "SELECT * FROM ecperformances where pid = ?";
            ps = con.prepareStatement(sql2);
            ps.setString(1, showid);
            
            List<String> stime = new ArrayList<String>();
            List<String> sdate = new ArrayList<String>();
            
            rs = ps.executeQuery();
            while(rs.next()){
                stime.add(rs.getString("showtime"));
                sdate.add(rs.getString("showdate"));
            }
            
            String sql3 = "SELECT * FROM ecinfo where showid = ?";
            ps = con.prepareStatement(sql3);
            ps.setString(1, showid);
            
            List<String> pics = new ArrayList<String>();
            List<String> comms = new ArrayList<String>();
            rs = ps.executeQuery();
            while(rs.next()){
                pics.add(rs.getString("picy"));
                comms.add(rs.getString("details"));
            }
            
            rs.close();
            ps.close();
            con.close();
            
            out.println("<h1>" + title + "</h1>");
            out.println("<h2>" + showid + "</h2>");
            out.println("<h2>On at " + com + " from  " + sd + " to " + ed + "</h2>");
            out.println("<p>" + des + "</p>");
            out.println("<h2>Scheduled performances</h2>"+
                    "<table border='3'>");
            
            for(int i = 0;i < stime.size();i ++){
                out.println("<tr>");
                out.println("<td>"+ stime.get(i) +"</td><td>"+ sdate.get(i)+"</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            
            out.println("<table border='3'>");
            
            for(int i = 0;i < pics.size();i ++){
                out.println("<tr>");
                out.println("<td><img src ='"+ pics.get(i) +"'></td><td><textarea rows = '8' cols = '40' readonly = 'readonly'>"+ comms.get(i)+"</textarea></td>");
                out.println("</tr>");
            }
            
            out.println("</table><br><br>"); 
            
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
