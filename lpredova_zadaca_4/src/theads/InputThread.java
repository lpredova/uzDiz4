/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import mvc.View;
import resource.ea.Car;
import resource.ea.Parking;

/**
 *
 * @author lovro
 */
public class InputThread implements Runnable {

    private volatile boolean isRunning = true;
    public static Thread inputThread;

    @Override
    synchronized public void run() {

        while (isRunning) {

            try {
                String choice = "";
                Parking parking = resource.lifecycle.ResourceLifecylceManager.parking;
                do {
                    Scanner in = new Scanner(System.in);
                    choice = in.nextLine();
                    switch (choice) {
                        case "1":
                            parking.setOpen(false);
                            View.printText("\n\nParking closed!\n\n");
                            break;

                        case "2":
                            parking.setOpen(true);
                            View.printText("\n\nParking opened!\n");
                            break;

                        case "3":
                            parking.printEarningsPayments();
                            break;

                        case "4":
                            parking.printEarningsTickets();
                            break;

                        case "5":
                            parking.printOccupiedByZones();
                            break;

                        case "6":
                            parking.printTowedByZones();
                            break;

                        case "7":
                            sortMostCommon();
                            break;

                        case "8":
                            parking.printZonesPercentage();
                            break;
                    }
                } while (!choice.equalsIgnoreCase("Q"));

                killProgram(choice);
            } catch (Exception e) {
                break;
            }
        }

    }

    public void start() {
        if (inputThread == null) {
            inputThread = new Thread(this, "Input");
            inputThread.start();
        }
    }

    public void kill() {
        isRunning = false;
        inputThread = null;
    }

    public void doAction() {

    }

    private void killProgram(String choice) {
        if (choice.equalsIgnoreCase("Q")) {
            resource.lifecycle.ResourceLifecylceManager.killThreads();
            System.exit(0);
        }
    }

    private void sortMostCommon() {
        //Merge all cars into one list
        ArrayList<Car> allCars = new ArrayList<>();
        allCars.addAll(resource.lifecycle.ResourceLifecylceManager.dumpedCars);
        allCars.addAll(resource.lifecycle.ResourceLifecylceManager.parkingCars);
        allCars.addAll(resource.lifecycle.ResourceLifecylceManager.cars);

        //Sorting
        Collections.sort(allCars, new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                return car1.getTimesParked() - car2.getTimesParked();
            }
        });

        Collections.reverse(allCars);

        View.printText("\nTop 5 cars parked\n");
        for (int i = 0; i < 5; i++) {
            allCars.get(i).printTowedCarInfo();
        }

    }
}
