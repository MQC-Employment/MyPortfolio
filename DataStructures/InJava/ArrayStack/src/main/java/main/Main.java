/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import classes.arraystack.ArrayStack;

/**
 *
 * @author ManuelAlonso
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayStack<Integer> myStack = new ArrayStack<>();
        
        for (int iterator = 1; iterator <= 20; iterator++) {
            
            myStack.pushIn(iterator);
            
        }
        
        while(!myStack.isEmpty()){
            
            System.out.println(myStack.pop());
            
        }
        
    } //End of main method.
    
} //End of main class.
