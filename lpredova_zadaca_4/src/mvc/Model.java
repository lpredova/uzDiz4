/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import resource.lifecycle.ResourceLifecylceManager;

/**
 *
 * @author Lovro
 */
public class Model {

    public Model() {
        try {
            resource.lifecycle.ResourceLifecylceManager rlm = new ResourceLifecylceManager();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
