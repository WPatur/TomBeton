/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wojte
 */
import java.sql.*;

public class Validate {
    public static boolean checkUser(String login,String pass) 
    {
        boolean st =false;
        try {

            //loading drivers for mysql
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-LRI3PN7A;databaseName=WebApp;integratedsecurity=true");
              
            PreparedStatement ps = connection.prepareStatement("select * from Persons where login=? and pass=?");
            ps.setString(1, login);
            ps.setString(2, pass);
            ResultSet rs =ps.executeQuery();
            st = rs.next();
            //koniec polaczenia
            rs.close();
            connection.close();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;                 
    }   
}