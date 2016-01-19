/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource.lifecycle;

import java.util.ArrayList;
import mvc.View;
import resource.ea.Car;
import resource.ea.CarEagerAcquisition;
import resource.ea.Owner;
import resource.ea.Parking;
import resource.ea.ParkingEagerAcquisition;
import resource.evictor.Evictor;
import theads.CarThread;

import theads.GuardThread;
import theads.OwnerThread;

/**
 *
 * @author lovro
 */
public class ResourceLifecylceManager {

    public static ArrayList<Car> cars;
    public static Parking parking;
    public static ArrayList<Owner> owners;
    private final Evictor evictor;
    
    //cars on parking
    public static ArrayList<Car> parkingCars;
    public static ArrayList<Car> dumpedCars;
    public static ArrayList<Owner> parkingOwners;
    

    public ResourceLifecylceManager() {
        
        //create cars
        CarEagerAcquisition newCar = CarEagerAcquisition.getInstance();
        cars = (ArrayList<Car>) newCar.createCars();

        //create parkings and zones
        ParkingEagerAcquisition newParking = ParkingEagerAcquisition.getInstance();
        parking = newParking.createParking();
        
        //setting evictor
        evictor = new Evictor();
        
        //setting car enter thread
        CarThread ct = new CarThread();
        ct.start();
        View.printText("Parking lot is open\n");
        
        //setting owner thread
        OwnerThread ot = new OwnerThread();
        ot.run();
        View.printText("Owners are starting to buzz around!\n");

        
        //setting worker thread
        GuardThread gt = new GuardThread();
        gt.run();
        View.printText("Owners are starting to buzz around!\n");
  
    }

    public static Car acquire(Car type) {
        
        
        //select zone
        int zone = (int) Math.ceil(main.Main.numZones * main.Main.generatedValue2 );
        
        
        //check if there is free space
        System.out.println("Selected zone is :"+ zone);
        
        System.out.println(parking);
        
        
        //fill values
       
        parkingCars.add(type);
        
        
      
        return null;
    }

    
    
    
    
    public static void release(Car resource) {
        
        //releasing resource with evictor
        
    }
}
