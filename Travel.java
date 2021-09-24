
//Name: 
import java.util.*;
import static java.lang.System.*;
/**
 * Handles the travel sequence for the player. 
 * The player can choose from 4 locations: 
 * The North Pole, Ba Sing Se, Eastern Air Temple and the Fire Nation Capital.
 * The location of the player determines the enemies they encounter. 
 * The Fire Nation Capital also holds Fire Lord Ozai, the final boss. 
 */
public class Travel
{
    private String [] locations;
    private String location;
    private int loc;	

    /**
     * Default Constructor
     */
    public Travel(){
        locations = new String[]{"North Pole", "Ba Sing Se ", "Northern Air Temple", "Fire Nation Capital"};
        loc  = 0;
        location = locations[loc];
    }

    /**
     * This class handles the travelling sequence.
     */
    public void travel(){
        Scanner console = new Scanner(System.in);
        int choice;
        out.println("You are currently in the " + location + "\n");
      
            //North Pole
            out.println("(1) " + locations[0] + ".");
            
            //Ba Sing Se
            out.println("(2) " + locations[1] + ".");
            
            // Northern Air Temple
            out.println("(3) " + locations[2] + ".");
            
            // Fire Nation Capital
            out.println("(4) " + locations[3] + ". \n\t [WARNING: HOME PLACE OF FIRE LORD OZAI. Avoid unless you are ready to face the Fire Lord]");
            out.println("(5) Stay where you are.");
            out.print("Where would you like to travel?: ");
            choice = console.nextInt();
            console.nextLine();
        

        if (choice!= 5 && locations[choice-1].equals(location) == false){
            location = locations[choice-1];
            loc = choice - 1;
        }

    }

    /**
     * Returns the player's current location
     */
    public String getLocation(){
        return location;
    }

    /**
     * Returns the location postion in array of all the locations. 
     */
    public int getLocationIndex() {
        return loc;
    }
}
