/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifecycle;

import java.util.ArrayList;
import resource.ea.Car;
import resource.ea.CarEagerAcquisition;
import resource.ea.Owner;
import resource.ea.Parking;
import resource.ea.ParkingEagerAcquisition;
import resource.evictor.Evictor;

/**
 *
 * @author lovro
 */
public class ResourceLifecylceManager {

    public static ArrayList<Car> cars;
    public static Parking parking;
    public static ArrayList<Owner> owners;
    private final Evictor evictor;

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
        
        
        //setting car thread
        
        
        //setting owner thread
        
        
        //setting worker thread
        
        
    }

    public static Car acquire(Car type) {
        
        
        
        
      
        return null;
    }

    
    
    
    
    public static void release(Car resource) {
        
        //releasing resource with evictor
    }
}
