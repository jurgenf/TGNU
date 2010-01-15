import java.util.ArrayList;
/**
 * This class is the main class for the program. From this class the game starts and all the other objects are initialized.
 * This class also holds some basic methods like the getUsername method.
 * 
 * @author TGNU Team
 * @version 1.0
 */
public class GameController
{
    private static String username;
    private static ArrayList<String> goal;
    
    /**
     * the main method starts the game by printing the welcome tekst and call the initialize method.
     * 
     * @param   args arguments that where passed from the command
     */
    public static void main(String[] args)
    {
        //print the start screen
        Terminal.print("******************************************************");
        Terminal.print("*   _______ _____ _   _ _    _                       *");
        Terminal.print("*   |__   __/ ____| \\  | |  | |                      *");
        Terminal.print("*     | | | |  __|  \\| | |  | |                      *");
        Terminal.print("*     | | | | |_ | . ` | |  | |                      *");
        Terminal.print("*     | | | |__| | |\\  | |__| |                      *");
        Terminal.print("*     |_|  \\_____|_| \\_|\\____/                       *");
        Terminal.print("*        This Game is Not Unix version 1.0           *");
        Terminal.print("*****************************************************");
        Terminal.print("");
        Terminal.print("Please enter your username:");
        username = Terminal.askUsername();
        GameController.initTheGame();
    }

    /**
     * Initialize the game!
     * This method start the game by showing the intro and initializes all components
     * After all components are loaded the welcome message is showed.
     */
    private static void initTheGame()
    {
        Terminal.setPrompt(username+"@h4ckst4ti0n> ");
        
        //start the intro
        //GameController.hackCinematic();
        
        //create the filesystem
        Filesystem.createFilesystem();
        
        //load in the commands that can be used.
        Command.initCommandList();
        
        //create the list of files which needs to be found.
        GameController.initGoal();
        
        //print the welcome message
        Terminal.print("");
        Terminal.print("Welcome to TGNU, the game now starts!");
        Terminal.print("You have broken into the fileserver of Area51, the files are mounted in the folder '/mnt/mainframe/'");
        Terminal.print("Your task is to seek out and copy classified data about aliens to your local harddrive");
        Terminal.print("Put the collected data in your home folder (/home/"+username+"/)");
        Terminal.print("Type 'help' for more info about the commands you can use.");
        Terminal.print("");
        
        // this boolean stays false as long as the user does not type 'exit'
        boolean exit = false;
        while(!exit)
        {
            //looks strange but getInput returns false when exit is recieved and true when tekst is recieved (see getInput documentation)
            exit = Terminal.getInput();
        }
        
    }
    
    /**
     * Play a cinematic where the user sees itself hacking the Area51 mainframe.
     */
    public static void hackCinematic()
    {
        String prompt = Terminal.getPrompt();
        Terminal.printInline(prompt);
        Terminal.printAsTyped("ssh serv1425.area51.gov");
        Terminal.print("Welcome to the Area51 fileserver");
        GameController.sleep(1000);
        Terminal.print("Please enter username and password");
        Terminal.printInline("username: ");
        GameController.sleep(1000);
        Terminal.printAsTyped("root");
        GameController.sleep(1000);
        Terminal.printInline("password: ");
        GameController.sleep(4000);
        Terminal.printAsTyped("Alien1");
        GameController.sleep(3000);
        Terminal.print("Welcome root you now have full system access.");
        GameController.sleep(2000);
        Terminal.printInline("root@serv1425# ");
        GameController.sleep(3000);
        Terminal.printAsTyped("exit");
        GameController.sleep(1000);
        Terminal.printInline(prompt);
        GameController.sleep(1000);
        Terminal.printAsTyped("sshfs root@serv1425.area51.gov:/ /mainframe");
        Terminal.printInline("password: ");
        GameController.sleep(800);
        Terminal.printAsTyped("Alien1");
        GameController.sleep(500);
    } 
    
    
    /**
     * Return the players username
     * 
     * @return  the players username
     */   
    public static String getUsername()
    {
        return username;
    }
    
     /**
     * sleep the program
     * used to simulate the feeling of the mainframe/computer processing the input
     * 
     * @param   int the time to sleep in miliseconds.
     */      
    public static void sleep(int sleepTime) 
    {
        try {
            Thread.sleep(sleepTime);
        }
        catch(Exception e) {
             System.out.println("Fatal error in the game: "+e);
        }
    }

    /**
     * Will print the game over message.
     */
    public static void gameOver()
    {
        Terminal.print("You have been detected by the security scanner...");
        Terminal.print("the authorities have been notified of you violation");
        Terminal.print("Game Over!");
        sleep(2000);
        System.exit(1);
    }
    
    /**
     * Checks if the player has the correct files collected.If so he the check will return true
     * 
     * @return  returns true if the player has collected the correct set of items. 
     */
    public static void checkVictory()
    {
        ArrayList<File> list = Filesystem.getUserdirectory().getFiles();
        int number = 0;
        
        for(String naam : goal)
        {
            if(list.contains(Filesystem.findFileByName(naam)) == true)
            {
                number ++;
            }
        }
        
        if(goal.size() == number)
        {
            wonCinematic();
        }
    }

    /**
     * Creates the array with the files which should be collected.
     */
    public static void initGoal()
    {
        goal = new ArrayList<String>();       
        goal.add("aliendb.sql");
        goal.add("ufo-recovery.jpg");
        goal.add("al-corpse.jpg");
        goal.add("unidentified-alien.jpg");
        goal.add("ufo-clues.ppt");
        goal.add("description.txt");
        goal.add("200912Pacific.rtf");
        goal.add("200922Belgium.php");
        goal.add("2009EasterIsland.txt");
        goal.add("201002Vlissingen.txt");
        goal.add("alien1.jpg");
    }
    
    /**
     * The cinematic that will display the message when you've won the game.
     */
    private static void wonCinematic()
    {
        Terminal.print("  ####   ####  #    #  ####  #####    ##   ##### #    # #        ##   ##### #  ####  #    #  ####\n   #    ##    # ##   # #    # #    #  #  #    #   #    # #       #  #    #   # #    # ##   # #\n       #      #    # # #  # #     #    # #    #   #   #    # #      #    #   #   # #    # # #  #  ####\n   #      #    # #  # # #  ### #####  ######   #   #    # #      ######   #   # #    # #  # #      #\n  #    # #    # #   ## #    # #   #  #    #   #   #    # #      #    #   #   # #    # #   ## #    #\n   ####   ####  #    #  ####  #    # #    #   #    ####  ###### #    #   #   #  ####  #    # ####\n\n");
        Terminal.print("Congratulations! you have proven to be a true h4x0r!");

        Terminal.printAsTyped("The files you have collected have been sent to the local newspaper");
        Terminal.printAsTyped("Soon the whole world will know about the secrets of alien life");
        Terminal.print("Credits:");
        sleep(1000);
        Terminal.printAsTyped("TGNU version 1.0");
        Terminal.printAsTyped("Authors:");
        Terminal.printAsTyped("Jaimy Casteleijn");
        Terminal.printAsTyped("Patrick Brand");
        Terminal.printAsTyped("Jurgen Franse");
        Terminal.print("A word from our sponsors:");  
        sleep(1000);
        Terminal.printAsTyped("Do you want to buy cheap Viagra? We are an official viagra store!");
        Terminal.printAsTyped("Programming @ your service: low coupling high cohesion.");
        Terminal.printAsTyped("Maak van elke dag een leermomentje met BICT"); 
        Terminal.printAsTyped("Join now and get an €1000 welcome bonus, just thing 'whatever' and do it!");
        Terminal.printAsTyped("Low risk high profit online poker http://wouterpoker.nl");
        Terminal.printAsTyped("Gewoon...Omdat het kan!");
        Terminal.printAsTyped("The game will now terminate.................");
        System.exit(1);      
    }
}