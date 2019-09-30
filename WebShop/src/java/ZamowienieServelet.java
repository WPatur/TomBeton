/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import overall.Towar;

/**
 *
 * @author wojte
 */
public class ZamowienieServelet extends HttpServlet {

            @Override
    	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            HttpSession session = request.getSession();
            Baza model =new Baza();
            String wysylka= request.getParameter("wysylka");
            List<Towar> cart = (List<Towar>) session.getAttribute("cart");
                try {
                    int order_id=model.getMaxOrder()+1;
                    for(Towar tr : cart){
                        model.addOrder(order_id,tr.getProduct().getId(),tr.getQuantity(),wysylka);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ZamowienieServelet.class.getName()).log(Level.SEVERE, null, ex);
                }
            session.setAttribute("cart", null);
            response.sendRedirect("koszyk.jsp");
	}


}
