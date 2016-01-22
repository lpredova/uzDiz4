/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource.ea;

import java.util.Calendar;
import mvc.View;
import resource.evictor.EvictionInterface;
import util.Helper;

/**
 *
 * @author lovro
 */
public class Car implements EvictionInterface, Comparable<Car> {

    protected static int CAR_ID = 1;

    int carId;
    long arrivalTime;
    long departureTime;
    int state = 0;
    ParkingZone zone;
    int timesExtended = 0;
    int timesParked = 0;

    double totalPenalty = 0;
    double totalPaid = 0;
    double lastPaid = 0;
    int owner;

    double generatedValue1;
    double generatedValue2;
    double generatedValue3;
    double generatedValue4;

    public Car() {
        this.carId = CAR_ID++;
        generatedValue1 = Helper.randInt();
        generatedValue2 = Helper.randInt();
        generatedValue3 = Helper.randInt();
        generatedValue4 = Helper.randInt();
        this.arrivalTime = 0;
        this.departureTime = 0;
    }

    public int getTimesExtended() {
        return timesExtended;
    }

    public void setTimesExtended(int timesExtended) {
        this.timesExtended = timesExtended;
    }

    public int getTimesParked() {
        return timesParked;
    }

    public void setTimesParked(int timesParked) {
        this.timesParked = timesParked;
    }

    public void increaseTimesParked() {
        this.timesParked += 1;
    }
    
    public void increaseTimesExtender() {
        this.timesExtended += 1;
    }

    public double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(double totalPaid) {
        this.totalPaid = totalPaid;
    }

    public void increaseTotalPaid(double paid) {
        this.totalPaid += paid;
    }

    public double getLastPaid() {
        return lastPaid;
    }

    public void setLastPaid(double lastPaid) {
        this.lastPaid = lastPaid;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public int getId() {
        return this.carId;
    }

    public double getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(long arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public double getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(long departureTime) {
        this.departureTime = departureTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public ParkingZone getZone() {
        return zone;
    }

    public void setZone(ParkingZone zone) {
        this.zone = zone;
    }

    public double getTotalPenalty() {
        return totalPenalty;
    }

    public void setTotalPenalty(double totalPenalty) {
        this.totalPenalty = totalPenalty;
    }

    public double getGeneratedValue1() {
        return generatedValue1;
    }

    public void setGeneratedValue1(double generatedValue1) {
        this.generatedValue1 = generatedValue1;
    }

    public double getGeneratedValue2() {
        return generatedValue2;
    }

    public void setGeneratedValue2(double generatedValue2) {
        this.generatedValue2 = generatedValue2;
    }

    public double getGeneratedValue3() {
        return generatedValue3;
    }

    public void setGeneratedValue3(double generatedValue3) {
        this.generatedValue3 = generatedValue3;
    }

    public double getGeneratedValue4() {
        return generatedValue4;
    }

    public void setGeneratedValue4(double generatedValue4) {
        this.generatedValue4 = generatedValue4;
    }

    public void printCarInfo() {

        Calendar date = Calendar.getInstance();

        date.setTimeInMillis((long) (getArrivalTime()));
        String arrival = "  " + date.getTime();

        date.setTimeInMillis((long) (getDepartureTime()));
        String departure = "  " + date.getTime();

        String info = "\nCar no:" + getId() + " entered parking lot\n"
                + "Arrival:" + arrival + "\n"
                + "Valid  :" + departure + "\n"
                + "Status:" + determineStatus() + "\n"
                + "Zone:" + getZone().getZoneId() + "\n"
                + "Paid:" + getLastPaid() + "\n"
                + "Total:" + getTotalPaid() + "\n"
                + "Total Penalty:" + getTotalPenalty() + "\n"
                + "Extensions:" + getTimesExtended() + "\n"
                + "Times Parked:" + getTimesParked() + "\n"
                + "======================================";

        View.printText(info);
    }

    private String determineStatus() {
        if (getState() == 1) {
            return "Parking paid";
        } else if (getState() == 2) {
            return "Parking expired";
        } else if (getState() == 4) {
            return "Parking extended";
        } else {
            return "Parking not found, moving on...";
        }
    }

    @Override
    public boolean isEvictable() {
        return true;
    }

    @Override
    public void beforeEviction() {
        setArrivalTime(0);
        setDepartureTime(0);
        setGeneratedValue1(0);
        setGeneratedValue2(0);
        setGeneratedValue3(0);
        setGeneratedValue4(0);
        setLastPaid(0);
    }

    @Override
    public int compareTo(Car c) {
        int compareTotal = ((Car) c).getTotal();
        return compareTotal - this.timesParked;
    }

    private int getTotal() {
        return this.timesParked;
    }
}
