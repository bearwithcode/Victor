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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author Victor
 */
public class searchshow extends HttpServlet {

   
    
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
            
            out.println("<h1>what is at entertainment center</h1>"); 
            out.println("<form method='post' action='searchshow'>");
            out.println("<fieldset>");
            out.println("<legend>Search for shows</legend>");
            
            out.println("<label for='st'>Show type</label>");
            out.println("<select id='st' name = 'st'>");       
            out.println("<option value='Drama'>Drama</option>");
            out.println("<option value='Film'>Film</option>");
            out.println("<option value='Opera'>Opera</option>");
            out.println("<option value='Jazz'>Jazz</option>");
            out.println("<option value='World Music'>World Music</option>");
            out.println("<option value='Ballet'>Ballet</option>");
            out.println("<option value='Recital'>Recital</option>");
            out.println("<option value='Concert'>Concert</option>");
            out.println("<option value='Choral'>Choral</option>");
            out.println("<option value='Contemporary Dance'>Contemporary Dance</option>");
            out.println("<option value='Comedy'>Comedy</option>");
            out.println("<option value='Children'>Children</option>");
            out.println("</select><br>");
            
            out.println("<label for='ve'>Venue</label>");
            out.println("<select id='ve' name='ve'>");
            out.println("<option value='Opera'>Opera</option>");
            out.println("<option value='Concert'>Concert</option>");
            out.println("<option value='Playhouse'>Playhouse</option>");
            out.println("<option value='Studio'>Studio</option>");
            out.println("</select><br>");
            
            out.println("<label for='sd'>Start date</label>");
            out.println("<input type='date' id='sd' name = 'sd'><br>");
            
            out.println("<label for='ed'>End date</label>");
            out.println("<input type='date' id='ed' name = 'ed'><br>");
            
            out.println("<input type='submit' value='Search'>");
            out.println("</fieldset>") ;
            out.println("</form>");
            
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
            
                    
            
            String st = request.getParameter("st");
            String ve = request.getParameter("ve");
            String sd = request.getParameter("sd");
            String ed = request.getParameter("ed");
            
            Context inictx = null;
            try {
                inictx = new InitialContext();
            } catch (NamingException ex) {
               ex.printStackTrace();
            }
            DataSource ds = (DataSource)inictx.lookup("jdbc/entertaimentDatasource");
            Connection dbcon = ds.getConnection();
            Statement stmt = dbcon.createStatement();
            
            String sql = "SELECT * FROM ecpresentations where venue = '" + ve +"' and genre = '"+ st +"' and startseason >= '" +sd + "' and endseason <= '" + ed +"'";
            
            ResultSet rs = stmt.executeQuery(sql);
            
                   
            out.println("<h1>Shows on at entertainment center</h1>"+
                    "<ul>");
            while(rs.next()){
                out.println("<li><a href='searchreport?title=" + rs.getString("title") + "'>"+ rs.getString("title") +"</a></li>");
            }
            out.println("</ul>");
            
            RequestDispatcher footer = request.getRequestDispatcher("footer");
            footer.include(request, response);
            out.flush();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (NamingException ex) {
            Logger.getLogger(searchshow.class.getName()).log(Level.SEVERE, null, ex);
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
