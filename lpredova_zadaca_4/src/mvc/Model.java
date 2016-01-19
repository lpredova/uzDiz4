/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import java.util.ArrayList;
import resource.ea.Car;
import resource.ea.Parking;

/**
 *
 * @author Lovro
 */
public class Model {

    private ArrayList<String> data;
    
    public ArrayList<Car> cars;
    public Parking parking;

    public Model(String[] args) {
        
        
        
    }

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }

}
