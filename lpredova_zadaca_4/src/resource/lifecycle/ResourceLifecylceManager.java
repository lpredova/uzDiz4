/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource.lifecycle;

import java.util.ArrayList;
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
        ct.run();
        
        //setting owner thread
        OwnerThread ot = new OwnerThread();
        ot.run();
        
        //setting worker thread
        GuardThread gt = new GuardThread();
        gt.run();
        
    }

    public static Car acquire(Car type) {
        
        
        
        
      
        return null;
    }

    
    
    
    
    public static void release(Car resource) {
        
        //releasing resource with evictor
        
    }
}
