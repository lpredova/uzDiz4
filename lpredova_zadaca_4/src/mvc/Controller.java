package mvc;
import java.io.IOException;
import java.util.ArrayList;
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
        do {
            view.getMenu();
            Scanner in = new Scanner(System.in);
            choice = in.nextLine();
            switch (choice) {
                case "1":
                    //System.out.println(Model.owners);
                    
                    ArrayList<Car> car = resource.lifecycle.ResourceLifecylceManager.cars;
                    System.out.println(car);
                    
                    Parking parking = resource.lifecycle.ResourceLifecylceManager.parking;
                    System.out.println(parking);
                    break;

                case "2":
            
                    break;

                case "3":
                   
                    break;

                case "4":
                    
                    break;

                case "5":
                   

                    break;

                case "6":


                    break;

                case "7":
                   
                    break;

                case "8":

                    break;

                case "9":
                    
                    break;
            }

            
        
        } while (!choice.equalsIgnoreCase("Q"));

    }
}
