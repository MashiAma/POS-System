/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import Model.DBConnection;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author Hp
 */
public class DashboardModel {
    public static String retrieveDataFromDatabase1() throws Exception {
        String data1 = "";
        try (Connection connection = DBConnection.createConnection();
                Statement statement1 = connection.createStatement();
                ResultSet resultSet1 = statement1.executeQuery("SELECT expense from expenses where month='May'")) {
            while (resultSet1.next()) {
                String name1 = resultSet1.getString("expense");
                data1 += name1 + " ";
            }
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Database Error Occured", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        return data1;
    }
   public static String retrieveDataFromDatabase2() throws Exception {
        String data2 = "";
        try (Connection connection = DBConnection.createConnection();
                Statement statement2 = connection.createStatement();
                ResultSet resultSet2 = statement2.executeQuery("SELECT sum(total_bill) as monTotal FROM sales where currentdate between '2023-05-01' and '2023-05-31'")) {
            while (resultSet2.next()) {
                String name2 = resultSet2.getString("monTotal");
                data2 += name2 + " ";
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database Error Occured", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        return data2;
    } 
    
}
