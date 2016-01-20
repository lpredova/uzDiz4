package mvc;
import java.io.IOException;
import java.util.Scanner;


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
        do {
            view.getMenu();
            Scanner in = new Scanner(System.in);
            choice = in.nextLine();
            switch (choice) {
                case "1":
                    resource.lifecycle.ResourceLifecylceManager.parking.setOpen(true);
                    break;

                case "2":
                    resource.lifecycle.ResourceLifecylceManager.parking.setOpen(false);
                    break;

                case "3":
                    resource.lifecycle.ResourceLifecylceManager.parking.printEarningsPayments();
                    break;

                case "4":
                    resource.lifecycle.ResourceLifecylceManager.parking.printEarningsTickets();
                    break;

                case "5":
                    resource.lifecycle.ResourceLifecylceManager.parking.printOccupiedByZones();
                    break;

                case "6":
                    resource.lifecycle.ResourceLifecylceManager.parking.printTowedByZones();
                    break;

                case "7":
                   
                    break;

                case "8":

                    break;

            }

            
        
        } while (!choice.equalsIgnoreCase("Q"));

    }
}
