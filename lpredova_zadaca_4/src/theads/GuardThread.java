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
public class GuardThread implements Runnable {

    private Thread t;

    @Override
    public void run() {

        int patrolingInterval = (main.Main.timeSlot / main.Main.controlInterval) * 1000;
        /*while (true) {
            try {
                Thread.sleep(patrolingInterval);
                View.printText("They see me rolling...they hatin...Patroling...");
                patrol();

            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }*/

    }

    public void start() {

        if (t == null) {
            t = new Thread(this, "Guard");
            t.start();
        }
    }

    private void patrol() {
        
    }

}
