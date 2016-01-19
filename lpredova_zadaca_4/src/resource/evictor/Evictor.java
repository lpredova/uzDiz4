/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource.evictor;

import java.util.Date;

/**
 *
 * @author lovro
 */
public class Evictor implements Runnable {

    private NE[] nes;

    public Evictor() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        // For simplicity, we run forever
        /*while (true) {
            try { // Sleep for configured amount of time
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }

// Assume "threshold" contains the date/time such
// that any NE accessed before it will be evicted
// Go through all the NEs and see which ones to evict
            for (int i = 0; i < nes.length; i++) {
                NE ne = (NE) nes[i];
                if (ne.isEvictable()) {
                    Date d = (Date) ne.info();
                    if (true) {
                        ne.beforeEviction();
                        // Now remove the NE (application-specific)
                    }
                }
            }
        }*/

    }

}
