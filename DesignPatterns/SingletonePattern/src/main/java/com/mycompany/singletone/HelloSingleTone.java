/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.singletone;

/**
 *
 * @author ManuelAlonso
 */
public class HelloSingleTone {
    
    private static HelloSingleTone instance;
    private static int timesCalled;
    
    public static HelloSingleTone getInstance(){
        
        if(instance==null){
            
            instance = new HelloSingleTone();
            
        }
        
        timesCalled++;
                
        return instance;
        
    }
    
   public void SingleToneDoSomething(){
       
       //I am doing something!
       
   }
        
    public static int getTimesCalled(){
        
        return timesCalled;
        
    }
        
} //End of HelloSingletone.
