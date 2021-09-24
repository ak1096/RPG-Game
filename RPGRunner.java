
//Name: 
import java.util.*;
import static java.lang.System.*;

/** 
 * Interface of the game. Handles overall run of game. 
 */
public class RPGRunner
{
    public static void main(String[] args)
    {
        int type;
        String weapon = "";
        Player hero;

        Encounter e = new Encounter();
        Travel t = new Travel();
        Battle b = new Battle();

        boolean notDead = true;
        boolean won = false;
        Scanner console = new Scanner(System.in);

        out.print("What is your name?: ");
        String name = console.nextLine();
        out.println();
        out.println("Welcome to the Avatar the Last Airbender RPG Game. ");
        out.println("Choose your path and defeat Fire Lord Ozai.");
        out.println("When the game ask you a question, input the number correlated to the option\n");

        out.println("(1) Firebender");
        out.println("(2) Waterbender");
        out.println("(3) Earthbender");
        out.println("(4) Non-bender");
        out.print("Choose your bender type (input number): ");
        type = console.nextInt();
        console.nextLine();
        out.println("\n\n\n");

        if (type == 4)
        {
            out.println("(1) Sword");
            out.println("(2) Bow and Arrow");
            out.println("(3) Fan");

            out.print("Choose a weapon above or of your choice (type name): ");
            String a  = console.nextLine();

            if (a == " " || a == "")
                a = "No weapon";

            switch (a){
                case "1": 
                weapon = "Sword";
                break;

                case "2":
                weapon = "Bow and Arrow";
                break;

                case "3":
                weapon = "Fan";
                break;

                default: weapon = a;
                break;
            }
            out.println();
        }

        switch(type)
        {
            case 1: hero = new Player(name, "Firebender");
            break;

            case 2: hero = new Player(name, "Waterbender");
            break;

            case 3: hero = new Player(name, "Earthbender");
            break;

            case 4: hero = new Player(name, "Non-bender", weapon);
            break;

            default: hero = new Player();
            break;
        }
        type = 1;
        hero.setMove("Attack");
        int i =  4;
        while (notDead && type != 3)
        {
            out.println("Current Location: " + t.getLocation());
            out.println(hero +"\n");

            out.println("Turns until travel: " + i+"\n");
            out.println("(1) Continue");
            out.println("(2) Check Stats");
            out.println("(3) Quit\n");
            out.print("Pick an option: ");
            type = console.nextInt();
            console.nextLine();
            out.println();

            switch(type){
                case 1:e.randomEncounter(hero, t);
                out.print("Press Enter...");
                console.nextLine();
                System.out.print('\u000C');
                i--;
                break;

                default: break;

            }

            if (i == 0){
                t.travel();
                out.println();
                i=4;
            }

            if (t.getLocation().equals("Fire Nation Capital"))
            {
                b.bossBattle(hero);
            }

            if (hero.getHealth() <= 0)
            {
                notDead = false;
            }

            if (hero.getCoins() >= 1000){
                out.println("You have enough coins to live a peaceful life away from the eyes of the Fire Nation!");
                out.println("Would you like to abandon your quest and live a good life?");

                out.println("(1) Yes.");
                out.println("(2) No.\n");

                out.print("Pick an option: ");
                type = console.nextInt();
                console.nextLine();

                switch(type){
                    case 1:
                    out.println("Have a fun life!");
                    type = 3;
                    break;

                    case 2:
                    out.println("I am proud of you.");
                    break;

                    default:
                    break;
                }
                out.println();
            }
        }

        if (won == false && notDead == false)
        {
            out.println("You died. At least you tried.");
        }
        else if (won == false)
            out.println("You didn't defeat the Fire Lord! You failed everyone! See you next time!");
    }
}

