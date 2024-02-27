/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.vehicle.airplane;

import classes.vehicle.Vehicle;
import interfaces.vehicle.airplane.AirplaneInterface;

/**
 *
 * @author ManuelAlonso
 */
public class AirscrewAirPlane extends Vehicle implements AirplaneInterface{
    
    private int numberOfAirscrews;
    
    public AirscrewAirPlane(){
        
        
        
    }
    
    public AirscrewAirPlane(String brandNameP, String vehicleNameP, int numberOfAirscrewsP){
        
        super(brandNameP, vehicleNameP);
        this.numberOfAirscrews = numberOfAirscrewsP;
        
    } //End of constructor. 

    public int getNumberOfAirscrews() {
        return numberOfAirscrews;
    }

    public void setNumberOfAirscrews(int numberOfAirscrews) {
        this.numberOfAirscrews = numberOfAirscrews;
    }

    @Override
    public void takeOff() {
        
        System.out.println("Starting engine... Airscrews spinning... Take off!");
        
    }

    @Override
    public void land() {
        
        System.out.println("Decreaseing speed... Landing... Landed! Airscrews standing still.");
        
    }

    
} //End of class.
