
//Name: 
/**
The Charcter class is an abstract class that outlines all of the game characters. All characters have names and bender types.
 */
public abstract class Character
{
    private String name;
    private String benderType;

    /** 
    Default contructor
     */
    public  Character(){
        name = "unnamed";
        benderType = "none";
    }

    /** 
    Contructs object with a name
     */
    public  Character(String n){
        name = n;
        benderType = "none";
    }

    /** 
    Constructs object with name and benderType
     */
    public Character (String n, String b)
    { 
        name = n;
        benderType = b;
    }

    /** 
    Sets the name of this Character
     */
    public void setName(String n)
    {
        name = n;
    }

    /** 
    Returns Character name
     */
    public String getName()
    {
        return name;
    }

    /** 
    Sets bender type of this Character    

     */
    public void setBenderType(String b)
    {
        benderType = b;
    }

    /**
    Returns bender type of this Character
     */
    public String getBenderType()
    {
        return benderType;
    }

    /** 
    Returns Character's name
     */
    public String toString()
    {
        return getName() + " | " + getBenderType() + " | ";
    }

}