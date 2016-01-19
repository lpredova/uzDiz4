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
public class CarEagerAcquisition {
    
    List<Car> cars = new ArrayList<>();
    private static final CarEagerAcquisition instance = new CarEagerAcquisition();
    
    private CarEagerAcquisition() {}
    
    public static CarEagerAcquisition getInstance() {
        return instance;
    }
    
    public List<Car> createCars() {
        
       
        System.out.println("Broj auta:" + main.Main.numCars);    
        
        //creating n cars from input args
        for (int i = 0; i <= main.Main.numCars; i++) {
            
            Car car = new Car();
            
            Owner owner = new Owner(car);
            car.setOwner(owner);
//            mvc.Model.owners.add(owner);
            
            cars.add(car);
        }
        
        return cars;
    }
}