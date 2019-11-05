
//Student Name: John Luke Denny
//LSU ID: 896463927
//Lab Section: 002
//Assignment: Lab assignment 2 - Objects
//Submission Time: 5:15PM

package carsproject;

public class Car {
    
    private long vinNumber;
    private String model;
    private int year;
    private double mileage;
    
    //default constructor
    public Car(){
    }
    
    //constructor that sets vinNumber, year, and model
    public Car(long VIN, int Year, String Model){
        vinNumber = VIN;
        model = Model;
        year = Year;
    }
    
    //sets car mileage
    public void setMileage(double Mileage){
    mileage = Mileage;
    }
    
    //returns the car information
    public String getInfo(){ 
        return year + " " + model + " (VIN: " + vinNumber + ", mileage: " + mileage + " miles)\n";
    }
    
}
