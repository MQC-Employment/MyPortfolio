/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factories;

import classes.vehicle.Vehicle;
import classes.vehicle.airplane.AirscrewAirPlane;
import classes.vehicle.airplane.JetAirPlane;
import interfaces.AbstractFactory.AbstracFactory;

/**
 *
 * @author ManuelAlonso
 */
public class VehicleFactory implements AbstracFactory<Vehicle>{

    @Override
    public Vehicle create(String whatToCreateP) {
        
        switch (whatToCreateP.toLowerCase()) {
            case ("jetplane") -> {
                
                return new JetAirPlane();
                
            }
            
            case ("airscrewplane") -> {
                
                return new AirscrewAirPlane();
                
            } default -> {
                
                return null;
            
            }
                
        } //End of swith.
        
    } //End of create Method.
    
} //End of class!
