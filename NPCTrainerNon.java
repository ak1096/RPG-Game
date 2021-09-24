import java.util.*;
import static java.lang.System.*;
/**
 *  NPCTrainerNon class is an object only called for Players who are Non-benders. 
 */
public class NPCTrainerNon extends NPCTrainer
{
    private String [] moves = {"", "lunge at", "strike", "throw sand in the eyes of ", "quick attack ", "properly kick" };
    private String move;
    /**
     * Constructor for objects of class NPCTrainerNon
     */
    public NPCTrainerNon()
    {
        super("Master Piando");
        move = moves[(int)(Math.random()*5)+ 1];
    }

    /** 
     * Prints description for NPCTrainerNon
     */
    public void describe(){
        out.print("Master Piando is a swordmaster. He can teach you to " + move + " your enemies, ");
        super.describe();
    }

    /**
     * Handles diagloue betweeen NPCTrainerNon and Player
     */
    public void talk(){
        Scanner console = new Scanner (System.in);
        out.println("Master Piando: Prove yourself to me and I may teach you the way of the sword.\n" );
        out.println("(1) I'm not here for sword tricks. I got a different weapon.");
        out.println("(2) Sure man hit me up. ");
        out.println("(3) Naw I'm good.\n");

        out.print("Pick an option: ");
        int a = console.nextInt();
        console.nextLine();

        switch (a){
            case 1:
            out.println(">>> I'm not here for sword tricks. I got a different weapon.");
            out.println(">>> Master Piando: Then I can teach you the way of calligraphy");
            break;

            case 2:
            out.println(">>> Sure man, hit me up.");
            out.println(">>> Master Piando: You still need to prove yourself to me.");
            break;

            case 3:
            out.println(">>> Naw I'm good. ");
            out.println(">>> Master Piando: Suit yourself. ");
            break;

            default: break;
        }

    }

    /**
     * Handles barter sequence betweeen NPCTrainerNon and Player
     */
    public void barter(Player h){
        super.barter(h);
        h.setMove(move);
    }
}
