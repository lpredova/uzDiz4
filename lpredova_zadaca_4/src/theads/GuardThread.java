/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theads;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import resource.ea.Car;
import resource.ea.ParkingZone;

/**
 * @author lovro
 */
public class GuardThread implements Runnable {

    private volatile boolean isRunning = true;
    public static Thread guardThread;

    @Override
    public void run() {

        while (isRunning) {
            int patrolingInterval = 1000;
            try {

                ArrayList<Car> parkedCars = resource.lifecycle.ResourceLifecylceManager.parkingCars;
                List<ParkingZone> zones = resource.lifecycle.ResourceLifecylceManager.parking.getZones();

                //check if parking time is over
                Date currentDate = new Date();

                for (Car car : parkedCars) {
                    if (car.getDepartureTime() < currentDate.getTime()) {
                        //parking expired

                        //((brojZona + 1 - i) * cijenaJedinice * kaznaParkiranja)
                        long penalty = (main.Main.numZones + 1 - car.getZone().getZoneId()) * main.Main.unitPrice * main.Main.parkingPenalty;
                        car.setTotalPenalty(penalty);
                        int zoneId = car.getZone().getZoneId();

                        //editing cars zone
                        for (ParkingZone zone : zones) {
                            if (zone.getZoneId() == zoneId) {
                                zone.increaseZoneEarnings(penalty);
                                zone.increaseTowedCarsNumber();
                            }
                        }

                    }
                }
         
                //(vremenskaJedinica / intervalKontrole)
                patrolingInterval = (main.Main.timeSlot / main.Main.controlInterval);
                Thread.sleep(patrolingInterval);

            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }

    }

    public void start() {

        if (guardThread == null) {
            guardThread = new Thread(this, "Guard");
            guardThread.start();
        }
    }
    
    public void kill() {
       isRunning = false;
   }
}
