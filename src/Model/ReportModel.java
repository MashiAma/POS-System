/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Hp
 */
public class ReportModel {

    public String itemCode;
    public String itemName;
    public String unitPrice;
    public String salesQty;
    public String totalPrice;
    public String date;
    public ReportModel(String itemCode, String itemName, String unitPrice, String salesQty,String totalPrice, String date){
    
        this.itemCode=itemCode;
        this.itemName=itemName;
        this.unitPrice=unitPrice;
        this.salesQty=salesQty;
        this.totalPrice=totalPrice;
        this.date=date;
    

}
}

