package mvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.Comparator;
import java.util.Scanner;
import resource.ea.Car;
import resource.ea.Parking;
import theads.OwnerThread;

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
        do {
            view.getMenu();
            Scanner in = new Scanner(System.in);
            choice = in.nextLine();
            switch (choice) {
                case "1":
                    parking.setOpen(true);
                    break;

                case "2":
                    parking.setOpen(false);
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
                    //Merge all cars into one list
                    ArrayList<Car> allCars = new ArrayList<>();
                    allCars.addAll(resource.lifecycle.ResourceLifecylceManager.cars);
                    allCars.addAll(resource.lifecycle.ResourceLifecylceManager.parkingCars);

                    //Sorting
                    Collections.sort(allCars, new Comparator<Car>() {
                        @Override
                        public int compare(Car car1, Car car2) {
                            return car1.getTimesParked() - car2.getTimesParked();
                        }
                    });
                    
                    allCars = (ArrayList<Car>) allCars.subList(0, 5);
                    View.printText("Top 5 cars parked");
                    for (Car allCar : allCars) {
                         allCar.printCarInfo();
                    }

                    break;

                case "8":
                    parking.printZonesPercentage();
                    break;
            }
        } while (!choice.equalsIgnoreCase("Q"));
        
        
        if(choice.equalsIgnoreCase("Q")){
            resource.lifecycle.ResourceLifecylceManager.killThreads();
        }
    }
}
