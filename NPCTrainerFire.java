import java.util.*;
import static java.lang.System.*;
/**
 * NPCTrainerFire class is an object only called for Players who are Firebenders. 
 */
public class NPCTrainerFire extends NPCTrainer
{
    private String [] moves = {"", "Fire Blade", "Fire Bomb", "Fire Daggers", "Fire Whip", "Fireballs" };
    private String move;
    /**
     * Constructor for objects of class NPCTrainerFire
     */
    public NPCTrainerFire()
    {
        super("Jeong Jeong");
        move = moves[(int)(Math.random()*5)+ 1];
    }

    /** 
     * Prints description for NPCTrainerFire
     */
    public void describe(){
        out.print("Jeong Jeong is a firebending prodigy commonly referred to as \"The Deserter\". He can teach you " + move + ", ");
        super.describe();
    }

    /**
     * Handles diagloue between NPCTrainerFire and Player
     */
    public void talk(){
        Scanner console = new Scanner (System.in);
        out.println("Jeong Jeong: I don't need another disapointment. Show you have discipline and I may be train you for 10 coins.\n");
        out.println("(1) What like Admiral Zhao?");
        out.println("(2) *Avatar Roku appears in vision and scolds Jeong Jeong.*");
        out.println("(3) LOL, I got no discipline. Peace.\n");

        out.print("Pick an option: ");
        int a = console.nextInt();
        console.nextLine();

        switch (a){
            case 1:
            out.println(">>> What like Admiral Zhao?");
            out.println(">>> Jeong Jeong: ...");
            break;

            case 2:
            out.println(">>> *Avatar Roku appears in vision and scolds Jeong Jeong.*");
            out.println(">>> Jeong Jeong: I guess I have to now. ¯\\_(ツ)_/¯");
            break;

            case 3:
            out.println(">>> LOL, I got no discipline. Peace.");
            out.println(">>> Jeong Jeong: Please leave.");
            break;

            default: break;
        }
    }

    /**
     * Handles barter sequence betweeen NPCTrainerFire and Player
     */
    public void barter(Player h){
        super.barter(h);
        h.setMove(move);
    }
}
