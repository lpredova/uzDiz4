/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import util.Helper;

/**
 *
 * @author Lovro
 */
public class View {

    public static void printText(double arrivalInterval) {
        System.out.printf("%.0f\n", arrivalInterval);
    }

    public void getMenu(){
        Helper.printMenu();
    }
    
    public static void printText(String text){
        System.out.println("\n"+text);
    }
}
