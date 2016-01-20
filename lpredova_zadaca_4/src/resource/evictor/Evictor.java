/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource.evictor;

import java.util.ArrayList;
import java.util.List;
import resource.ea.Car;
import resource.ea.ParkingZone;
import static resource.lifecycle.ResourceLifecylceManager.cache;
import static resource.lifecycle.ResourceLifecylceManager.cars;
import static resource.lifecycle.ResourceLifecylceManager.parkingCars;

/**
 *
 * @author lovro
 */
public class Evictor implements Runnable {

    public Evictor() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        // For simplicity, we run forever
        while (true) {
            try {
                // Sleep for configured amount of time
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }

    }

    public void evict(Car car) {
        int id = car.getId();
        for (Car car1 : parkingCars) {
            if (id == car1.getId() && car1.isEvictable()) {
                
                car1.beforeEviction();
                cache.acquire(id);
                cars.add(car1);
                parkingCars.remove(car1);
                
                //evict car from zone he's in
                List<ParkingZone> zones = resource.lifecycle.ResourceLifecylceManager.parking.getZones();
                for (ParkingZone zone : zones) {
                    
                    //check cars in the zone
                    ArrayList<Car> cars = zone.getCars();
                    for (Car car2 : cars) {
                        if(car2.getId()==car1.getId()){
                            zone.removeCar(car2);
                        }
                    }
                }
            }
        }
    }

}
