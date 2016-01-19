/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import mvc.Controller;
import mvc.Model;
import mvc.View;
import util.Helper;
import util.chain.AbstractValidator;
import util.chain.ConcreteValidator;
import util.chain.GeneralValidator;


/**
 *
 * @author lovro
 */
public class Main {
    public static void main(String[] args) {

        //validate inputs
        if (Main.validateInput(args)) {
             View v = new View();
             Model m = new Model(args);
             Controller c = new Controller(v, m);
             v.getMenu();
             
        } else {
            System.out.println(Helper.errorInput);
        }
    }

    /**
     * Method that performs validations on input arguments
     * @param args
     * @return 
     */
    private static boolean validateInput(String[] args) {
        
        AbstractValidator generalValidator = new GeneralValidator();
        AbstractValidator concreteValidator = new ConcreteValidator();
        generalValidator.setNextValidator(concreteValidator);
        
        return !(!generalValidator.validate(args) || !concreteValidator.validate(args));
    }

}
