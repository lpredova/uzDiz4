package mvc;
import java.io.IOException;
import java.util.Scanner;
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
                   
                    break;

                case "8":
                    parking.printZonesPercentage();
                    break;
            }  
        } while (!choice.equalsIgnoreCase("Q"));

    }
}
