/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource.evictor;

import java.util.Iterator;
import mvc.View;
import resource.ea.Car;
import resource.ea.ParkingZone;
import static resource.lifecycle.ResourceLifecylceManager.cache;
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

    synchronized public void evict(Car car) {
        int id = car.getId();

        Iterator<Car> parkedCars = parkingCars.iterator();

        while (parkedCars.hasNext()) {
            Car c = parkedCars.next();

            if (id == c.getId() && c.isEvictable()) {

                //zones iterator
                Iterator<ParkingZone> parkingZone = resource.lifecycle.ResourceLifecylceManager.parking.getZones().iterator();

                while (parkingZone.hasNext()) {
                    ParkingZone pz = parkingZone.next();

                    //check cars in the zone
                    //cars in zone iterator
                    Iterator<Car> carsInZone = pz.getCars().iterator();

                    while (carsInZone.hasNext()) {

                        Car carInZone = carsInZone.next();

                        if (carInZone.getId() == car.getId() && carInZone != null) {
                            c.beforeEviction();
                            cache.acquire(id);
                            resource.lifecycle.ResourceLifecylceManager.cars.add(c);
                            parkedCars.remove();
                            carsInZone.remove();
                            View.printText("Car " + car.getId() + " has left parking.");
                            break;
                        }

                    }

                }

            }
        }
    }

    synchronized public void evictDump(Car car) {

        int id = car.getId();
        Iterator<Car> parkedCars = parkingCars.iterator();
        while (parkedCars.hasNext()) {
            Car c = parkedCars.next();

            if (id == c.getId() && c.isEvictable()) {
                //zones iterator
                Iterator<ParkingZone> parkingZone = resource.lifecycle.ResourceLifecylceManager.parking.getZones().iterator();

                while (parkingZone.hasNext()) {
                    ParkingZone pz = parkingZone.next();
                    //check cars in the zone
                    //cars in zone iterator
                    Iterator<Car> carsInZone = pz.getCars().iterator();

                    while (carsInZone.hasNext()) {

                        Car carInZone = carsInZone.next();

                        if (carInZone.getId() == car.getId() && carInZone != null) {
                            carInZone.setState(2);
                            c.beforeEviction();
                            cache.acquire(id);
                            parkedCars.remove();
                            carsInZone.remove();
                            resource.lifecycle.ResourceLifecylceManager.dumpedCars.add(carInZone);
                            View.printText("Car " + carInZone.getId() + " towed away!");
                            return;
                        }
                    }
                }
            }
        }
    }
}
