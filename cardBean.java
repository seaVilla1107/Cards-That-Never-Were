/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
//import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.Properties;
//import java.util.Scanner;
import java.sql.*;
//import javax.annotation.ManagedBean;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Estefany
 */
@ManagedBean
@SessionScoped
public class cardBean implements Serializable {
    String link;
   
    /**
     * Creates a new instance of cardBean
     */
    public cardBean() {
        link = "";
    
    }
    
    public String getImagePath() throws SQLException, ClassNotFoundException{
        System.out.println("i am here");
     Class.forName("com.mysql.jdbc.Driver");

        // connect way #1
    String url1 = "jdbc:mysql://cardsnw.czqbofjs6eks.us-west-2.rds.amazonaws.com/CardsNW";
    String user = "root";
    String password = "Banana123";
    Connection conn1 = DriverManager.getConnection(url1, user, password);
    if (conn1 != null) {
    }      
    Statement stmt = conn1.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT imagePath from CardsPic where imageID = 2");
   
    while (rs.next()) {
    link = rs.getString("imagePath");
    System.out.println(link);
     }
       return link;
 
}
 /*public static void main(String[] args) throws InterruptedException, ClassNotFoundException, SQLException {
     cardBean bean = new cardBean();
     System.out.println(bean.getImagePath()); 
           
 }*/

}

