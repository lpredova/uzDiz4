/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource.ea;

import java.util.ArrayList;

/**
 *
 * @author lovro
 */
public class ParkingZone {

    protected static int ZONE_ID = 1;

    int zoneId;
    float zoneFreePercentage = 0;
    int zoneCapacity = 0;
    long zoneEarning = 0;
    long zonePenalty = 0;
    int maxZoneExtensions = 0;

    int carsFled = 0;
    int carsTowed = 0;

    ArrayList<Car> cars;

    public ParkingZone() {
        this.zoneId = ZONE_ID++;
    }

    public int getMaxZoneExtensions() {
        return maxZoneExtensions;
    }

    public void setMaxZoneExtensions(int maxZoneExtensions) {
        this.maxZoneExtensions = maxZoneExtensions;
    }

    public void increaseFledCarsNumber() {
        carsFled += 1;
    }

    public void increaseTowedCarsNumber() {
        carsFled += 1;
    }

    public void increaseZoneEarnings(double paid) {
        this.zoneEarning += paid;
    }

    public int getZoneId() {
        return zoneId;
    }

    public void setZoneId(int zoneId) {
        this.zoneId = zoneId;
    }

    public float getZoneFreePercentage() {
        return zoneFreePercentage;
    }

    public void setZoneFreePercentage(int zoneFreePercentage) {
        this.zoneFreePercentage = zoneFreePercentage;
    }

    public int getZoneCapacity() {
        return zoneCapacity;
    }

    public void setZoneCapacity(int zoneCapacity) {
        this.zoneCapacity = zoneCapacity;
    }

    public long getZoneEarning() {
        return zoneEarning;
    }

    public void setZoneEarning(long zoneEarning) {
        this.zoneEarning = zoneEarning;
    }

    public long getZonePenalty() {
        return zonePenalty;
    }

    public void setZonePenalty(long zonePenalty) {
        this.zonePenalty = zonePenalty;
    }

    public int getCarsFled() {
        return carsFled;
    }

    public void setCarsFled(int carsFled) {
        this.carsFled = carsFled;
    }

    public int getCarsTowed() {
        return carsTowed;
    }

    public void setCarsTowed(int carsTowed) {
        this.carsTowed = carsTowed;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public void addCar(Car car) {
        this.cars.add(car);
        calculateCapacityPercentage();
    }

    public void removeCar(Car car) {
        this.cars.remove(car);
        calculateCapacityPercentage();
    }

    private void calculateCapacityPercentage() {
        this.zoneFreePercentage = this.cars.size() / this.zoneCapacity;
    }
}
