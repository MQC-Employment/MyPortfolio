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
public class JetAirPlane extends Vehicle implements AirplaneInterface{
    
    private int numberOfJetEngines;
    private int numberOfWheelsInLandingGear;
    
    public JetAirPlane(){
            
    }
    
    public JetAirPlane(String brandNameP, String vehicleNameP, int numberOfWheelsP,
            int numberOfJetEnginesP, int numberOfWheelsInLandingGearP){
        
        super(brandNameP, vehicleNameP);
        this.numberOfJetEngines = numberOfJetEnginesP;
        this.numberOfWheelsInLandingGear = numberOfWheelsInLandingGearP;
        
    }


    @Override
    public void takeOff() {
        
        System.out.println("Starting jet Engine... Take off!");
        
    }

    @Override
    public void land() {
        
        System.out.println("Lowering jet engine speeds... Adjusting flaps... Landing... Landed!");
        
    }
    
    @Override
    public String toString(){
        
        return "The " + this.brandName + " " + getVehicleName() + " is a jet airplane that has " + this.numberOfJetEngines + " jet engines.";
        
    }

    public int getNumberOfJetEngines() {
        return numberOfJetEngines;
    }

    public void setNumberOfJetEngines(int numberOfJetEngines) {
        this.numberOfJetEngines = numberOfJetEngines;
    }

    public int getNumberOfWheelsInLandingGear() {
        return numberOfWheelsInLandingGear;
    }

    public void setNumberOfWheelsInLandingGear(int numberOfWheelsInLandingGear) {
        this.numberOfWheelsInLandingGear = numberOfWheelsInLandingGear;
    }
    
    
    
} //End of Class.
