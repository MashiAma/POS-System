/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Hp
 */
public class DBConnection {

public static Connection createConnection() throws Exception{
    String url="jdbc:mysql://localhost:3306/shopsystem";
    Connection con=DriverManager.getConnection(url, "root", "");
    return con;
    }
}
