/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theads;

import java.util.Iterator;
import java.util.List;
import mvc.View;
import resource.ea.Car;
import resource.ea.Owner;
import resource.ea.ParkingZone;
import resource.lifecycle.ResourceLifecylceManager;
import util.Helper;

/**
 *
 * @author lovro
 */
public class OwnerThread implements Runnable {

    public static Thread ownerThread;
    private volatile boolean isRunning = true;

    @Override
    synchronized public void run() {

        while (isRunning) {

            //departure interval
            int departureInterval;
            List owners = ResourceLifecylceManager.parkingOwners;

            if (owners.size() > 0) {

                Iterator<Owner> iter = owners.iterator();

                while (iter.hasNext()) {
                    try {
                        Owner o = iter.next();
                        View.printText("Owners alive");

                        try {
                            //((vremenskaJedinica / intervalOdlaska) * generiranaVrijednost3)
                            departureInterval = (int) ((main.Main.timeSlot / main.Main.departureInterval) * o.getGeneratedValue3()) + 3000;
                            doAction(o);
                            Thread.sleep(departureInterval);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }

                    } catch (Exception e) {
                        break;
                    }

                }
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
        ownerThread = null;
    }

    private void doAction(Owner owner) {

        Car ownersCar = null;

        for (Object car : resource.lifecycle.ResourceLifecylceManager.parkingCars) {
            Car c = (Car) car;
            Owner o = (Owner) owner;
            if (owner.getCarId() == c.getId()) {
                ownersCar = c;
            }
        }

        if (ownersCar != null) {
            double chance = ownersCar.getGeneratedValue4();

            if (chance <= 0.25f) {
                //do nothing
            } else if (chance > 0.25f && chance <= 0.50f) {
                //exit
                resource.lifecycle.ResourceLifecylceManager.release(ownersCar);

            } else {
            //extend parking

                //check if parking is max times extended
                if (ownersCar.getTimesExtended() <= ownersCar.getZone().getMaxZoneExtensions()) {
                    //ok -> find and extend

                    List<Car> cars = resource.lifecycle.ResourceLifecylceManager.parkingCars;

                    for (Car car : cars) {
                        if (ownersCar.getId() == car.getId()) {
                        //ok now we have the same car, now extend parking

                            //(i * maksParkiranje * vremenskaJedinica), i je broj zone
                            ParkingZone zone = ownersCar.getZone();

                            long arrivalTime = System.currentTimeMillis() / 1000L;

                            car.setArrivalTime(arrivalTime);
                            car.setDepartureTime(arrivalTime + (zone.getZoneId() * main.Main.timeSlot * main.Main.maxParking));

                            //((brojZona + 1 - i) * cijenaJedinice), i je broj zone
                            double paid = ((main.Main.numZones + 1 - zone.getZoneId()) * main.Main.unitPrice);
                            car.increaseTotalPaid(paid);
                            car.setLastPaid(paid);
                            car.setZone(zone);
                            car.setState(2);
                            car.increaseTimesExtender();
                            car.setGeneratedValue4(Helper.randInt());

                            zone.increaseZoneEarnings(paid);
                            break;
                        }
                    }

                } else {
                }
            }
        }
    }
}
