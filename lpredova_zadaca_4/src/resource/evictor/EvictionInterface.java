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
public interface EvictionInterface {

    public boolean isEvictable();

    public void beforeEviction();
}
