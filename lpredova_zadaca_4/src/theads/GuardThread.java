/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theads;

import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import mvc.Controller;
import mvc.View;
import resource.ea.Car;
import resource.ea.ParkingZone;
import util.Helper;

/**
 * @author lovro
 */
public class GuardThread implements Runnable {

    private volatile boolean isRunning = true;
    public static Thread guardThread;

    @Override
    synchronized public void run() {
        View.printText("Guard is starting shift..");

        while (isRunning && !Helper.checkIfDone()) {

            long patrolingInterval;

            try {
                //(vremenskaJedinica / intervalKontrole)
                patrolingInterval = (main.Main.timeSlot / main.Main.controlInterval);
                doAction();
                
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

    private void doAction() {

        List<Car> parkedCars = resource.lifecycle.ResourceLifecylceManager.parkingCars;
        List<ParkingZone> zones = resource.lifecycle.ResourceLifecylceManager.parking.getZones();

        //check if parking time is over
        long time = System.currentTimeMillis();

        if (parkedCars.size() > 0) {
            Iterator<Car> cars = parkedCars.iterator();

            try {
                while (cars.hasNext()) {
                    Car car = cars.next();
                    long carDepartureTime = (long) car.getDepartureTime();

                    Calendar date = Calendar.getInstance();

                    date.setTimeInMillis((long) (car.getDepartureTime()));
                    String departure = "  " + date.getTime();

                    if (carDepartureTime < (long) time) {

                        //parking expired
                        System.out.println("Car " + car.getId() + " parking has expired:" + departure);

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
            } catch (Exception e) {
                //notin
            }
        }
    }
}
