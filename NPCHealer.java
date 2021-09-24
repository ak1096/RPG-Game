
//Name: 
import java.util.*;
import static java.lang.System.*;
/**
 * The NPCHealer class restores the player's health. The default for the player is 100. If the player's health is greater than 100, the Healer adds 100 
 * to their health. (This is done purposefully due to the boss character's difficulty.)
 */

public class NPCHealer extends NPC
{
    /**
     * Constructs NPCHealer class
     */
    public NPCHealer()
    {
        super("Healer Unho");   
    }

    /**
    Prints description of NPC
     */
    public void describe()
    {
        out.println("Unho is a highly respected healer of the waterbender faction. He will heal you for a small amount of gold.");
    }

    /**
    Returns dialogue between Player and NPC
     */
    public void talk()
    {
        out.println("Hello traveler. Would you like to recieve healing?");
    }

    /**
    Runs barter sequence between Player and NPC
     */
    public void barter(Player h)
    {
        Scanner console = new Scanner(System.in);
        out.println("Pay me 10 coins to restore your health.\n");

        out.println("(1) Pay 10 coins ");
        out.println("(2) Leave");

        out.print("What do you choose: ");
        int choice = console.nextInt();
        console.nextLine();

        if (choice == 1 && h.getCoins() > 0)
        {
            out.println (super.getName() + " restores your health.");
            h.setCoins(h.getCoins() - 10);
            if (h.getHealth()>= 100)
                h.setHealth(h.getHealth() + 100);
            else
                h.setHealth(100);
        }

        else if (choice == 1 && h.getCoins() <= 0){
            out.println("Sorry you don't have enough money.");
        }
        else
            out.println("Your choice.");
    }
}
