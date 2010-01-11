
/**
 * This class is the main class for the program. From this class the game starts and all the other objects are initialized.
 * 
 * @author Jurgen Franse <fran0060@hz.nl>
 * @version 0.1
 */
public class GameController
{
    private Terminal terminal;
    private String username;
    private Directory filesystem;
    private Directory currentDir;
    /**
     * Constructor for objects of class GameController
     */
    public GameController()
    {
        
        //output the start screen
        Terminal.print("******************************************************");
        Terminal.print("*   _______ _____ _   _ _    _                       *");
        Terminal.print("*   |__   __/ ____| \\  | |  | |                      *");
        Terminal.print("*     | | | |  __|  \\| | |  | |                      *");
        Terminal.print("*     | | | | |_ | . ` | |  | |                      *");
        Terminal.print("*     | | | |__| | |\\  | |__| |                      *");
        Terminal.print("*     |_|  \\_____|_| \\_|\\____/                       *");
        Terminal.print("*        This Game is Not Unix version 0.1           *");
        Terminal.print("*****************************************************");
        Terminal.print("");
        Terminal.print("Please enter your username: ");
        username = Terminal.askUsername();
        this.initTheGame();
    }

    /**
     * Initialize the game!
     *
     */
    public void initTheGame()
    {
        this.createFileSystem();
        Terminal.setPrompt(username+"@h4ckst4ti0n> ");
        // !!!! DO NOT SWITCH TO ACTIVATE THIS IN FINAL !!!!
        //Terminal.print("!!! hacking scene skipped, please activate this in final !!!");
        this.hackCinematic();
        
        Terminal.print("Welcome to TGNU, the game now starts!");
        Terminal.print("You have broken into the fileserver of Area51, the files are mounted in the folder 'mainframe'");
        Terminal.print("Your task is to seek out and copy classified data about aliens to your local harddrive");
        Terminal.print("Put the collected data in your home folder (/home/"+username+"/)");
        Terminal.print("Type 'help' for more info about the commands you can use.");
       
        //load in the commands that can be used.
        Command.initCommandList();
        
        // this boolean stays false as long as the user doen not type 'exit'
        boolean exit = false;
        while(!exit)
        {
            //looks strange but getInput returns false when exit is recieved and true when tekst is recieved (see getInput documentation)
            exit = Terminal.getInput();
        }
        
    }
    
    /**
     * Play a cinematic where the user sees itself hacking the Area51 mainframe
     *
     */
    public void hackCinematic()
    {
        String prompt = Terminal.getPrompt();
        Terminal.printInline(prompt);
        Terminal.printAsTyped("ssh serv1425.area51.gov");
        Terminal.print("Welcome to the Area51 fileserver");
        this.sleep(1000);
        Terminal.print("Please enter username and password");
        Terminal.printInline("username: ");
        this.sleep(1000);
        Terminal.printAsTyped("root");
        this.sleep(1000);
        Terminal.printInline("password: ");
        this.sleep(4000);
        Terminal.printAsTyped("Alien1");
        this.sleep(3000);
        Terminal.print("Welcome root you now have full system access.");
        this.sleep(2000);
        Terminal.printInline("root@serv1425# ");
        this.sleep(3000);
        Terminal.printAsTyped("exit");
        this.sleep(1000);
        Terminal.printInline(prompt);
        this.sleep(1000);
        Terminal.printAsTyped("sshfs root@serv1425.area51.gov:/ /mainframe");
        Terminal.printInline("password: ");
        this.sleep(800);
        Terminal.printAsTyped("Alien1");
        this.sleep(500);
    } 
    
    
    /**
     * Return the players username
     *
     * @return  the players username 
     */
    public String getUsername()
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
  
        
    
    /**
     * Creates the filesystem
     */
    public void createFileSystem()
    {
        //The Files
            //mainframeEtc
        File passwords = new File("passwords", "user:thomas \npassword:1337 \nuser:et \npassword:Go Home \nuser:earl \npassword:My Name= \nuser:henry \npassword:Frankenstein", 10);
        File shadow = new File("shadow", "6zI18EUZW4watEJ15NEmk0GpQjrAJU5h5BVWPMxwnPdjtdQdqhpRf7bWQo+4TcB2XkRKYL1q+hYZkDaLSi4+BltcmIYeWq0Y9ByNU7LPJsF11vkfGp8LoSaKBMwWG23DJNKk/tVH2Lu9R/Z60HhdhbbWQo+4TcB2CNLlRpNkZ8tMaPesK9xEog==", 50);
        File profile = new File("profile", "", 1);
        File networks = new File("networks", "", 1);
        File modules = new File("modules", "", 1);
        File host = new File("host.conf", "", 1);
        File services = new File("sevices", "", 18);
        
            //mainframeBin
        File bash = new File("bash", "", 712);
        File cat = new File("cat", "", 30);
        File cp = new File("cp", "", 74);
        File dir = new File("dir", "", 94);
        File ls = new File("ls", "", 94);
        
            //mainframeTmp

        //tmp file maken met sql query voor alien. voorbeeld: File("aliendb_backup_19082009.sql","CREATE alien....",2000)
        //MySQL workbench
        
         //The Directories
        filesystem = new Directory("/");
        Directory home = new Directory("home", filesystem);
        Directory userdir = new Directory(getUsername(), home);
        
        Directory mainframe = new Directory("mainframe", filesystem);
        
        Directory mainframeEtc = new Directory("etc", mainframe);
        Directory mainframeBin = new Directory("bin", mainframe);
        Directory mainframeHome = new Directory("home", mainframe);
        Directory mainframeTmp = new Directory("tmp", mainframe);
        Directory mainframeVar = new Directory("var", mainframe);
        
        Directory earl = new Directory("earl", "My Name=", mainframeHome);
        Directory thomas = new Directory("thomas", "1337", mainframeHome);
        Directory et = new Directory("et", "Go Home", mainframeHome);
        Directory henry = new Directory("henry", "Frankenstein", mainframeHome);
        
        Directory www = new Directory("www", mainframeVar);
        
        
        home.addChild(userdir);
        
        filesystem.addChild(home);
        filesystem.addChild(mainframe);
        
        mainframe.addChild(mainframeEtc);
        mainframe.addChild(mainframeHome);
        mainframe.addChild(mainframeBin);
        mainframe.addChild(mainframeTmp);
        mainframe.addChild(mainframeVar);
        
        mainframeHome.addChild(earl);
        mainframeHome.addChild(thomas);
        mainframeHome.addChild(et);
        mainframeHome.addChild(henry);   
        
        mainframeVar.addChild(www);
        
        //Set exits for all maps
       // filesystem.setExit("mainframe", mainframe);
       // filesystem.setExit("home", mainframeHome);
            
        currentDir = mainframeHome;
    }
   

}