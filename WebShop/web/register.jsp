<%-- 
Document   : register
Created on : 2019-09-18, 01:42:54
Author     : wojte
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--<%@include file="/WEB-INF/CSS/style.css"%>-->
<!DOCTYPE html>
<html>
        <head>
            <style><%@include file="/WEB-INF/CSS/style.css"%></style>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Rejestracja</title>
        </head>
<body> 
        <ul>
        <li> TOM-BETON</li>
        <li><a href="index.jsp">Produkty</a></li>
        <li><a href="koszyk.jsp">Koszyk</a></li>

         <%
         Cookie[] cookies = null;
         cookies = request.getCookies();
         Cookie cookieName = null;
         if (cookies!=null){
            for (Cookie cookie : cookies) {
               if (cookie.getName().equals("name")) {
                   cookieName=cookie;
                   break;
               }
            }
         }
         if (cookieName!=null) {
            %>
            <li><a href="LogOut">Wyloguj</a></li>
            <%
            }
         else {
             %>
             <li><a href="login.jsp">Zaloguj</a></li>
             <li><a href="register.jsp">Rejestracja</a></li>
             <%
              }
      %>
    </ul>
      
      
    <div id="inner">
    <form action="Register" method="post">  

    Login:<input type="text" name="userName"/><br/><br/>  
    Hasło<input type="password" name="userPass"/><br/><br/>  
    Email:<input type="text" name="userEmail"/><br/><br/>  
    <br/><br/>  
    <input type="submit" value="register"/>  

    </form>
    </div>
</body>  
</html>  
