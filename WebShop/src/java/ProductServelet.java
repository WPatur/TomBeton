/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import overall.Product;

/**
 *
 * @author wojte
 */
@WebServlet("/product")
public class ProductServelet extends HttpServlet {

        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Baza productModel = new Baza();
                ArrayList<Product> products= new ArrayList();
                try {
                    products = productModel.selectAllProduct();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductServelet.class.getName()).log(Level.SEVERE, null, ex);
                }
		request.setAttribute("products", products);
                System.out.println(products);
                for(Product pr : products){
                    System.out.println(pr.getId());
                }
		request.getRequestDispatcher("product.jsp").forward(request, response);
	}

        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
