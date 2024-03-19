/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import classes.arrayqueue.ArrayQueue;

/**
 *
 * @author ManuelAlonso
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayQueue<Integer> myQueue = new ArrayQueue();
        
        for (int iterator = 1; iterator <= 12; iterator++) {
            
            myQueue.queue(iterator*10);
            
        }
        
        while(!myQueue.isEmpty()){
            
            System.out.println(myQueue.unqueue());
            
        }       
        
    } //end of main.
    
} //End of main class.
