/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theads;

import java.util.ArrayList;
import mvc.View;
import resource.ea.Car;
import resource.ea.Owner;
import resource.ea.ParkingZone;
import resource.lifecycle.ResourceLifecylceManager;

/**
 *
 * @author lovro
 */
public class OwnerThread implements Runnable {

    public static Thread ownerThread;
    private volatile boolean isRunning = true;

    @Override
    public void run() {

        while (isRunning) {
            try {
                //departure interval
                int departureInterval = 1000;
                if (ResourceLifecylceManager.parkingOwners.size() > 0) {
                    Owner owner = ResourceLifecylceManager.parkingOwners.get(0);
                    //((vremenskaJedinica / intervalOdlaska) * generiranaVrijednost3)
                    departureInterval = (int) ((main.Main.timeSlot / main.Main.departureInterval) * owner.getCar().getGeneratedValue3());
                    doAction(owner);
                }

                //depart
                Thread.sleep(departureInterval);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void start() {
        if (ownerThread == null) {
            ownerThread = new Thread(this, "Owner");
            ownerThread.start();
        }
    }
    
    public void kill() {
       isRunning = false;
   }

    private void doAction(Owner owner) {

        double chance = owner.getCar().getGeneratedValue4();

        if (chance <= 0.25f) {
            //do nothing

        } else if (chance > 0.25f && chance <= 0.50f) {
            //exit
            resource.lifecycle.ResourceLifecylceManager.release(owner.getCar());

        } else {
            //extend parking

            //check if parking is max times extended
            if (owner.getCar().getTimesExtended() <= owner.getCar().getZone().getMaxZoneExtensions()) {
                //ok -> find and extend

                Car ownerCar = owner.getCar();
                ArrayList<Car> cars = resource.lifecycle.ResourceLifecylceManager.parkingCars;
                for (Car car : cars) {
                    if (ownerCar.getId() == car.getId()) {
                        //ok now we have the same car, now extend parking

                        //(i * maksParkiranje * vremenskaJedinica), i je broj zone
                        ParkingZone zone = owner.getCar().getZone();

                        car.setArrivalTime(zone.getZoneId() * main.Main.timeSlot * main.Main.maxParking);

                        //((brojZona + 1 - i) * cijenaJedinice), i je broj zone
                        double paid = ((main.Main.numZones + 1 - zone.getZoneId()) * main.Main.unitPrice);
                        car.increaseTotalPaid(paid);
                        car.setLastPaid(paid);
                        car.setZone(zone);
                        car.setState(2);

                        zone.increaseZoneEarnings(paid);
                    }
                }

            } else {
                View.printText("Max number of extensions reached!");
            }

        }
    }
}
