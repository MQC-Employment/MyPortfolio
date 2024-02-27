/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factories;

import classes.animal.Duck;
import classes.animal.Dog;
import interfaces.animal.Animal;
import interfaces.AbstractFactory.AbstracFactory;

/**
 *
 * @author ManuelAlonso
 */
public class AnimalFactory implements AbstracFactory<Animal>{
    
    @Override
    public Animal create(String whatToCreateP){
        
        switch (whatToCreateP.toLowerCase()) {
            
            case "dog" -> {
                
                Dog dog = new Dog();
                
                return dog;               
            }
                
            case "duck" -> {
                
                Duck duck = new Duck();
                
                return duck;
            }
            
            default -> {
                
                return null;
            }
                
        } //End of switch.
        
    } //End of create.
    
} //end of class.
