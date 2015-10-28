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
public class scheduleshow extends HttpServlet {

    

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
        
        out.println("<form method='post' action='scheduleshow'>");
        out.println("<h1>Create a new show record</h1>"+
                "<fieldset>"+
                "<legend>Add a show</legend>"+
                "<label for='showid'>Show identifier</label>"+
                "<br><input type='text' id='showid' name='showid'><br>"+
                "<label for='title'>Title</label>"+
                "<br><input type='text' id='title' name='title'><br>"+
                "<label for='venue'>Venue</label>"+
                "<br><select id='ve' name='ve'>"+
                    "<option value='Opera'>Opera</option>"+
                    "<option value='Concert'>Concert</option>"+
                    "<option value='Playhouse'>Playhouse</option>"+
                    "<option value='Studio'>Studio</option>"+
                    "</select><br>"+
                "<label for='st'>Show type</label>"+
                    "<br><select id='st' name = 'st'>"+
                    "<option value='Drama'>Drama</option>"+
                    "<option value='Film'>Film</option>"+
                    "<option value='Opera'>Opera</option>"+
                    "<option value='Jazz'>Jazz</option>"+
                    "<option value='World Music'>World Music</option>"+
                    "<option value='Ballet'>Ballet</option>"+
                    "<option value='Recital'>Recital</option>"+
                    "<option value='Concert'>Concert</option>"+
                    "<option value='Choral'>Choral</option>"+
                    "<option value='Contemporary Dance'>Contemporary Dance</option>"+
                    "<option value='Comedy'>Comedy</option>"+
                    "<option value='Children'>Children</option>"+
                    "</select><br>"+
                "<label for='sd'>From date</label>"+
                    "<br><input type='date' id='sd' name = 'sd'><br>"+
                    "<label for='ed'>To date</label>"+
                    "<br><input type='date' id='ed' name = 'ed'><br>"+
                "<label for='com'>Company</label>"+
                "<input type='text' id='com' name='com'><br>"+
                "<label for='des'>Description</label>"+
                "<br><textarea id='des' name='des' rows='4' cols='40'></textarea><br>"+
                "<label for='per'>Performances</label>"+
                "<br><textarea id='Per' name='per' rows='4' cols='40' readonly = 'readonly'></textarea><br>"+
                "<input type='submit' value='Add event'><br></fieldset><br>");
        
        out.println("</form><br>");
        
        out.println("<fieldset><legend>Enter performance details</legend>"+
                "<label for='st'>Show time</label>"+
                "<br><select id='stime' name='st'>"+
                "<option value='matinee'>matinee</option>"+
                "<option value='evening'>evening</option>"+
                "</select><br>"+
                "<label for=date>Date</label>"+
                "<br><input type='date' id='d' name='date'><br>"+
                "<button onclick='doaddp()'>Add performance</button><br></fieldset>");
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
            
            String si = request.getParameter("showid");
            String title = request.getParameter("title");
            String venue = request.getParameter("ve");
            String st = request.getParameter("st");
            String sd = request.getParameter("sd");
            String ed = request.getParameter("ed");
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
            
            String driver = getServletContext().getInitParameter("drivername");
            String db = getServletContext().getInitParameter("database");
            String user = getServletContext().getInitParameter("usr");
            String psd = getServletContext().getInitParameter("passwd");
            
            Class.forName(driver);
            Connection con = DriverManager.getConnection(db,user,psd);
            
            String sql1 = "INSERT INTO ecpresentations values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql1);
            
            ps.setString(1, si);
            ps.setString(2, venue);
            ps.setString(3, sd);
            ps.setString(4, ed);
            ps.setString(5, st);
            ps.setString(6, title);
            ps.setString(7, com);
            ps.setString(8, des);
            
            int success1 = ps.executeUpdate();
            int success2 = 0;
            String sql2;
            
            for(int i = 0;i < stime.size();i++){
                sql2 = "INSERT INTO ecperformances(showid,showtime,showdate) values(?,?,?)";
                ps = con.prepareStatement(sql2);
                ps.setString(1, si);
                ps.setString(2, stime.get(i));
                ps.setString(3, sdate.get(i));
                success2 += ps.executeUpdate();
            }
            
            
            if(success1 != 0&&success2 != 0){
                out.println("<hr>");
                out.println("<h1>New record added</h1>");
                out.println("<ul>");
                out.println("<li><a href='scheduleshow'>Schedule another event</a></li>");
                out.println("<li><a href='addinfo?si=" + si + "&title="+ title +"'>Add information to show</a></li>");
                out.println("</ul>");
            }
            
            ps.close();
            con.close();
            
            //RequestDispatcher footer = request.getRequestDispatcher("footer");
            //footer.include(request, response);
            //out.flush();
            
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
