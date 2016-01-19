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

    protected static int ZONE_ID = 0;

    int zoneId;
    int zoneFreePercentage;
    int zoneCapacity;
    long zoneEarning;
    long zonePenalty;

    int carsFled;
    int carsTowed;

    ArrayList<Car> cars;

    public ParkingZone() {
        this.zoneCapacity = ZONE_ID++;
    }
    

    public int getZoneId() {
        return zoneId;
    }

    public void setZoneId(int zoneId) {
        this.zoneId = zoneId;
    }

    public int getZoneFreePercentage() {
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

}
