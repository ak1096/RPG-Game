
//Name: 
import java.util.*;
/**
 * The Rndm class contains helper methods that help get random numbers easily. 
 */
public class Rndm
{

    /**
     * Default Constructor
     */
    public Rndm(){

    }

    /**
     * Returns random int that determines damage amount in attacks during battle sequence. 
     */
    public int damage(int high)
    {
        Random m = new Random();
        return m.nextInt(high/2+1)+high/2;
    }

    /** 
     * Returns random int that determines defense amount in attacks during battle sequence
     */
    public int defense (int high)
    {
        Random m = new Random();
        return m.nextInt(high+1)+1;
    }

    /**
     * Returns random int between lower bound and upper bound
     */
    public int choice(int low, int high)
    {
        Random m = new Random();
        return m.nextInt(high-low+1)+low;
    }
}
