/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

/**
 *
 * @author Hp
 */
import Model.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.sql.SQLException;
import Model.ReportModel;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ReportController {
    ReportModel product1;
    
    public ReportController(ReportModel product1)
    {
        this.product1=product1;
    }
    public ReportController()
    {
        
    } 
    public ArrayList<ReportModel> searchProducts(Date date1, Date date2){
        
        ArrayList<ReportModel> products1=new ArrayList<>();
        try{
            
            Connection con=DBConnection.createConnection();
            Statement stmt=con.createStatement();
            String sql="SELECT item_code, item_name,price, sum( quantity) AS TotalQty, currentdate,sum(unit_total) AS TotalSelling FROM sales_product where currentdate between '"+date1+"' and '"+date2+"' group BY item_code , currentdate order by item_code, currentdate asc";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                ReportModel product2=new ReportModel(rs.getString("item_code"), 
                        rs.getString("item_name"),
                        rs.getString("price"),
                        rs.getString("TotalQty"),
                        rs.getString("TotalSelling"),
                        rs.getString("currentdate"));
                        products1.add(product2);
             
            }
        }
        
        catch(Exception e)
        {
               System.out.println("Products "+products1); 
                
        }
        return products1;
    }
}
