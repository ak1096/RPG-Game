
//Name: 
import java.util.*;
import static java.lang.System.*;
/**
NPCTrainer class extends NPC. The trainer allows the player to learn moves and improve attack and defense for gold. The trainer is decided by the bender type of the player. The class realizes the 3 abstract methods of the NPC super class. The interface will provide a description and allow the player to talk or barter. 
 */
public abstract class NPCTrainer extends NPC
{
    private Rndm m = new Rndm();
    private int att;
    private int def; 

    /**
     * Constructs a NPCTrainer object with name
     */
    public NPCTrainer(String n)
    {
        super(n);
        att = m.choice(5,10);
        def = m.choice(5,10);
    }

    /**
     * Prints description of NPCTrainer
     */
    public void describe()
    {
        out.println("improve you attack by " + att +  " and improve you defense by " + def);
    }

    /**
     * Handles dialouge between Player and NPCTrainer
     */
    public void talk(){

    }

    /** 
     * Handles barter sequence between Player and NPCTrainer
     */
    public void barter(Player h){
        Scanner console = new Scanner(System.in);
        out.println("Pay me 10 coins for training.\n");

        out.println("(1) Pay 10 coins ");
        out.println("(2) Leave");

        out.print("What do you choose: ");
        int choice = console.nextInt();
        console.nextLine();

        if (choice == 1 && h.getCoins() > 0)
        {
            out.println (super.getName() + " trains you and raises your attack by " + att + " and defense by " + def);
            h.setAttackPower(h.getAttackPower() + att);
            h.setDefense(h.getDefense() + def);
            h.setCoins(h.getCoins() - 10);
        }
        
        else if (choice == 1 && h.getCoins() <= 0){
            out.println("Sorry you don't have enough money.");
        }
        else
            out.println("Your choice.");

    }
}
