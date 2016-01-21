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
    ArrayList<ParkingZone> zones;

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
    
    public void printEarningsPayments(){
        
        String text = "";
        for (ParkingZone zone : zones) {
            text += "Zone " + zone.getZoneId() + " earnings:" + zone.getZoneEarning() + "\n";
        }
    
        View.printText(text);
    }
    
    
    public void printEarningsTickets(){
        
        String text = "";
        for (ParkingZone zone : zones) {
            text += "Zone " + zone.getZoneId() + " tickets:" + zone.getZonePenalty()+ "\n";
        }
    
        View.printText(text);
    }
    
    public void printOccupiedByZones(){
        
        String text = "";
        for (ParkingZone zone : zones) {
            text += "Zone " + zone.getZoneId() + " occupied:" + zone.getCarsFled()+ "\n";
        }
    
        View.printText(text);
    
    }
    
    public void printTowedByZones(){
        
        String text = "";
        for (ParkingZone zone : zones) {
            text += "Zone " + zone.getZoneId() + " occupied:" + zone.getCarsFled()+ "\n";
        }
    
        View.printText(text);
    
    }
    
    public void printZonesPercentage(){
        
        String text = "";
        for (ParkingZone zone : zones) {
            text += "Zone " + zone.getZoneId() + " occupied:" + zone.getZoneFreePercentage() +"%"+ "\n";
        }
    
        View.printText(text);
    
    }
    
    public ParkingZone getZoneById(int zoneId){

        for (ParkingZone zone : zones) {
            if(zone.getZoneId()==zoneId){
                return zone;
            }
        }
        return null;
    }
    
}
