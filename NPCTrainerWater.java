import java.util.*;
import static java.lang.System.*;
/**
 * NPCTrainerWater class is an object only called for Players who are Waterbenders. 
 */
public class NPCTrainerWater extends NPCTrainer
{
    private String [] moves = {"", "Ice Blade", "Water Jet", "Water Knife", "Water Bullets", "Ice whip" };
    private String move;
    /**
     * Constructor for objects of class NPCTrainerWater
     */
    public NPCTrainerWater()
    {
        super("Master Pakku");
        move = moves[(int)(Math.random()*5)+ 1];
    }

    /**
     * Prints description for NPCTrainerWater
     */
    public void describe()
    {
        out.print("Master Pakku is an instructor from the Northern Water Tribe. He can teach you " + move + ", " );
        super.describe();
    }

    /**
     * Handles diagloue between NPCTrainerWater and Player
     */ 
    public void barter(Player h){
        super.barter(h);
        h.setMove(move);
    }

    /**
     * Handles barter sequence betweeen NPCTrainerWater and Player
     */
    public void talk() {
        Scanner console = new Scanner (System.in);
        out.println("You have some talent. I may be willing to train you.\n");

        out.println("(1) Do I have to battle you to get training? ");
        out.println("(2) Sure. ");
        out.println("(3) I have no talent, sorry. ");

        out.print("Pick an option: ");
        int a = console.nextInt();
        console.nextLine();

        switch (a){
            case 1:
            out.println(">>> Do I have to battle you to get training? ");
            out.println(">>> Master Pakku: Yes. (no)");
            break;

            case 2:
            out.println(">>> Sure.");
            out.println(">>> Master Pakku: Great, then pick up the pace. ");

            break;

            case 3:
            out.println(">>> I have no talent, sorry.");
            out.println(">>> Master Pakku: Don't waste my time. ");

            break;

            default: break;
        }
    }
}
