<%-- 
Document   : koszyk
Created on : 2019-09-28, 10:56:35
Author     : wojte
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <style><%@include file="/WEB-INF/CSS/style.css"%></style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Koszyk</title>
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
          <br>
      <div id="inner">
      <%
      if (cookieName!=null) {
      %>
      	<table cellpadding="2" cellspacing="2" border="1">
		<tr>
			<th>Usuń</th>
			<th>Nr</th>
			<th>Nazwa</th>
			<th>Zdjęcie</th>
			<th>Cena</th>
			<th>Ilość</th>
			<th>Razem</th>
		</tr>
		<c:set var="total" value="0"></c:set>
		<c:forEach var="item" items="${sessionScope.cart }">
			<c:set var="total" value="${total + item.product.price * item.quantity }"></c:set>
			<tr>
				<td align="center">
					<a href="kosz?action=remove&id=${item.product.id }"
					onclick="return confirm('Chcesz usunąć ten produkt?')">X</a>
				</td>
				<td>${item.product.id }</td>
				<td>${item.product.name }</td>
				<td>
					<img src="zdj${item.product.photo }" width="120">
				</td>
				<td>${item.product.price }</td>
				<td>${item.quantity }</td>
				<td>${item.product.price * item.quantity }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6" align="right">Suma</td>
			<td>${total }</td>
		</tr>
	</table>
	<br>
                <form action="zamowienie" method="post">
                    Wysyłka:
                    <select name="wysylka">
                        <option value="osobisty">Odbiór osobisty</option>
                        <option value="wysylka">Wysyłka za pobraniem</option>
                    </select>
                    <br>
                    <input type="submit" value="Zamów">
		</form>
       <% }else{%>
       Zaloguj się bądź Zarejestruj!
       <% }%>
       </div>
    </body>
</html>
