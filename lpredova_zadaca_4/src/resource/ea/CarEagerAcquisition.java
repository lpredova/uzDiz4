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
public class CarEagerAcquisition {

    private static final CarEagerAcquisition instance = new CarEagerAcquisition();

    private CarEagerAcquisition() {
        
        
    }

    public static CarEagerAcquisition getInstance() {
        return instance;
    }
    
    
    public void createCars(){
        
    
    }
    
    
}
