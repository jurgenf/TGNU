
/**
 * This class is the main class for the program. From this class the game starts and all the other objects are initialized.
 * This class also holds some basic methods like the getUsername method.
 * 
 * @author TGNU team
 * @version 0.1
 */
public class GameController
{
    private static String username;
    
    /**
     * the main method starts the game by printing the welcome tekst and call the initialize method.
     * @param args arguments that where passed from the command
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
        GameController.hackCinematic();
        
        //create the filesystem
        Filesystem.createFilesystem();
        
        //load in the commands that can be used.
        Command.initCommandList();
        
        //print the welcome message
        Terminal.print("Welcome to TGNU, the game now starts!");
        Terminal.print("You have broken into the fileserver of Area51, the files are mounted in the folder '/mnt/mainframe/'");
        Terminal.print("Your task is to seek out and copy classified data about aliens to your local harddrive");
        Terminal.print("Put the collected data in your home folder (/home/"+username+"/)");
        Terminal.print("Type 'help' for more info about the commands you can use.");
        
        // this boolean stays false as long as the user does not type 'exit'
        boolean exit = false;
        while(!exit)
        {
            //looks strange but getInput returns false when exit is recieved and true when tekst is recieved (see getInput documentation)
            exit = Terminal.getInput();
        }
        
    }
    
    /**
     * Play a cinematic where the user sees itself hacking the Area51 mainframe
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
     * @return the players username
     */    
    public static String getUsername()
    {
        return username;
    }
    
     /**
     * sleep the program
     * used to simulate the feeling of the mainframe/computer processing the input
     * 
     * @param   int the time to sleep in miliseconds
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

    public static void gameOver()
    {
        Terminal.print("|¯¯¯¯\\   /¯¯¯¯¯\\     /¯¯¯¯¯| |¯¯¯¯\\°' |¯¯¯|¯¯¯|  /¯¯¯¯¯\\ |'¯¯|¯¯'|°/¯¯¯¯¯/ '  /¯x¯¯\\ ");
        Terminal.print("|   x  <|'|     x    |'  /     !     | |  x     \\ |           |°|     x    |'|         | \\ __¯¯¯\' |   (\\__/|");
        Terminal.print("|__|\\__\\ \\_____/ /___/¯|__'| |_____/ |___|___|  \\_____/  \\____/ '/______/| \\____\\ ");
        Terminal.print("");
        Terminal.print("----------------------------------------------------------------------------------------------------------------");
        Terminal.print("");
        Terminal.print(" /¯¯¯¯¯\\'     /¯¯¯¯¯| |¯¯¯\\/¯¯¯|  /¯x¯¯\\           /¯¯¯¯¯\\ \\¯¯¯\\    /¯¯¯/' /¯x¯¯\\ |¯¯¯¯\\  ");
        Terminal.print("|   (/¯¯¯\\°  /     !     | |            '| |   (\\__/|         |     x    |'  \\     \\/      /  |   (\\__/||   x  <|'");
        Terminal.print(" \\_____/' /___/¯|__'| |.__|\\/|__.|  \\____\\           \\_____/     \\_____/ _'  \\____\\ |__|\\__\\");
        System.exit(1);
    }
}