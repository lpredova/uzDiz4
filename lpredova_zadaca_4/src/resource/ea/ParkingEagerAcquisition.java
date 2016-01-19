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
public class ParkingEagerAcquisition {

    
    private static final ParkingEagerAcquisition instance = new ParkingEagerAcquisition();

    public ParkingEagerAcquisition() {

    }

    public static ParkingEagerAcquisition getInstance() {
        return instance;
    }

    public Parking createParking() {
        Parking parking = new Parking();
        
        //create zones
        ParkingZoneEagerAcquisition newZone = ParkingZoneEagerAcquisition.getInstance();
        parking.setZones((ArrayList<ParkingZone>) newZone.createZones());
        
        return parking;
    }
}
