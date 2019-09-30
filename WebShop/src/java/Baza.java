/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author wojte
 */
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import overall.Product;
        
public class Baza {
    Connection con;
    Statement st;
    ResultSet rs;

    public Baza() {
    }
            
    public void loadDB() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-LRI3PN7A;databaseName=WebApp;integratedsecurity=true");
            st = con.createStatement();
        } catch (Exception ex) {
            System.out.println("Cant load DB");
        }

    }

    public ArrayList<Product> selectAllProduct() throws SQLException {
        ArrayList<Product> pArrList = new ArrayList<>();
        loadDB();
        String sql = "select * from Products";
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                int product_id = Integer.parseInt(rs.getString("product_id"));
                String name = rs.getString("name");
                int price = Integer.parseInt(rs.getString("price"));
                String photo = rs.getString("photo");
                pArrList.add(new Product(product_id, name,photo, price));
            }

        } catch (SQLException ex) {
            System.out.println("SQL Error");
        } finally {
            //disconnect db
            rs.close();
            st.close();
            con.close();
        }
        return pArrList;
    }
    
        public Product findProduct(String id) throws SQLException {
        Product p = null;
        loadDB();
        String sql = "select * from Products where product_id="+id;
        System.out.println("ID"+id);
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                int product_id = Integer.parseInt(rs.getString("product_id"));
                String name = rs.getString("name");
                int price = Integer.parseInt(rs.getString("price"));
                String photo = rs.getString("photo");
                p=new Product(product_id, name,photo, price);
                System.out.println(p);
            }

        } catch (SQLException ex) {
            System.out.println("SQL Error");
        } finally {
            //disconnect db
            rs.close();
            st.close();
            con.close();
        }
        return p;
    }
        
        public boolean addOrder(int order_id, int product_id, int quantity, String wysylka) throws SQLException{
            loadDB();
            boolean added=false;
            try{
                PreparedStatement ps=con.prepareStatement("insert into Zamowienia (order_id, product_id,quantity,wysylka) values(?,?,?,?);  ");  
                ps.setInt(1,order_id);
                ps.setInt(2,product_id);
                ps.setInt(3,quantity);
                ps.setString(4,wysylka);  
                int i=ps.executeUpdate();
                if(i>0){
                    added=true;
                }
                
            } catch (SQLException ex) {
                System.out.println("SQL Error Order");
            } finally {
                //disconnect db
                rs.close();
                st.close();
                con.close();
            }
            return added;
            }

        public int getMaxOrder() throws SQLException{
           loadDB();
           int value=0;
           String sql = "select max(order_id) from Zamowienia";
           try {
               rs = st.executeQuery(sql);
               if (rs.next()) {
                    value=rs.getInt(1);
               }
                } catch (SQLException ex) {
                    System.out.println("SQL Error");
        } finally {
            //disconnect db
            rs.close();
            st.close();
            con.close();
           }
           return value;
        }
}