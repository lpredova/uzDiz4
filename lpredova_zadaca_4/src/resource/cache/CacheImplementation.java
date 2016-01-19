/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource.cache;

import java.util.HashMap;
import resource.ea.Car;

/**
 *
 * @author lovro
 */
public class CacheImplementation implements Cache{

    static HashMap hm = new HashMap();

    
    @Override
    public void release(Car resource) {
       int id = resource.getId();
     hm.put(id, resource );
    }

    @Override
    public Car acquire(int id) {
        Object car = hm.get(id);
        
        return (Car) car;
    }
    
}
