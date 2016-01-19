package mvc;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import mvc.Model;
import mvc.View;


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
