/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theads;

/**
 *
 * @author lovro
 */
public class OwnerThread implements Runnable {

    private Thread t;

    @Override
    public void run() {
    }

    public void start() {
        if (t == null) {
            t = new Thread(this, "Owner");
            t.start();
        }
    }

}
