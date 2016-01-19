/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theads;

import mvc.View;

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
