/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import util.Helper;


/**
 *
 * @author lovro
 */
public class Main {

  
    public static void main(String[] args) {

        //validate inputs
        if (Main.validateInput(args)) {
            System.out.println("Hello world");
        } else {
            System.out.println(Helper.errorInput);
        }
    }

    private static boolean validateInput(String[] args) {
        
        return false;
    }

}
