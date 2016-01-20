/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theads;

import java.util.Random;

/**
 *
 * @author lovro
 */
public class OwnerThread implements Runnable {

    private Thread t;

    @Override
    public void run() {
        
           //arrival interval
        //((vremenskaJedinica / intervalOdlaska) * generiranaVrijednost3)
        int departureInterval = (int) ((main.Main.timeSlot / main.Main.departureInterval) * main.Main.generatedValue3);
        
   
        while (true) {
            try {
                //depart
                Thread.sleep(departureInterval);
                
                doAction();
             

            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }  
    }

    public void start() {
        if (t == null) {
            t = new Thread(this, "Owner");
            t.start();
        }
    }
    
    
    private void doAction(){

        double chance = main.Main.generatedValue4;
        
        if (chance <= 0.25f){
            //do nothing
        
        } else if(chance > 0.25f && chance <= 0.50f){
            //exit
        
        }else{
            //extend parking
            
        
        }
            
        
    
    }

}
