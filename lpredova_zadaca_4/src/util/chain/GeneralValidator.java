/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.chain;

import util.Helper;


/**
 *
 * @author lovro
 */
public class GeneralValidator extends AbstractValidator{

    @Override
    protected void write(String message) {
    }

    @Override
    /**
     * Sample input
     * java -jar program.jar brojAutomobila brojZona kapacitetZone maksParkiranje vremenskaJedinica intervalDolaska intervalOdlaska cijenaJedinice intervalKontrole kaznaParkiranja 
     */
    public boolean validate(String[] args) {
        
        boolean result = true;
       
        System.out.println("Duljina: " + args.length);
        if(args.length!=10){
          System.out.println("Wrong number of input params!");
          result = false;
        }
        
        //check if all params are numeric values
        for (String arg : args) {
            if(!Helper.isNumeric(arg)){
                result=false;
                System.out.println(arg +  " is not an number!");
            }
        }

        return result;
    }
 
}
