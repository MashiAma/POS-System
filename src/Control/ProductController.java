/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.sql.SQLException;
import Model.ProductModel;
import Model.ProductModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hp
 */
public class ProductController {
    ProductModel product1;
    
    public ProductController(ProductModel product1)
    {
        this.product1=product1;
    }
    public ProductController()
    {
        
    }
    public int addProduct() throws Exception
    {
//        Random random1=new Random();
//        int itemCode=random1.nextInt();
        try
        {
          Connection con=DBConnection.createConnection();
          String sql="insert into products(itemCode,itemName,itemQty, itemPrice) values"
                + "('"+product1.itemCode+"','" +product1.itemName+ "','" +product1.itemQty+"','" +product1.itemPrice+"')";
          PreparedStatement stmt=con.prepareStatement(sql);
          int i=stmt.executeUpdate();  
          if(i==1)
          {
              return 1;        
          }
          else{
              return 2;
          } 
        }
        catch(SQLException e){
           
            return 3;
        }
        
        catch(Exception e){
           
            return 4;
        }
               
    }
    public int deleteProduct()
    {
        try
        {
          Connection con=DBConnection.createConnection();
          String sql="delete from products where itemCode='"+product1.itemCode+"'";
          PreparedStatement stmt=con.prepareStatement(sql);
          int i=stmt.executeUpdate();  
          if(i==1)
          {
              return 1;       
          }
          else{
              return 2;
          } 
        }
        
        catch(SQLException e){
           
            return 3;
        }
        
        
        catch(Exception e){
           
            return 4;
        }
        
    }
    
    public int updateProduct()
    {

        try
        {
          Connection con=DBConnection.createConnection();
          String sql="UPDATE products SET itemName='"+product1.itemName+"', itemQty='"+product1.itemQty+"', itemPrice='"+product1.itemPrice+"' where itemCode='"+product1.itemCode+"'";
          PreparedStatement stmt=con.prepareStatement(sql);
          int i=stmt.executeUpdate();  
          if(i==1)
          {
              return 1;        
          }
          else{
              return 2;
          } 
        }
        catch(SQLException e){
           
            return 3;
        }
        
        catch(Exception e){
           
            return 4;
        }
    }
    public void searchProductCode()
    {
        Random random1=new Random();
        int id=random1.nextInt();
        try
        {
          ArrayList<ProductModel> products2=new ArrayList<>();
          Connection con=DBConnection.createConnection();
          String sql="select * from products where itemCode=?";
          PreparedStatement statement1=con.prepareStatement(sql);
          ResultSet rs=statement1.executeQuery();
          while(rs.next())
            {
                rs.getString("itemCode"); 
                rs.getString("itemName");
                rs.getString("itemQty");
                rs.getString("itemPrice");
            }
            
        }
        catch(Exception e){
            System.out.println("Error"+e.getLocalizedMessage());
        }
    }
    
    public ArrayList<ProductModel> fetchProducts(){
        
        ArrayList<ProductModel> products=new ArrayList<>();
        try{
            
            Connection con=DBConnection.createConnection();
            Statement stmt=con.createStatement();
            String sql="select * from products";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                ProductModel product2=new ProductModel(rs.getString("itemCode"), 
                        rs.getString("itemName"),
                        rs.getString("itemQty"),
                        rs.getString("itemPrice"));
                products.add(product2);
            }
        }
        
        catch(Exception e)
        {
               System.out.println("Products "+products); 
                
        }
        return products;
    }
    public ArrayList<ProductModel> searchProducts(String name){
        
        ArrayList<ProductModel> products=new ArrayList<>();
        try{
            
            Connection con=DBConnection.createConnection();
            Statement stmt=con.createStatement();
            String sql="select * from products where itemName like '"+name+"%'";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                ProductModel product2=new ProductModel(rs.getString("itemCode"), 
                        rs.getString("itemName"),
                        rs.getString("itemQty"),
                        rs.getString("itemPrice"));
                        products.add(product2);
             
            }
        }
        
        catch(Exception e)
        {
               System.out.println("Products "+products); 
                
        }
        return products;
    }
}

