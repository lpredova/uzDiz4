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
public class CarThread implements Runnable{

    private Thread t;

    @Override
    public void run() {
        
          int patrolingInterval = (main.Main.timeSlot / main.Main.controlInterval) * 1000;
        while (true) {
            try {
                //arrive
                ArrayList<Car> cars = resource.lifecycle.ResourceLifecylceManager.cars;
                if(cars.size()>0){
                    resource.lifecycle.ResourceLifecylceManager.acquire(cars.get(0));
                }
                
                //depart
                Thread.sleep(patrolingInterval);
                View.printText("Hey its meeeeeee");
              

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
