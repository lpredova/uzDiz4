/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theads;

import java.util.ArrayList;
import resource.ea.Car;

/**
 *
 * @author lovro
 */
public class CarThread implements Runnable {

    private Thread t;

    @Override
    public void run() {

        //arrival interval
        //((vremenskaJedinica / intervalDolaska) * generiranaVrijednost1)
        int arrivalInterval = (int) ((main.Main.timeSlot / main.Main.arrivalInterval) * main.Main.generatedValue1);
        while (true) {
            try {
                //arrive
                ArrayList<Car> cars = resource.lifecycle.ResourceLifecylceManager.cars;
                if (cars.size() > 0) {
                    resource.lifecycle.ResourceLifecylceManager.acquire(cars.get(0));
                }

                //depart
                Thread.sleep(arrivalInterval);

            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }

    }

    public void start() {
        if (t == null) {
            t = new Thread(this, "Cars");
            t.start();
        }
    }
}
