
//Name: 
import java.util.*;
import static java.lang.System.*;
/**
 * This class determines what will happen to the Player. 
 * Player has 3 encounters: battling, engaging a NPCTrainer (based on bender type)
 * and engaging NPCRebel. Their is an equal chance for all the results. 
 */
public class Encounter
{
    private int loc;
    private NPCTrainer t;
    private NPCRebel r;
    private NPCHealer w;
    private Enemy[] l;
    private NPCCabbageMan c;

    private Battle b = new Battle();
    /**
     * Default constructor
     */

    public Encounter(){}

    /** 
     * Random encounter: battle and NPC (NPCTrainer and NPCRebel)
     * There is not an equal chance to meet each encounter. Battles occur around 67% of the time, NPCTrainer: 12.5%, NPCHealer: 8%, NPCRebel: 8%, NPCCabbageMan: 5%
     */
    public void randomEncounter(Player h, Travel travel)
    {
        Rndm m = new Rndm();
        Scanner console = new Scanner(System.in);
        loc = travel.getLocationIndex();
        int p = m.choice(1, 120);
        if (p <= 80) //battle
            p = 5;
        else if(p > 80 && p <= 95) // trainer
            p = 1;
        else if(p > 95 && p <= 105) //healer
            p = 2;
        else if(p > 105 && p <= 115) //rebel
            p = 3;
        else //cabbage merchant
            p = 4;

        //1: Trainer
        //2: Healer
        //3: Rebel
        //4: CabbageMan
        //5: Battle

        switch (p)
        {
            case 1: t = pickNPCTrainer(h);
            int choice = 1;
            do {
                out.println("You have enountered " + t.getName() );
                out.println("(1) Describe");
                out.println("(2) Talk");
                out.println("(3) Barter");
                out.println("(4) Quit");

                out.print("Pick an option: ");
                choice = console.nextInt();
                console.nextLine();

                out.println();	
                switch (choice){
                    case 1: t.describe();
                    out.println();
                    break;

                    case 2: t.talk();
                    out.println();
                    break;

                    case 3: t.barter(h);
                    out.println();
                    break;

                    default: 
                    break;
                }
            } while (choice != 4);

            break;

            case 2: w = new NPCHealer();
            choice = 1;
            do {
                out.println("You have enountered " + w.getName() );
                out.println("(1) Describe");
                out.println("(2) Talk");
                out.println("(3) Barter");
                out.println("(4) Quit");

                out.print("Pick an option: ");
                choice = console.nextInt();
                console.nextLine();

                out.println();	
                switch (choice){
                    case 1: w.describe();
                    out.println();
                    break;

                    case 2: w.talk();
                    out.println();
                    break;

                    case 3: w.barter(h);
                    out.println();
                    break;

                    default: 
                    break;
                }
            } while (choice != 4);
            break;

            case 3:
            r = NPCRebel.randomNPCRebelMaker(travel);

            do {
                out.println("You have enountered " + r.getName() );
                out.println("(1) Describe");
                out.println("(2) Talk");
                out.println("(3) Barter");
                out.println("(4) Quit");

                out.print("Pick an option: ");
                choice = console.nextInt();
                console.nextLine();

                out.println();	
                switch (choice){
                    case 1: r.describe();
                    out.println();
                    break;

                    case 2: r.talk();
                    out.println();
                    break;

                    case 3: r.barter(h);
                    out.println();
                    break;

                    default: 
                    break;
                }
            } while (choice != 4);
            break;
            //r.setLocationIndex(travel.getLocationIndex());

            case 4: 
            c = new NPCCabbageMan();

            do {
                out.println("You have enountered " + c.getName() );
                out.println("(1) Describe");
                out.println("(2) Talk");
                out.println("(3) Barter");
                out.println("(4) Quit");

                out.print("Pick an option: ");
                choice = console.nextInt();
                console.nextLine();

                out.println();	
                switch (choice){
                    case 1: c.describe();
                    out.println();
                    break;

                    case 2: c.talk();
                    out.println();
                    break;

                    case 3: c.barter(h);
                    out.println();
                    break;

                    default: 
                    break;
                }
            } while (choice != 4);

            break;

            case 5: 
            l = new Enemy[3];
            int att = m.choice(h.getAttackPower()/2, (int)(h.getAttackPower()*1.25));
            int hp = (int)((double)h.getHealth()*.75);
            int def = m.choice(h.getDefense()/2, (int)(h.getDefense()*1.25));
            switch (loc) {
                case 0 : 
                l[0]= new Enemy ("Old Ponytail Zuko", hp, att, def, "Firebender", "");
                l[1] = new Enemy ("Admiral Zhao", hp, att, def,  "Firebender", "");
                l[2] = new Enemy ("Fire Navy Solider", hp, att, def, "Firebender", "");
                break;

                case 1: 
                l[0] = new Enemy ("Long Fen", hp, att, def, "Firebender", "");
                l[1] = new Enemy ("Dai Li Agent", hp, att, def, "Firebender", "");
                l[2] = new Enemy ("Fire Nation Solider", hp, att, def, "Firebender", "");
                break;

                case 2: 
                l[0] = new Enemy ("War Minister Qin", hp, att, def, "Firebender", "");
                l[1] = new Enemy ("Azula", 20, 15, 15, "Firebender", "");
                l[2] = new Enemy ("Fire Nation Solider", hp, att, def, "Firebender", "");
                break;

                default:
                break;
            }

            Enemy opponent = l[m.choice(0,2)];
            out.println("You have encountered " + opponent);
            console.nextLine();

            out.println("(1) Battle");        
            out.println("(2) Hide [You have a 50% of staying hidden]");    

            out.print("Choose one of the options above: ");
            choice = console.nextInt();
            console.nextLine();

            out.print("...");
            console.nextLine();
            out.println();

            if (choice == 1)
                b.battle(h,opponent);
            else
            {
                choice =  m.choice(1,2);

                if (choice == 1){
                    out.println("You were not able to hide from your opponent.\n");
                    b.battle(h, opponent);
                }
                else
                    out.println("You hid from " + opponent.getName()+".\n");
            }
            break;

            //case 4: r = NPCRebel.randomNPCRebelMaker(travel);
            //r.setLocationIndex(travel.getLocationIndex());

            default: break;
        }
    }

    /**
     *If the Random Encounter class results in engaging with a NPCTrainer
     *,this class helps pick the correct Trainer based on bender type.  
     */
    private NPCTrainer pickNPCTrainer(Player h){
        switch (h.getBenderType()){
            case "Firebender":
            return t = new NPCTrainerFire();

            case "Waterbender":
            return t = new NPCTrainerWater();

            case "Earthbender":
            return t = new NPCTrainerEarth();

            case "Non-bender":
            return t = new NPCTrainerNon();

            default:
            return t = new NPCTrainerNon();
        }

    }
}
