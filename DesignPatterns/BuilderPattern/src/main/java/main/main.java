/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;

import classes.Pizza;
import classes.PizzaBuilder;


/**
 *
 * @author ManuelAlonso
 */
public class main {

    public static void main(String[] args) {
        
        Pizza myPizza = new PizzaBuilder("Supreme","Thick")
                .addCheese(true).addMeat(true).build();
        
        System.out.println(myPizza.toString());
       
    }
}
