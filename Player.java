
//Name: 
import java.util.*;

/**
The player class extends BattleCharacter. Introduces coins. 
 */
public class Player extends BattleCharacter
{
    private int coins;
    private ArrayList <String> move = new ArrayList <String>();
    /**
    Default Player constructor
     */
    public Player()
    {
        super();
        coins = 100;
    }

    /**
    Constructs Hero with name and bender type
     */
    public Player(String n, String b)
    {
        super(n, b);
        coins = 100;
    }

    /**
    Constructs Hero with name, bender type and weapon
    This is used for non-benders. 
     */
    public Player(String n, String b, String w)
    {
        super(n, b, w);
        coins = 100;
    }

    /**
    Sets coins of Player
     */
    public void setCoins(int c)
    {
        coins = c;   
    }

    /**
    Returns amount of coins of Player
     */
    public int getCoins(){
        return coins;        
    }

    /**
    Returns random move of Player during battle
     */
    public String getMove()
    {
        Random rand = new Random();
        int n = rand.nextInt(move.size());
        return move.get(n);
    }

    /**
    Sets moves of Player. This is useful with Player encounters a trainer and is taught new moves.
     */
    public void setMove(String m)
    {
        move.add(m);
    }

    //edit
    /**
    Returns message of the Player stating name and statistics
    HP = health, ATT = maximum attack power, DEF = defense
    EX. Aang | Airbender | HP: 53 | ATT: 32 | DEF: 45 | COINS: 100 | 

    @overrides: to String in class BattleCharacter
     */
    public String toString()
    {
        return super.toString() + "Coins: " + coins + " | ";
    }

}