
//Name: 
/**
The BattleCharacter class is an abtsract class that extends Character. This includes all characters that can engage in battle. BattleCharacter introduces health, attack power, defense attributes
 */
public abstract class BattleCharacter extends Character
{
    private int health;
    private int attackPow;
    private int defense;
    private String weapon = "";

    /** 
    Constructs BattleCharacter object
     */
    public BattleCharacter()
    {
        super();
        health = 100;
        attackPow = 15;
        defense  = 10;
    }

    /** 
    Constructs BattleCharacter objects with name and bender type
     */
    public BattleCharacter(String n, String b)
    {
        super(n, b);
        health = 100;
        attackPow = 40;
        defense  = 20;
    }

    /** 
    Constructs BattleCharacter objects with name, bender type and weapon
     */
    public BattleCharacter(String n, String b, String w)
    {
        super(n, b);
        health = 100;
        attackPow = 15;
        defense  = 10;
        weapon = w;
    }

    /** 
    Constructs BattleCharacter objects with ALL Properties
     */
    public BattleCharacter(String n, int h, int a, int d, String b)
    {
        super(n, b);
        health = h;
        attackPow = a;
        defense  = d;
    }

    /** 
    Sets health of this BattleCharacter
     */
    public void setHealth(int h)
    {
        health = h;
    }

    /**
    Set defense of this BattleCharacter
     */
    public void setDefense(int d)
    {
        defense = d;
    }

    /**
    Set attack power of this BattleCharacter
     */
    public void setAttackPower(int a)
    {
        attackPow = a;	
    }

    /**
    Returns health of this BattleCharacter
     */

    public int getHealth()
    {
        return health;
    }

    /**
    Returns defense of this BattleCharacter
     */
    public int getDefense()
    {
        return defense;
    }

    /**
    Returns attack of this BattleCharacter
     */
    public int getAttackPower()
    {
        return attackPow;	
    }

    /**
    Handles how much attack power Battle Character uses during battle
     */
    public void attack(BattleCharacter b, int d){
        b.setHealth(b.getHealth() - d);
    }

    public abstract String getMove();

    public abstract void setMove(String m);

       /**
    Returns message from BattleCharacter stating name and battle stats
     */
    public String toString()
    {
        if (weapon == "")
        return super.toString() +  "HP: " + health +" | Att: " + attackPow +" | Def: "+ defense + " | ";
        
        return super.toString() + weapon + " | HP: " + health +" | Att: " + attackPow +" | Def: "+ defense + " | ";
        
    }
}
