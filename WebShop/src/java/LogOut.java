/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author wojte
 */

@WebServlet("/LogOut")
public class LogOut extends HttpServlet {
    
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Cookie[] cookies = request.getCookies();
       for (Cookie cookie : cookies) {
            cookie.setMaxAge(0);
            response.addCookie(cookie);
         }
       
//       request.getRequestDispatcher("index.jsp").include(request, response);
       response.sendRedirect("login.jsp");
   }

}