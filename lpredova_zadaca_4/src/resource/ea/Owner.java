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
public class Owner {
 
    protected static int OWNER_ID = 1;
    
    private int ownerId;
    private int carId;
    private double generatedValue3;

    public Owner(Car car) {
        this.carId = car.getId();
        this.ownerId = OWNER_ID++;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCar(int id) {
        this.carId = id;
    }

    public double getGeneratedValue3() {
        return generatedValue3;
    }

    public void setGeneratedValue3(double generatedValue3) {
        this.generatedValue3 = generatedValue3;
    }
    
    
}
