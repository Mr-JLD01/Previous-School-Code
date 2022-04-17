
//Student Name: John Luke Denny
//LSU ID: 896463927
//Lab Section: 002
//Assignment: Lab assignment 2 - Objects
//Submission Time: 5:15PM


package carsproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;

public class CarsProject {

    //creates three cars and set their milages then copies their info to a text file
    public static void main(String[] args) throws FileNotFoundException{
        Car c1 = new Car(12313131, 2009, "Camry");
        c1.setMileage(60000);
        saveCarInfo(c1.getInfo());
        
        Car c2 = new Car(95645421, 2010, "Accord");
        c2.setMileage(95000);
        saveCarInfo(c2.getInfo());
        
        Car c3 = new Car(45746587, 2019, "CX5");
        c3.setMileage(600);
        saveCarInfo(c3.getInfo());
    }
    
    //copies car info to a text file
    public static void saveCarInfo(String info) throws FileNotFoundException{
        PrintWriter outfile = new PrintWriter(new FileOutputStream(new File("carInfo.txt"), true));
        outfile.print(info);
        outfile.close();
    }
    
}
