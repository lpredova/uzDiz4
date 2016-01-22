/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theads;

import mvc.View;
import resource.ea.Car;
import util.Helper;

/**
 *
 * @author lovro
 */
public class CarThread implements Runnable {

    private volatile boolean isRunning = true;
    public static Thread carThread;

    @Override
    synchronized public void run() {

        //arrival interval
        //((vremenskaJedinica / intervalDolaska) * generiranaVrijednost1)
        while (isRunning && !Helper.checkIfDone()) {
            double arrivalInterval = 0;

            try {
                if (resource.lifecycle.ResourceLifecylceManager.parking.isOpen()) {
                    if (resource.lifecycle.ResourceLifecylceManager.cars.size() > 0) {
                        Car car = null;
                        while (car == null) {
                            try {

                                car = (Car) resource.lifecycle.ResourceLifecylceManager.cars.get(0);

                                resource.lifecycle.ResourceLifecylceManager.acquire(car);
                                arrivalInterval = ((main.Main.timeSlot / main.Main.arrivalInterval) * ((double) car.getGeneratedValue1()));

                            } catch (Exception e) {
                                System.out.print(e);
                                continue;
                            }
                        }

                        if (arrivalInterval == 0) {
                            arrivalInterval = ((main.Main.timeSlot / main.Main.arrivalInterval) * Helper.randInt());
                        }

                        View.printText("Cars outside: " + resource.lifecycle.ResourceLifecylceManager.cars.size());
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

    public void doAction() {

    }
}
