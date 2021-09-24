import java.util.*;
import static java.lang.System.*;
/**
 * NPCTrainerEarth class is an object only called for Players who are Earthbenders. 
 */
public class NPCTrainerEarth extends NPCTrainer
{
    private String [] moves = {"", "Earth Block", "Earth Launch", "Quicksand", "Slab shackles", "Sand spout" };
    private String move;
    /**
     * Constructor for objects of class NPCTrainerEarth
     */
    public NPCTrainerEarth()
    {
        super("King Bumi");
        move = moves[(int)(Math.random()*5)+ 1];
    }

    /** 
     * Prints description for NPCTrainerEarth
     */
    public void describe(){
        out.print("King Bumi is the king of Omashu. He can teach you "+ move +", ");
        super.describe();
    }

    /** 
     * Handles diagloue between NPCTrainerEarth and Player
     */
    public void talk(){
        Scanner console = new Scanner (System.in);
        out.println("Do you got what it takes? \n");
        out.println("(1) Can I ride down the Omashu delivery system? ");
        out.println("(2) Yeah I do!");
        out.println("(3) Sorry I don't. Gotta blast.\n");

        out.print("Pick an option: ");
        int a = console.nextInt();
        console.nextLine();

        switch (a){
            case 1:
            out.println(">>> Can I ride down the Omashu delivery system?");
            out.println(">>> No! Chicken Thigh?");
            break;

            case 2:
            out.println(">>> Yeah I do! ");
            out.println(">>> That's the spirit! You are free to use the chutes any day!");
            break;

            case 3:
            out.println(">>> Sorry I don't. Gotta blast.");
            out.println(">>> King Bumi: Stay for dinner at least!");
            break;

            default: break;
        }
    }

    /**
     * Handles barter sequence betweeen NPCTrainerEarth and Player
     */
    public void barter(Player h){
        super.barter(h);
        h.setMove(move);
    }
}
