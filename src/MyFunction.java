import java.sql.Connection;
import java.sql.*;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hp
 */
public class MyFunction {
 public static int countData(String tableName)
 {
     int total = 0;
     Connection con = MyConnection.getConnection();
     Statement st;
     try {
         st = con.createStatement();
         ResultSet rs = st.executeQuery("SELECT COUNT(*) AS 'total' FROM "+tableName);
         while(rs.next()){
             total = rs.getInt(1);
         }
     } catch (SQLException ex) {
         Logger.getLogger(MyFunction.class.getName()).log(Level.SEVERE, null, ex);
     }
     
     return total;
 }
}
