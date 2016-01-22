/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource.lifecycle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mvc.View;
import resource.cache.CacheImplementation;
import resource.ea.Car;
import resource.ea.CarEagerAcquisition;
import resource.ea.Owner;
import resource.ea.Parking;
import resource.ea.ParkingEagerAcquisition;
import resource.ea.ParkingZone;
import resource.evictor.Evictor;
import theads.CarThread;

import theads.GuardThread;
import theads.OwnerThread;

/**
 *
 * @author lovro
 */
public class ResourceLifecylceManager {

    public static List cars = Collections.synchronizedList(new ArrayList());
    public static List owners = Collections.synchronizedList(new ArrayList());
    public static Parking parking;
    private static Evictor evictor = new Evictor();

    //cars on parking
    public static List parkingCars = Collections.synchronizedList(new ArrayList());
    public static List dumpedCars = Collections.synchronizedList(new ArrayList());
    public static List parkingOwners = Collections.synchronizedList(new ArrayList());

    public static GuardThread gt = new GuardThread();
    public static OwnerThread ot = new OwnerThread();
    public static CarThread ct = new CarThread();

    //cache
    public static CacheImplementation cache = new CacheImplementation();

    public ResourceLifecylceManager() {

        //create cars
        CarEagerAcquisition newCar = CarEagerAcquisition.getInstance();
        cars = newCar.createCars();

        //create parkings and zones
        ParkingEagerAcquisition newParking = ParkingEagerAcquisition.getInstance();
        parking = newParking.createParking();

        //setting car enter thread
        ct.start();

        //setting owner thread
        ot.run();
        View.printText("Owners started!\n");

        //setting worker thread
        gt.run();
        evictor.run();
    }

    /**
     * Method for adding new cars to car lot
     *
     * @param car
     */
    synchronized public static void acquire(Car car) {

        //select zone
        //(brojZona * generiranaVrijednost2) tako da sve zone imaju istu vjerojatnost odabira
        int zone = (int) Math.ceil(main.Main.numZones * car.getGeneratedValue2());

        List<ParkingZone> zones = parking.getZones();
        ParkingZone wantedZone = zones.get(zone - 1);

        //zone is full?
        if (wantedZone.getZoneCapacity() == wantedZone.getCars().size()) {
            wantedZone.increaseFledCarsNumber();
        } //everything is ok and car is going to be parked
        else {

            long time = System.currentTimeMillis() / 1000L;
            //(i * maksParkiranje * vremenskaJedinica), i je broj zone
            long timeParked = zone * main.Main.timeSlot * main.Main.maxParking;
            //((brojZona + 1 - i) * cijenaJedinice), i je broj zone
            double paid = ((main.Main.numZones + 1 - zone) * main.Main.unitPrice);
            car.increaseTotalPaid(paid);
            car.setLastPaid(paid);
            car.setZone(wantedZone);
            
            car.setArrivalTime(time);
            car.setDepartureTime(time + timeParked);
            
            car.setState(1);
            car.increaseTimesParked();

            //park car into zone
            wantedZone.increaseZoneEarnings(paid);
            wantedZone.addCar(car);
            //adding car and owners to data structures
            parkingCars.add(car);
            cache.release(car);

            //saving owner
            car.setOwner(zone);
            
            for (Object owner: owners) {
                Owner o = (Owner) owner;
                if(o.getCarId()==car.getId()){
                o.setGeneratedValue3(car.getGeneratedValue3());
                parkingOwners.add(o);
                }
            }
            
            //removing car from outside
            cars.remove(car);

            car.printCarInfo();
        }
    }

    /**
     * Method for removing cars from parking lot
     *
     * @param car
     */
    synchronized public static void release(Car car) {
        //releasing resource with evictor
        evictor.evict(car);
    }
    
    /**
     * Method for removing cars from parking lot
     *
     * @param car
     */
    synchronized public static void releaseDump(Car car) {
        //releasing resource with evictor
        evictor.evictDump(car);
    }
    
    public static void killThreads(){
        System.out.println("Killing threads");
        gt.kill();
        ct.kill();
        ot.kill();
    }
}
