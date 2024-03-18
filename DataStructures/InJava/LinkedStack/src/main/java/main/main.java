/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import classes.linkededstack.LinkedStack;

/**
 *
 * @author ManuelAlonso
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        LinkedStack<Integer> myStack = new LinkedStack();
        
        myStack.pushIn(1);
        myStack.pushIn(100);
        myStack.pushIn(-5);
        myStack.pushIn(20);
        
        while(!myStack.isEmpty()){
            
            System.out.println(myStack.pop());
            
        }
        
    } //end of main.
    
} //End of main class.
