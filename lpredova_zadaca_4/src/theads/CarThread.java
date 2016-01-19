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
public class CarThread implements Runnable{

    private Thread t;

    @Override
    public void run() {
        
                System.out.println("Starting " + "test 1231232");

        
    }

    public void start() {
        System.out.println("Starting " + "test");
        if (t == null) {
            t = new Thread(this, "test");
            t.start();
        }
    }
}
