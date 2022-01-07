/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author trant
 */
public class databaseUtils {
     private static final String DATABASE_URL = "jdbc:mysql://localhost/minimarket?serverTimezone=UTC";
    private static final String DATABASE_USER_NAME = "root";
    private static final String DATABASE_PASSWORD = "";
 
    public static final String connectionUrl= "DATABASE_URL, DATABASE_USER_NAME, DATABASE_PASSWORD";
    public static Connection getDBConnect(){
        Connection con=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(DATABASE_URL, DATABASE_USER_NAME, DATABASE_PASSWORD);
             
            return con;
        } catch (Exception e) {
            System.out.println("fail roi");
        }
        return null;
    }
    public static void main(String[] args) {
        getDBConnect();
    }
}
