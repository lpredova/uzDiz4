/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theads;

import java.util.ArrayList;
import java.util.List;
import mvc.View;
import resource.ea.Car;

/**
 *
 * @author lovro
 */
public class CarThread implements Runnable {

    private volatile boolean isRunning = true;
    public static Thread carThread;

    @Override
    synchronized public void run() {

        //initial slepp
        
        //                        Thread.sleep(1500);

        //arrival interval
        //((vremenskaJedinica / intervalDolaska) * generiranaVrijednost1)
        while (isRunning) {
            double arrivalInterval = 1000;

            try {
                View.printText("Cas alive");

                if (resource.lifecycle.ResourceLifecylceManager.parking.isOpen()) {
                    List<Car> cars = resource.lifecycle.ResourceLifecylceManager.cars;
                    if (cars.size() > 0) {

                        Car car = cars.get(0);
                        resource.lifecycle.ResourceLifecylceManager.acquire(car);
                        arrivalInterval = ((main.Main.timeSlot / main.Main.arrivalInterval) * ((double)car.getGeneratedValue1()));
        
                        Thread.sleep((long) arrivalInterval);

                    }
                } else {
                    View.printText("Parking is closed!");
                }

            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }

    }

    public void start() {
        if (carThread == null) {
            carThread = new Thread(this, "Cars");
            carThread.start();
        }
    }

    public void kill() {
        isRunning = false;
        carThread = null;
    }
}
