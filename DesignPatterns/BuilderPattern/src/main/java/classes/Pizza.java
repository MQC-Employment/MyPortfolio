/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author ManuelAlonso
 */
public class Pizza {
    
    private String pizzaName;
    private String mass;
    private boolean cheese;
    private boolean meat;
    private boolean pepperoni;

    protected Pizza(PizzaBuilder myPizzaBuilder) {
        
        this.pizzaName = myPizzaBuilder.getPizzaName();
        this.mass =  myPizzaBuilder.getMass();
        this.cheese = myPizzaBuilder.hasCheese() ;
        this.meat = myPizzaBuilder.hasMeat();
        this.pepperoni = myPizzaBuilder.hasPepperoni();
        
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public boolean isCheese() {
        return cheese;
    }

    public void setCheese(boolean cheese) {
        this.cheese = cheese;
    }

    public boolean isMeat() {
        return meat;
    }

    public void setMeat(boolean meat) {
        this.meat = meat;
    }

    public boolean isPepperoni() {
        return pepperoni;
    }

    public void setPepperoni(boolean pepperoni) {
        this.pepperoni = pepperoni;
    }

    @Override
    public String toString() {
        return "Pizza{" + "pizzaName=" + pizzaName + ", mass=" + mass + ", cheese=" + cheese + ", meat=" + meat + ", pepperoni=" + pepperoni + '}';
    }


    
}
