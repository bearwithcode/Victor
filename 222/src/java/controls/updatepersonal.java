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
import javax.servlet.http.HttpSession;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import models.Customer;
import models.Login;

/**
 *
 * @author Victor
 */
public class updatepersonal extends HttpServlet {
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
                String title = request.getParameter("title");
                String lastname = request.getParameter("lname");
                String firstname = request.getParameter("fname");
                String genders[] = request.getParameterValues("gender[]");
                
                String gender;
                if(genders[0] != ""){
                    gender = "male";
                }
                else{
                    gender = "female";
                }
                
                String year = request.getParameter("year");
                String month = request.getParameter("month");
                String day = request.getParameter("day");
                String dobs = year + "-" + month + "-" + day;
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                Date dob = null;
                
                dob = df.parse(dobs);
                
                
                String disphone = request.getParameter("dis");
                String phonenum = request.getParameter("phnum");
                String phone = disphone + "-" + phonenum;
                
                String email = request.getParameter("email");
                String street = request.getParameter("sadd");
                String state = request.getParameter("state");
                String city = request.getParameter("city");
                String country = request.getParameter("cou");
                String passport[] = request.getParameterValues("passport[]");
                boolean pholder = false;
                if(passport == null ||passport[0] != "")
                    pholder = false;
                else
                    pholder = true;
                
                HttpSession hs=request.getSession(true);
                String user = (String)hs.getAttribute("username");
                
                utx.begin();
                EntityManager em = emf.createEntityManager();
                Login lg = em.find(Login.class, user);
                Customer cus = lg.getCustomer();
                if(!title.equals(""))
                    cus.setTitle(title);
                if(!lastname.equals(""))
                    cus.setLastName(lastname);
                if(!firstname.equals(""))
                    cus.setFirstName(firstname);
                if(!gender.equals(""))
                    cus.setGender(gender);
                if(dob != null)
                    cus.setDob(dob);
                if(!phone.equals(""))
                    cus.setPhone(phone);
                if(!email.equals(""))
                    cus.setEmail(email);
                if(!street.equals(""))
                    cus.setStreetAddress(street);
                if(!state.equals(""))
                    cus.setState(state);
                if(!city.equals(""))
                    cus.setCity(city);
                if(!country.equals(""))
                    cus.setCountry(country);
                
                    cus.setPassportHolder(pholder);
                
                em.persist(cus);
                utx.commit();
                em.close();
                PrintWriter out = response.getWriter();
                out.println("<label class='success'>update success</lable>");
            } catch (NotSupportedException ex) {
                ex.printStackTrace();
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
