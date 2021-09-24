
//Name: 
/**
NPC class is abstract and extends Character. This class has 3 abstract methods that must be realized in all NPC sub classes. When the player encounters an NPC, the interface will procide a description of the NPC and allow the player to talk or barter with the NPC. 
 */
public abstract class NPC extends Character
{
    /**
     * Default Constructor
     */
    public NPC(){

    }

    /**
     * Constructs NPC with name
     */
    public NPC(String n){
        super(n);
    }

    /**
    Prints description of NPC
     */
    public abstract void describe();

    /**
    Returns dialogue between Player and NPC
     */
    public abstract void talk();

    /**
    Runs barter sequence between Player and NPC
     */
    public abstract void barter(Player h);

}
