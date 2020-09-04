/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author matth
 */
public class Order {
    
    public String id;
    public String customerName;
    public String date;
    public String vehicleDetails;
    public String turboPartNumber;
    public String price;
    public String payment;
    public String fittingRequired;
    public String orderStartedDate;

    public Order(String id, String customerName, String date, String vehicleDetails, String turboPartNumber, String price, String payment, String fittingRequired, String orderStartedDate) {
        this.id = id;
        this.customerName = customerName;
        this.date = date;
        this.vehicleDetails = vehicleDetails;
        this.turboPartNumber = turboPartNumber;
        this.price = price;
        this.payment = payment;
        this.fittingRequired = fittingRequired;
        this.orderStartedDate = orderStartedDate;
    }
    
    
    
    
    
}
