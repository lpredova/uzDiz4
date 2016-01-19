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
public class ParkingEagerAcquisition {
 
    
    private static final ParkingEagerAcquisition instance = new ParkingEagerAcquisition();

    private ParkingEagerAcquisition() {
        
        
    }

    public static ParkingEagerAcquisition getInstance() {
        return instance;
    }
    
    
    public void createParking(){
    
    
    }  
}
