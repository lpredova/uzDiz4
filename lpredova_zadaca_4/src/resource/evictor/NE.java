/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource.evictor;

/**
 *
 * @author lovro
 */
public class NE implements EvictionInterface {

    @Override
    public boolean isEvictable() {
        //check if car has too many penalties, then dump it
        return true;
    }

    @Override
    public Object info() {
//getting some random object info
        return null;
    }

    @Override
    public void beforeEviction() {
        //First, release all resources currently held
        // Now, call beforeEviction() on all NE components
        // to give them a chance to release necessary resources
        
        
        
        
        
    }

}
