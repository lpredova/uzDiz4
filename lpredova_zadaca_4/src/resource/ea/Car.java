/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource.ea;

/**
 *
 * @author lovro
 */
public class Car {

    protected static int CAR_ID = 0;

    int carId;
    String arrivalTime;
    String departureTime;
    boolean state;
    ParkingZone zone;
    String totalPenalty;
    Owner owner;

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

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public ParkingZone getZone() {
        return zone;
    }

    public void setZone(ParkingZone zone) {
        this.zone = zone;
    }

    public String getTotalPenalty() {
        return totalPenalty;
    }

    public void setTotalPenalty(String totalPenalty) {
        this.totalPenalty = totalPenalty;
    }
}
