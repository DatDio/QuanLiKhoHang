/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;

import java.awt.Component;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 */
public class ConnectDB {
    public  Connection getConnection(){
      Connection conn=null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionString = "jdbc:sqlserver://localhost:1433;" 
            + "databaseName=QuanLiKhoHangTest;encypt=true;trustServerCertificate=true;user=sa;password=110303;";
            conn = DriverManager.getConnection(connectionString);
            
            if(conn != null){
                System.out.println("Ket noi thanh cong!");
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return conn;
    }
    
    //Thực thi câu lệnh SELECT
    public ResultSet ExcuteQueryGetTable(String cauTruyVanSQL){
        ConnectDB cn= new ConnectDB();
        try {
            Connection conn=cn.getConnection();
            Statement stmt = conn.createStatement();           
            ResultSet rs = stmt.executeQuery(cauTruyVanSQL);
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
            
        return null;
    }
    //Thực thi INSERT, DELETE, UPDATE,...
        public void ExcuteQueryUpdateDB(String cauTruyVanSQL){
       ConnectDB cn= new ConnectDB();
        try {
            Connection conn=cn.getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(cauTruyVanSQL);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
public static void closeConnection(Connection conn){
    try {
        if(conn!=null){
            conn.close();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
 
    
}
