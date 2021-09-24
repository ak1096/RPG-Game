
//Name: 
import java.util.*;
import static java.lang.System.*;
/** 
 * NPCRebel extends NPC. This object helps the Player boost their health and serves as a rest stop in the game. 
 */
public class NPCRebel extends NPC
{
    private int loc;
    /**
     * Constructs a NPCRebel object with name
     */
    public NPCRebel(String n)
    {
        super(n);
    }

    /**
     * Prints description of the NPCRebel
     */
    public void describe()
    {
        out.println(super.getName() + " will offer you refuge for a night.");
    }

    /**
     * Handles diagloue between NPCRebel and Player
     */
    public void talk(){
        switch (super.getName()) {
            case "Princess Yue":
            out.println("Isn't the moon beautiful?");
            //out.println("");
            break;

            case "Jet and the Freedom Fighters":
            out.println("We aren't the people we used to be.");
            break;

            case "Teo":
            out.println("Us Air Walkers can definetly help out!");
            break;
            default: break;
        }

    }

    /**
     * Handles Barter sequence between NPCRebel and Player
     */
    public void barter(Player h){
        Scanner console = new Scanner (System.in);
        int heal = (int)(Math.random()*(h.getHealth()/2) +1);
        out.println("(1) Yes." );
        out.println("(2) No." );
        out.print("Will you stay for one night?: ");
        int choice = console.nextInt();
        console.nextLine();

        switch(choice) {
            case 1: out.println(super.getName() + " gave you shelter for a night. Your health increased by " + heal);
            h.setHealth(h.getHealth() + heal);
            break;

            case 2: out.println("Okay have a safe journey!");
            break;

            default: break;
        }

    }

    /** The method below is a static method. It's responsible
     * for creating a random NPCRebel object for the Player. NPCRebels differ based on location.   
     */
    public static NPCRebel randomNPCRebelMaker(Travel t)
    {
        String[] nameOptions = {"Princess Yue", "Jet and the Freedom Fighters", "Teo", };
        String randName = nameOptions[t.getLocationIndex()];
        return new NPCRebel(randName);
    }

}
