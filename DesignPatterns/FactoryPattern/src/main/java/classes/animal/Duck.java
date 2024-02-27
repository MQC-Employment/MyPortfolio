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
public class Duck implements Animal{

    @Override
    public String makeSound() {
        
        return "Quack!";
        
    }

    @Override
    public String getAnimalType() {
        
        return "Duck.";
        
    }
    
}
