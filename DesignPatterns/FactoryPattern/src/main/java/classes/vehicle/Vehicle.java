/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.vehicle;

/**
 *
 * @author ManuelAlonso
 */
public abstract class Vehicle {
    
    protected String brandName;
    protected String vehicleName;
    
    protected Vehicle(){
        
        
        
    }
    
    protected Vehicle(String brandNameP, String vehicleNameP){
        
        this.brandName = brandNameP;
        this.vehicleName = vehicleNameP;
        
    } 

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }
    
} //End of class. 