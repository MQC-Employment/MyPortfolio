/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.singletone;

/**
 *
 * @author ManuelAlonso
 */
public class Singletone {

    public static void main(String[] args) {
        

        System.out.println("Times called: " + HelloSingleTone.getInstance().getTimesCalled());
        
        HelloSingleTone.getInstance().SingleToneDoSomething();
        
        System.out.println("Times called: " +  HelloSingleTone.getInstance().getTimesCalled());
        
         HelloSingleTone.getInstance().SingleToneDoSomething();
        
        System.out.println("Times called: " +  HelloSingleTone.getInstance().getTimesCalled());
        
        HelloSingleTone instancia = HelloSingleTone.getInstance();
        HelloSingleTone instancia2 = HelloSingleTone.getInstance();
        
        if(instancia.equals(instancia2)){
            
            System.out.println("They are the same thing.");
            
        } else{
            
            System.out.println("They are not the same thing.");
            
        }
        
        System.out.println("Times called: " +  HelloSingleTone.getInstance().getTimesCalled());
        
        System.out.println(HelloSingleTone.getInstance());
        System.out.println(instancia);
        System.out.println(instancia2);
        
        
    }
}
