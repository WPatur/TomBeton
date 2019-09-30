/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;  
import java.sql.*;  
import javax.servlet.http.*; 
/**
 *
 * @author wojte
 */ 
  
public class Register extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String n=request.getParameter("userName");  
String p=request.getParameter("userPass");  
String e=request.getParameter("userEmail");  
          
try{  
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    Connection connection = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-LRI3PN7A;databaseName=WebApp;integratedsecurity=true");

    PreparedStatement ps=connection.prepareStatement(  
    "insert into Persons (email, login, pass) values(?,?,?);  ");  

    ps.setString(1,e);  
    ps.setString(2,n);  
    ps.setString(3,p);   
    int i=ps.executeUpdate();  
    if(i>0)  
//    out.print("You are successfully registered...");  
    response.sendRedirect("index.jsp");

    }catch (Exception e2) {System.out.println(e2);}  

    out.close();  
}  
  
}  