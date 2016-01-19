/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource.cache;

import resource.ea.Car;

/**
 *
 * @author lovro
 */
public interface Cache {

    public void release(Car resource);

    public Car acquire(int id);
}
