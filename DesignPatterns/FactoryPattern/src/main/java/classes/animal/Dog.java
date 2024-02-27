/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.animal;

import interfaces.animal.Animal;

/**
 *
 * @author ManuelAlonso
 */
public class Dog implements Animal {
    
    @Override
    public String makeSound(){
        
        return "Woof!";
        
    }
    
    @Override
    public String getAnimalType(){
        
        return "Dog";
        
    }
    
}
