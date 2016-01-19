/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import java.util.ArrayList;
import resource.ea.Car;
import resource.ea.CarEagerAcquisition;
import resource.ea.Owner;
import resource.ea.Parking;
import resource.ea.ParkingEagerAcquisition;

/**
 *
 * @author Lovro
 */
public class Model {

    private ArrayList<String> data;
    public ArrayList<Car> cars;
    public Parking parking;
    public static ArrayList<Owner> owners;

    public Model(String[] args) {

        //create cars
        CarEagerAcquisition newCar = CarEagerAcquisition.getInstance();
        cars = (ArrayList<Car>) newCar.createCars();

        //create parkings
        ParkingEagerAcquisition newParking = ParkingEagerAcquisition.getInstance();
        parking = newParking.createParking();

    }

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }

    

}
