/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author Canyon
 */
public class Inventory {
    int ID;
    String Brand;
    String Model;
    String Functions;
    int Quantity;
    
    public Inventory(int id, 
            String brand, 
            String model,
            String functions, 
            int quantity){
        this.ID = id;
        this.Brand = brand;
        this.Model = model;
        this.Functions = functions;
        this.Quantity = quantity;
    }
    
    public void setID( int new_id ) {
        this.ID = new_id;
    }

    public int getID( ) {
        return this.ID;
    }
    
    public void setBrand(String new_Brand ) {
        this.Brand = new_Brand;
    }

    public String getBrand( ) {
        return this.Brand;
    }
    
    public void setModel(String new_Model ) {
        this.Model = new_Model;
    }

    public String getModel( ) {
        return this.Model;
    }
    
    public void setFunctions(String new_Functions ) {
        this.Functions = new_Functions;
    }

    public String getFunctions( ) {
        return this.Functions;
    }
    
    public void setQuantity( int new_Quantity ) {
        this.Quantity = new_Quantity;
    }

    public int getQuantity( ) {
        return this.Quantity;
    }
  
    
}
