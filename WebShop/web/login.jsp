<%-- 
Document   : index
Created on : 2019-09-16, 04:54:03
Author     : wojte
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style><%@include file="/WEB-INF/CSS/style.css"%></style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
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
		<form action="Log" method="post">

			Login	
			<input type="text" name="login"/><br>		
		
			Hasło
			<input type="password" name="pass"/>
			
			<input type="submit" value="submit">			
		
		</form>
        </div>
    </body>
</html>
