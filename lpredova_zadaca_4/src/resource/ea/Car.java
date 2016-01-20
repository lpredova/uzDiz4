/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource.ea;

import mvc.View;

/**
 *
 * @author lovro
 */
public class Car {

    protected static int CAR_ID = 0;

    int carId;
    double arrivalTime = 0;
    double departureTime = 0;
    int state = 0;
    ParkingZone zone;
    int timesExtended = 0;

    double totalPenalty = 0;
    double totalPaid = 0;
    double lastPaid = 0;
    Owner owner;

    public int getTimesExtended() {
        return timesExtended;
    }

    public void setTimesExtended(int timesExtended) {
        this.timesExtended = timesExtended;
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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Car() {
        this.carId = CAR_ID++;
    }

    public int getId() {
        return this.carId;
    }

    public double getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(double arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public double getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(double departureTime) {
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

    public void printCarInfo() {

        String info = "\nCar no:" + getId() + " entered parking lot\n"
                + "Time:" + getArrivalTime() + "\n"
                + "Time:" + getArrivalTime() + "\n"
                + "Status:" + determineStatus() + "\n"
                + "Zone:" + getZone().getZoneId() + "\n"
                + "Paid:" + getLastPaid() + "\n"
                + "Total:" + getTotalPaid() + "\n"
                + "Total Penalty:" + getTotalPenalty() + "\n"
                + "Extensions:" + getTimesExtended() + "\n"
                + "======================================";

        View.printText(info);
    }

    private String determineStatus() {
        if (getState() == 1) {
            return "Parking paid";
        } else if (getState() == 2) {
            return "Parking expired";
        } else {
            return "Parking not found, moving on...";
        }
    }

}
