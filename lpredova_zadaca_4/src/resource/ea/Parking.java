/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource.ea;

import java.util.ArrayList;
import java.util.List;
import mvc.View;

/**
 *
 * @author lovro
 */
public class Parking {

    boolean open = true;
    List zones;

    public List<ParkingZone> getZones() {
        return zones;
    }

    public void setZones(ArrayList<ParkingZone> zones) {
        this.zones = zones;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public void printEarningsPayments() {

        String text = "\n";
        for (Object zone1 : zones) {
            ParkingZone zone = (ParkingZone) zone1;
            text += "Zone " + zone.getZoneId() + " earnings: " + zone.getZoneEarning() + "\n";
        }

        View.printText(text);
    }

    public void printEarningsTickets() {

        String text = "\n";
        for (Object zone1 : zones) {
            ParkingZone zone = (ParkingZone) zone1;
            text += "Zone " + zone.getZoneId() + " tickets: " + zone.getZonePenalty() + "\n";
        }

        View.printText(text);
    }

    public void printOccupiedByZones() {

        String text = "\n";
        for (Object zone1 : zones) {
            ParkingZone zone = (ParkingZone) zone1;
            text += "Zone " + zone.getZoneId() + " occupied: " + zone.getCarsFled() + "\n";
        }

        View.printText(text);

    }

    public void printTowedByZones() {

        String text = "\n";
        for (Object zone1 : zones) {
            ParkingZone zone = (ParkingZone) zone1;
            text += "Zone " + zone.getZoneId() + " occupied: " + zone.getCarsTowed() + "\n";
        }

        View.printText(text);

    }

    public void printZonesPercentage() {

        String text = "\n";
        for (Object zone1 : zones) {
            ParkingZone zone = (ParkingZone) zone1;
            text += "Zone " + zone.getZoneId() + " occupied: " + Math.round(zone.getZoneFreePercentage() * 100) + "%" + "\n";
        }

        View.printText(text);

    }

    public ParkingZone getZoneById(int zoneId) {

        for (Object zone1 : zones) {
            ParkingZone zone = (ParkingZone) zone1;
            if (zone.getZoneId() == zoneId) {
                return zone;
            }
        }
        return null;
    }

}
