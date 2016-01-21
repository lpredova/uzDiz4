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
    private Car car;

    public Owner(Car car) {
        this.car = car;
        this.ownerId = OWNER_ID++;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
