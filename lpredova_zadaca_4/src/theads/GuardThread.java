/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theads;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import mvc.View;
import resource.ea.Car;
import resource.ea.ParkingZone;

/**
 * @author lovro
 */
public class GuardThread implements Runnable {

    private volatile boolean isRunning = true;
    public static Thread guardThread;

    @Override
    synchronized public void run() {
        View.printText("Guard is starting shift..");

        while (isRunning) {
            int patrolingInterval = 1000;
            try {
                ArrayList<Car> parkedCars = resource.lifecycle.ResourceLifecylceManager.parkingCars;
                List<ParkingZone> zones = resource.lifecycle.ResourceLifecylceManager.parking.getZones();
                //check if parking time is over
                long time = System.currentTimeMillis() / 1000L;

                if (parkedCars.size() > 0) {

                    for (Car car : parkedCars) {
                        System.out.println("Working..");
                        long carDepartureTime = (long) car.getDepartureTime();

                        Calendar date = Calendar.getInstance();

                        date.setTimeInMillis((long) (car.getDepartureTime() * 1000));
                        String departure = "  " + date.getTime();

                        if (carDepartureTime < (long) time) {
                            System.out.println("Car" + car.getId() + "Parking expired:" + departure);

                            //parking expired
                            //((brojZona + 1 - i) * cijenaJedinice * kaznaParkiranja)
                            long penalty = (main.Main.numZones + 1 - car.getZone().getZoneId()) * main.Main.unitPrice * main.Main.parkingPenalty;
                            car.setTotalPenalty(penalty);
                            int zoneId = car.getZone().getZoneId();

                            //editing cars zone
                            for (ParkingZone zone : zones) {
                                if (zone.getZoneId() == zoneId) {
                                    zone.increaseZonePenalty(penalty);
                                    zone.increaseTowedCarsNumber();
                                    resource.lifecycle.ResourceLifecylceManager.releaseDump(car);
                                    break;
                                }
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
        guardThread = null;
    }
}
