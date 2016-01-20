/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource.lifecycle;

import java.util.ArrayList;
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

    public static ArrayList<Car> cars;
    public static Parking parking;
    public static ArrayList<Owner> owners;
    private static Evictor evictor = new Evictor();

    //cars on parking
    public static ArrayList<Car> parkingCars;
    public static ArrayList<Car> dumpedCars;
    public static ArrayList<Owner> parkingOwners;

    //cache
    public static CacheImplementation cache = new CacheImplementation();

    public ResourceLifecylceManager() {

        //create cars
        CarEagerAcquisition newCar = CarEagerAcquisition.getInstance();
        cars = (ArrayList<Car>) newCar.createCars();

        //create parkings and zones
        ParkingEagerAcquisition newParking = ParkingEagerAcquisition.getInstance();
        parking = newParking.createParking();


        //setting car enter thread
        CarThread ct = new CarThread();
        ct.start();
        View.printText("Parking lot is open\n");

        //setting owner thread
        OwnerThread ot = new OwnerThread();
        ot.run();
        View.printText("Owners are starting to buzz around!\n");

        //setting worker thread
        GuardThread gt = new GuardThread();
        gt.run();
        View.printText("Owners are starting to buzz around!\n");
        
        //start evictor
        evictor.run();

    }

    /**
     * Method for adding new cars to car lot
     *
     * @param car
     */
    public static void acquire(Car car) {

        //select zone
        //(brojZona * generiranaVrijednost2) tako da sve zone imaju istu vjerojatnost odabira
        int zone = (int) Math.ceil(main.Main.numZones * car.getGeneratedValue2());

        List<ParkingZone> zones = parking.getZones();
        ParkingZone wantedZone = zones.get(zone - 1);

        //zone is full?
        if (wantedZone.getZoneCapacity() == wantedZone.getCars().size()) {
            wantedZone.increaseFledCarsNumber();
            car.setState(0);
            car.printCarInfo();
        } //everything is ok and car is going to be parked
        else {
            //(i * maksParkiranje * vremenskaJedinica), i je broj zone
            car.setArrivalTime(zone * main.Main.timeSlot * main.Main.maxParking);

            //((brojZona + 1 - i) * cijenaJedinice), i je broj zone
            double paid = ((main.Main.numZones + 1 - zone) * main.Main.unitPrice);
            car.increaseTotalPaid(paid);
            car.setLastPaid(paid);
            car.setZone(wantedZone);
            car.setState(1);

            wantedZone.increaseZoneEarnings(paid);

            //adding car and owners to data structures
            parkingCars.add(car);
            cache.release(car);

            //saving owner
            car.getOwner().setCar(car);
            parkingOwners.add(car.getOwner());

            //removing car from outside
            zones.remove(zone - 1);
            cars.remove(car);

            car.printCarInfo();
        }
    }

    /**
     * Method for removing cars from parking lot
     *
     * @param car
     */
    public static void release(Car car) {
        //releasing resource with evictor
        evictor.evict(car);
    }
}
