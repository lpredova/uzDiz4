/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Random;
import main.Main;

/**
 *
 * @author lovro
 */
public class Helper {

    public static String errorInput = "Whoops! There has been error with params";

    /**
     * Method that checks if
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /**
     * Validate that value is in range 10-100
     *
     * @return
     */
    public static boolean validateFromTenToHundread(String value) {
        int num = Integer.parseInt(value);
        if (num >= 10 && num <= 100) {
            return true;
        }

        System.out.println("Number " + value + " is not in range 10-100 ");
        return false;
    }

    /**
     * Validate that value is in range 1-100
     *
     * @return
     */
    public static boolean validateFromOneToHundread(String value) {
        int num = Integer.parseInt(value);
        if (num >= 1 && num <= 100) {
            return true;
        }

        System.out.println("Number " + value + " is not in range 1-100 ");
        return false;
    }

    /**
     * Validate that value is in range 1-10
     *
     * @return
     */
    public static boolean validateFromOneToTen(String value) {

        int num = Integer.parseInt(value);
        if (num >= 1 && num <= 10) {
            return true;
        }

        System.out.println("Number " + value + " is not in range 1-10 ");
        return false;
    }

    /**
     * Validate that value is in range 1-4
     *
     * @return
     */
    public static boolean validateFromOneToFour(String value) {

        int num = Integer.parseInt(value);
        if (num >= 1 && num <= 4) {
            return true;
        }

        System.out.println("Number " + value + " is not in range 1-4 ");

        return false;
    }

    /**
     * Method for printing menu
     */
    public static void printMenu() {

        System.out.println("-1 - zatvaranje parkirališta za nove ulaze automobila\n"
                + "-2 - otvaranje parkirališta za nove ulaze automobila\n"
                + "-3 - ispis zarada od parkiranja po zonama\n"
                + "-4 - ispis zarada od kazni po zonama\n"
                + "-5 - ispis broja automobila koji nisu mogli parkirati po zonama\n"
                + "-6 - ispis broja automobila koji je pauk odveo na deponij po zonama\n"
                + "-7 - ispis 5 automobila s najviše parkiranja\n"
                + "-8 - stanje parkirnih mjesta po zonama (% zauzetih)\n"
                + "-Q - prekid rada programa.");
    }

    /**
     * Method for parsing arguments and saving them to main
     *
     * @param args
     */
    public static void splitArgs(String[] args) {
        Main.numCars = Integer.parseInt(args[0]);
        Main.numZones = Integer.parseInt(args[1]);
        Main.zoneCapacity = Integer.parseInt(args[2]);
        Main.maxParking = Integer.parseInt(args[3]);
        Main.timeSlot = Integer.parseInt(args[4]);
        Main.arrivalInterval = Integer.parseInt(args[5]);
        Main.departureInterval = Integer.parseInt(args[6]);
        Main.unitPrice = Integer.parseInt(args[7]);
        Main.controlInterval = Integer.parseInt(args[8]);
        Main.parkingPenalty = Integer.parseInt(args[9]);
        Main.generatedValue1 = Helper.randInt();
        Main.generatedValue2 = Helper.randInt();
        Main.generatedValue3 = Helper.randInt();
        Main.generatedValue4 = Helper.randInt();
    }

    /**
     * Method for getting random number in range (0,000-1,000)

     * @return
     */
    public static double randInt() {

        return Math.random();

    }
}