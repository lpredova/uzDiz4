/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

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

}
