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
public class ConcreteValidator extends AbstractValidator {

    @Override
    protected void write(String message) {
    }

    @Override
    /**
     * Sample input java -jar program.jar brojAutomobila brojZona kapacitetZone
     * maksParkiranje vremenskaJedinica intervalDolaska intervalOdlaska
     * cijenaJedinice intervalKontrole kaznaParkiranja
     */
    public boolean validate(String[] args) {

        boolean result = true;

        //broj automobila i kazna za parkiranje
        if (!Helper.validateFromTenToHundread(args[0]) || !Helper.validateFromTenToHundread(args[9])) {
            result = false;
        }

        //kapacitet zona
        if (!Helper.validateFromOneToHundread(args[2])) {
            result = false;
        }

        //broj zona
        if (!Helper.validateFromOneToFour(args[1])) {
            result = false;
        }

        //maksParkiranje vremenskaJedinica intervalDolaska intervalOdlaska cijenaJedinice intervalKontrole
        if (!Helper.validateFromOneToTen(args[3])
                || !Helper.validateFromOneToTen(args[4])
                || !Helper.validateFromOneToTen(args[5])
                || !Helper.validateFromOneToTen(args[6])
                || !Helper.validateFromOneToTen(args[7])
                || !Helper.validateFromOneToTen(args[8])) {
            result = false;
        }

        return result;
    }

}
