
//Name: 
import java.util.*;
import static java.lang.System.*;
/**
 * NPCCabbageMan class is basically a mini-game for the player to play.
 */
public class NPCCabbageMan extends NPC
{
    /**
     * Constructs NPCCabbageMan object
     */
    public NPCCabbageMan(){
        super("The Cabbage Merchant");
    }

    /**
     * This class handles diagloue between the NPCQuest object and player.
     */
    public void talk(){
        Scanner console = new Scanner(System.in);
        out.println("MY CABBAGES!!!\n");

        out.println("(1) I didn't even touch them.");
        out.println("(2) So sorry, let me help you!\n");

        out.print("Pick an option: ");
        int a = console.nextInt();
        console.nextLine();

        switch(a) {
            case 1:
            out.println(">>> I didn't even touch them.");
            out.println(">>> Cabbage Merchant: Exactly what a cabbage thief would say...");
            break;

            case 2:
            out.println(">>> So sorry, let me help you!");
            out.println(">>> Cabbage Merchant: DON'T TOUCH THEM!!!");
            break;

            default: break;
        }
    }

    /**
     * Prints description of NPCCabbageMan
     */
    public void describe(){
        out.println("The cabbage merchant minds his own business caring for his cabbages. Be wary of him.");
    }

    /**
     * Handles barter sequence between player and NPCCabbageMan
     */
    public void barter(Player h){
        Scanner console = new Scanner(System.in);
        out.println("Do you want to play a game?");
        out.println("(1) Yes");
        out.println("(2) Why?");

        int choice = console.nextInt();
        console.nextLine();

        switch(choice){
            case 1:
            quest(h);
            break;

            case 2: out.println("You can earn coins!");
            out.println("(1) Play the game.");
            out.println("(2) Leave\n");

            out.print("Pick an option: ");
            choice = console.nextInt();
            console.nextLine();

            switch(choice)
            {
                case 1: 
                quest(h);
                break;

                default: 
                break;
            }

            break;

            default: 
            break;
        }
    }

    /**
     * This class runs the Hangman game.
     */
    public void quest(Player h){
        Scanner console = new Scanner(System.in);
        boolean ye = false;
        int guesses = 6;
        boolean won = true;

        out.println("Guess the character! ");
        String [] character = {"momo", "appa", "aang", "sokka", "katara", "toph beifong", "zuko", "the cabbage hero", "guru pathik", "general uncle iroh", "fire lord ozai", 
                "quenchist mushroom",  "sparky sparky boom boom man", "hakoda", "ty lee", "suki", "azula", "mai", "admiral zhao", "avatar roku", "fang the dragon", "avatar kyoshi", 
            "avatar kuruk", "avatar yangchen", "tui and la", "koh the face stealer", "wan shi tong", "hei bai", "lionturtle", "june", "king bumi", "master pakku", "azulon", 
        "chan"};
        String w = character[(int)(Math.random()*character.length)];
        char [] word = w.toCharArray();
        char [] guess = new char [word.length];

        for (int i = 0; i < guess.length; i++){
            if (w.charAt(i) != ' ')
                guess[i] = '_';

            if (w.charAt(i) == ' ')
                guess[i] = ' ';
        }

        while (guesses > 0){
            ye = false;
            won = true;
            for (int i = 0; i < guess.length; i++){
                out.print(guess[i] + " ");
            }
            out.println();
            out.println("Guesses: " + guesses);
            out.print("Your guess: ");
            String a = console.nextLine();
            out.println();

            a.toLowerCase();
            char b = a.charAt(0);

            for (int i = 0; i < guess.length; i++){
                if (word[i] == b){
                    guess[i] = b;
                    ye = true;
                }
            }

            if (ye == false)
                guesses--;

            if (guesses <=0)
                out.println("You lost. The character was " + w);

            for (int i = 0; i < guess.length; i++){
                if (guess[i] != word[i])
                    won = false;

            }

            if (won){
                out.println("You guessed correctly! The character was " + w + ".");
                int c =  (int)(Math.random()*15);
                out.println("You earned "+ c +" coins.\n");
                h.setCoins(h.getCoins() + c);
                guesses = 0;
            }
        }
    }
}
