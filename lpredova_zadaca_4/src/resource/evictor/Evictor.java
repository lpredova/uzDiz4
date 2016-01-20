/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource.evictor;

import resource.ea.Car;
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

            // Assume "threshold" contains the date/time such
            // that any NE accessed before it will be evicted
            // Go through all the NEs and see which ones to evict
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
            }
        }
    }

}
