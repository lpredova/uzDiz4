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
public class ParkingZoneEagerAcquisition {

    List<ParkingZone> zones = new ArrayList<>();
    ;
    private static final ParkingZoneEagerAcquisition instance = new ParkingZoneEagerAcquisition();

    private ParkingZoneEagerAcquisition() {

    }

    public static ParkingZoneEagerAcquisition getInstance() {
        return instance;
    }

    public List<ParkingZone> createZones() {

        //creating n cars from input args
        for (int i = 1; i <= main.Main.numZones; i++) {
            ParkingZone pz = new ParkingZone();
            
            //(i * kapacitetZone) i je broj zone
            pz.setZoneCapacity(i * main.Main.zoneCapacity);
            zones.add(pz);
        }

        return zones;
    }

}
