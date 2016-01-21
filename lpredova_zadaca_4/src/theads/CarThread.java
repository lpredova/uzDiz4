/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theads;

import java.util.ArrayList;
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

        //arrival interval
        //((vremenskaJedinica / intervalDolaska) * generiranaVrijednost1)
        while (isRunning) {
            int arrivalInterval = 1000;
            
            try {
                
                if (resource.lifecycle.ResourceLifecylceManager.parking.isOpen()) {
                    //arrive
                    ArrayList<Car> cars = resource.lifecycle.ResourceLifecylceManager.cars;
                    if (cars.size() > 0) {
                        Car car = cars.get(0);
                        resource.lifecycle.ResourceLifecylceManager.acquire(car);
                        arrivalInterval = (int) ((main.Main.timeSlot / main.Main.arrivalInterval) * car.getGeneratedValue1());
                    }
                    Thread.sleep(arrivalInterval);
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
   }
}
