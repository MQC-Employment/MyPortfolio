/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author ManuelAlonso
 */
public class PizzaBuilder {
    
    private String pizzaName;
    private String mass;
    private boolean cheese;
    private boolean meat;
    private boolean pepperoni;

    public PizzaBuilder(String pizzaName, String mass) {
        
        this.pizzaName = pizzaName;
        this.mass = mass;
        this.cheese = false;
        this.meat = false;
        this.pepperoni = false;
        
    }
    
    public PizzaBuilder addCheese(boolean cheeseP){
        
        this.cheese = cheeseP;
        
        return this;
        
    }
    
    public PizzaBuilder addMeat(boolean meatP){
        
        this.meat = meatP;
        
        return this;
        
    }
    
    public PizzaBuilder addPepperoni(boolean pepperoniP){
        
        this.pepperoni = pepperoniP;
        
        return this;
        
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public String getMass() {
        return mass;
    }

    public boolean hasCheese() {
        return cheese;
    }

    public boolean hasMeat() {
        return meat;
    }

    public boolean hasPepperoni() {
        return pepperoni;
    }

    public Pizza build(){
        
        return new Pizza(this);
        
    }
    
}
