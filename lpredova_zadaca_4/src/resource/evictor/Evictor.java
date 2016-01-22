/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource.evictor;

import java.util.ArrayList;
import java.util.List;
import mvc.View;
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
        View.printText("Evictor initialized");
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

    synchronized public void evict(Car car) {
        int id = car.getId();
        List parkingCarsCopy = parkingCars;
       
            for (Object car0 : parkingCarsCopy) {
                Car car1 = (Car) car0;
                
                if (id == car1.getId() && car1.isEvictable()) {

                    car1.beforeEviction();
                    cache.acquire(id);
                    cars.add(car1);
                    //parkingCars.remove(car1);

                    //evict car from zone he's in, making copy of Object so we could edit real one
                    List<ParkingZone> zones = resource.lifecycle.ResourceLifecylceManager.parking.getZones();
                    List<ParkingZone> zonesCopy = zones;
                    int i = 0;

                    for (ParkingZone zone : zonesCopy) {

                        //check cars in the zone
                        ArrayList<Car> zoneCars = zone.getCars();
                        for (Car car2 : zoneCars) {

                            if (car2.getId() == car1.getId() && car2 != null) {
                                //zones.get(i).removeCar(car2);
                                return;
                            }
                        }
                        i++;
                    }
                }
            }
        }
  

    synchronized public void evictDump(Car car) {

        /*int carId = car.getId();

        //get cars zone
        if (car.getId() == carId && car.isEvictable()) {
            //evict car from zone he's in
            int carsZoneId = car.getZone().getZoneId();
            ParkingZone zone = resource.lifecycle.ResourceLifecylceManager.parking.getZoneById(carsZoneId);

            //check cars in the zone
            for (Car car2 : zone.getCars()) {
                if (car2.getId() == car.getId()) {
                    //zone.removeCar(car2);
                    break;
                }
            }

            car.beforeEviction();
            cache.acquire(carId);
            parkingCars.remove(car);
        }*/
    }
}
