
//Name: 
import java.util.*;
import static java.lang.System.*;
/** 
 * * Handles battle sequence between the Player and Enemy object. The name and taunt of the enemy object will change based on the location but other attributes of the Enemy object will be randomized. 
 */
public class Battle
{
    private int damage;    
    private boolean dead = false;

    /**
     * Default Constructor
     */
    public Battle(){

    }

    /** 
     *Handles battle sequence between Player and random Enemy object based on location
     */
    public void battle(Player h, Enemy l){
        Rndm m = new Rndm();
        Scanner console = new Scanner (System.in);
        while (l.getHealth() > 0 && dead == false )
        {
            // hero attack
            out.println("--------------------------------------------------------------------------------------------");
            out.println(h);
            out.println(l);
            out.println();
            if (h.getHealth() > 0) {
                damage = m.damage(h.getAttackPower());
                damage -= m.defense(l.getDefense());
                if (damage < 0)
                    damage = 0;
                h.attack(l, damage);

                out.println(">>> You used " + h.getMove()+" and dealt " + damage + " damage.\n");
                out.print("Press Enter to continue ...");
                console.nextLine();	
                out.println();

                if (l.getHealth() <= 0)
                    l.setHealth(0);
            }

            //enemy attack
            if (l.getHealth() > 0)
            {
                out.println(h);
                out.println(l);
                out.println();

                damage = m.damage(l.getAttackPower());
                damage -= m.defense(h.getDefense());        
                if (damage < 0)
                    damage = 0;
                out.println(l.getTaunt());
                out.println(">>> You got hit with "+ damage +" damage.\n");
                out.print("Press Enter to continue ...");
                console.nextLine();	
                out.println();

                l.attack(h, damage);
            }

            if (h.getHealth() <= 0){
                dead = true;
                h.setHealth(0);
            }
        }

        if (dead == false)
        {
            out.println("You killed " + l.getName() +".");
            int a =  (int)(Math.random()*15);
            out.println("You earned "+ a +" coins.\n");
            h.setCoins(h.getCoins() + a);
        }
    }

    /**
     * Handles battle sequence between Player and Fire Lord Ozai (Enemy object). This sequence is only activated when Player goes to the Fire Nation Capital. 
     */
    public void bossBattle(Player h){
        Enemy ozai = new Enemy("Fire Lord Ozai", 1000, 1000, 1000, "Firebender", "");
        battle (h, ozai);
    }
}
