package mvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import resource.ea.Car;
import resource.ea.Parking;

/**
 * Class for receiving user inputs and returning response
 *
 * @author Lovro
 */
public class Controller {

    private View view;
    public static int numDir = 0;
    public static int numFile = 0;
    public static int overallSize = 0;

    public Controller(View view, Model model) {
        this.view = view;
    }

    public void processOption() throws IOException {

        String choice = "";
        Parking parking = resource.lifecycle.ResourceLifecylceManager.parking;
        View.printText("Cars outside: " + resource.lifecycle.ResourceLifecylceManager.cars.size());
        
        do {
            view.getMenu();
            Scanner in = new Scanner(System.in);
            choice = in.nextLine();
            switch (choice) {
                case "1":
                    parking.setOpen(false);
                    sleepForOutput();
                    break;

                case "2":
                    parking.setOpen(true);
                    sleepForOutput();
                    break;

                case "3":
                    parking.printEarningsPayments();
                    sleepForOutput();
                    break;

                case "4":
                    parking.printEarningsTickets();
                    sleepForOutput();
                    break;

                case "5":
                    parking.printOccupiedByZones();
                    sleepForOutput();
                    break;

                case "6":
                    parking.printTowedByZones();
                    sleepForOutput();
                    break;

                case "7":
                    //Merge all cars into one list
                    ArrayList<Car> allCars = new ArrayList<>();
                    allCars.addAll(resource.lifecycle.ResourceLifecylceManager.dumpedCars);

                    //Sorting
                    Collections.sort(allCars, new Comparator<Car>() {
                        @Override
                        public int compare(Car car1, Car car2) {
                            return car1.getTimesParked() - car2.getTimesParked();
                        }
                    });

                    Collections.reverse(allCars);

                    View.printText("\nTop 5 cars parked\n");
                    for(int i = 0; i < 5; i++) {
                        allCars.get(i).printCarInfo();
                    }                
                    break;

                case "8":
                    parking.printZonesPercentage();
                    sleepForOutput();
                    break;
            }
        } while (!choice.equalsIgnoreCase("Q"));

        if (choice.equalsIgnoreCase("Q")) {
            resource.lifecycle.ResourceLifecylceManager.killThreads();
            System.exit(0);
        }
    }

    private void sleepForOutput() {
        try {
            Thread.sleep(1500);                 
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
