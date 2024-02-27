/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factories;

import interfaces.AbstractFactory.AbstracFactory;

/**
 *
 * @author ManuelAlonso
 */
public class FactoryProvider {
    
    public static AbstracFactory getFactory(String typeOfFactoryP){
        
        switch (typeOfFactoryP.toLowerCase()) {
            
            case ("animal") -> {
                
                AnimalFactory  newAnimalFactory = new AnimalFactory();
                
                return newAnimalFactory;
            }
            
            case ("vehicle") -> {
                
                VehicleFactory newVehicleFactory = new VehicleFactory();
                
                return newVehicleFactory;
                
            }
                
            default -> {
                return null;
            }
                
        } //End of switch.
    
    } //End of GetFactory.
    
} //End of class.
