/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;

import classes.vehicle.airplane.JetAirPlane;
import factories.FactoryProvider;

/**
 *
 * @author ManuelAlonso
 */
public class main {

    public static void main(String[] args) {
        
        JetAirPlane myVehicle = (JetAirPlane)FactoryProvider.getFactory("vehicle").create("jetplane");
        
        try {
            
            myVehicle.setBrandName("Boing");
            myVehicle.setVehicleName("747");
            myVehicle.setNumberOfJetEngines(4);
            myVehicle.setNumberOfWheelsInLandingGear(12);
            
            myVehicle.takeOff();
            myVehicle.land();
            
            System.out.println(myVehicle);
            
        } catch (Exception e) {
            
            System.out.println("Error: " + e);
            
        }
           
    } //End of main.
    
} //End of class.