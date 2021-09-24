
//Name: 
import java.util.*;
/**
Enemy class extends BattleCharacters. Introduces taunts and list of moves.
 */
public class Enemy extends BattleCharacter
{
    private String taunt;
    private ArrayList <String> move = new ArrayList <String>();
    // Long Fen/ Dai Li, Fire Nation Soliders, Admiral Zhao, 
    /**
    Default Enemy Constructor
     */
    public Enemy()
    {
        super();
        taunt = "";
    }

    /**
    Constructs Enemy with all properties 
    (Name, Health, Attack, Defense, Bender Type and Taunt)
     */
    public Enemy (String n, int h, int a, int d, String b, String t)
    {
        super(n, h, a, d, b);
        taunt = t;
    }

    /**
    Sets taunt of Enemy
     */
    public void setTaunt(String t)
    {
        taunt = t;   
    }

    /**
    Returns taunt of Enemy
     */
    public String getTaunt(){
        return taunt;        
    }

    /**
    Returns move of Enemy
     */
    public String getMove()
    {
        Random rand = new Random();
        int n = rand.nextInt(0)+4;
        return move.get(n);
    }

    /**
    Sets move of Enemy
     */
    public void setMove(String m)
    {
        move.add(m);
    }

}
