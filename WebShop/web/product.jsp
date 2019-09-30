<%-- 
Document   : index
Created on : 2019-09-16, 04:54:03
Author     : wojte
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--<link href="../CSS/style.css" rel="stylesheet" type="text/css">-->
<!DOCTYPE html>
<html>
    <head>
        <style><%@include file="/WEB-INF/CSS/style.css"%></style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sklep</title>
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
      	<table cellpadding="2" cellspacing="2" border="1">
		<tr>
			<th>Nr</th>
			<th>Produkt</th>
			<th>Zdjęcie</th>
			<th>Cena</th>
			<th>Kup</th>
		</tr>
                
		<c:forEach var="product" items="${products}">
			<tr>
				<td>${product.id }</td>
				<td>${product.name }</td>
				<td>
					<img src="zdj${product.photo }" width="120">
				</td>
				<td>${product.price }</td>
				<td align="center">
					<a href="kosz?&action=buy&id=${product.id }">Kup</a>
				</td>
			</tr>
		</c:forEach>
	</table>
        </div>
    </body>
    
    
</html>
