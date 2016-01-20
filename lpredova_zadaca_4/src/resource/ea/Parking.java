/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource.ea;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lovro
 */
public class Parking {

    boolean open = true;
    List<ParkingZone> zones;

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
    
}
