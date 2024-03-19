/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import classes.LinkedQueue;

/**
 *
 * @author ManuelAlonso
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        LinkedQueue<Integer> myQueue = new LinkedQueue<>();
        
        for (int iterator = 1; iterator <= 10; iterator++) {
            
            myQueue.queue(iterator*10);
            
        }
        
        while(!myQueue.isEmpty()){
            
            System.out.println(myQueue.unqueue());
            
        }      
        
    } //end of main method.
    
} //end of class.
