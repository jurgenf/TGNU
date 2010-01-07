
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
    
    //private Shell shell;

    /**
     * Constructor for objects of class GameController
     */
    public GameController()
    {
        //initialize the instance variables
        terminal = new Terminal(this);
        // shell = new Shell();
        
        //output the start screen
        terminal.print("******************************************************");
        terminal.print("*   _______ _____ _   _ _    _                       *");
        terminal.print("*   |__   __/ ____| \\  | |  | |                      *");
        terminal.print("*     | | | |  __|  \\| | |  | |                      *");
        terminal.print("*     | | | | |_ | . ` | |  | |                      *");
        terminal.print("*     | | | |__| | |\\  | |__| |                      *");
        terminal.print("*     |_|  \\_____|_| \\_|\\____/                       *");
        terminal.print("*        This Game is Not Unix version 0.1           *");
        terminal.print("*****************************************************");
        terminal.print("");
        terminal.print("Please enter your username:");
        username = terminal.getUsername();
        this.initTheGame();
    }

    /**
     * Initialize the game!
     *
     */
    public void initTheGame()
    {
        this.createFileSystem();
        terminal.setPrompt(username+"@h4ckst4ti0n> ");
        
        this.hackCinematic();
        terminal.print("Welcome to TGNU, the game now starts!");
        terminal.print("You have broken into the fileserver of Area51, the files are mounted in the folder 'mainframe'");
        terminal.print("Your task is to seek out and copy classified data about aliens to your local harddrive");
        terminal.print("Put the collected data in your home folder (/home/"+username+"/)");
        terminal.print("Type 'help' for more info about the commands you can use.");
        terminal.getInput();
    }
    
    /**
     * Play a cinematic where the user sees itself hacking the Area51 mainframe
     *
     */
    public void hackCinematic()
    {
        String prompt = terminal.getPrompt();
        terminal.printInline(prompt);
        terminal.printAsTyped("ssh serv1425.area51.gov");
        terminal.print("Welcome to the Area51 fileserver");
        this.sleep(1000);
        terminal.print("Please enter username and password");
        terminal.printInline("username: ");
        this.sleep(1000);
        terminal.printAsTyped("root");
        this.sleep(1000);
        terminal.printInline("password: ");
        this.sleep(4000);
        terminal.printAsTyped("Alien1");
        this.sleep(3000);
        terminal.print("Welcome root you now have full system access.");
        this.sleep(2000);
        terminal.printInline("root@serv1425# ");
        this.sleep(3000);
        terminal.printAsTyped("exit");
        this.sleep(1000);
        terminal.printInline(prompt);
        this.sleep(1000);
        terminal.printAsTyped("sshfs root@serv1425.area51.gov:/ /mainframe");
        terminal.printInline("password: ");
        this.sleep(800);
        terminal.printAsTyped("Alien1");
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
    public void sleep(int sleepTime) 
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
        File ls = new File("ls", "", 94);
        
            //mainframeTmp
        File aliendb = new File("aliendb.sql","#\n# Database structure for database 'alien'\n#\n\nCREATE DATABASE /*!32312 IF NOT EXISTS*/ \"alien\" /*!40100 DEFAULT CHARACTER SET latin1 */;\n\nUSE \"alien\";\n\n\n#\n# Table structure for table 'administration'\n#\n\nCREATE TABLE /*!32312 IF NOT EXISTS*/ \"administration\" (\n  \"idAlien\" int(11) NOT NULL,\n  \"alienSpecie\" varchar(45) DEFAULT NULL,\n  \"picture\" varchar(45) DEFAULT NULL,\n  \"length\" int(11) DEFAULT NULL,\n  \"weight\" varchar(45) DEFAULT NULL,\n  PRIMARY KEY (\"idAlien\")\n);\n\n\n\n#\n# Dumping data for table 'administration'\n#\n\nLOCK TABLES \"administration\" WRITE;\n/*!40000 ALTER TABLE \"administration\" DISABLE KEYS;*/\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n	(0,'Vulcan','http://memory-alpha.org/en/wiki/Vulcan',179,'63');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n	(1,'Klingon','http://memory-alpha.org/en/wiki/Klingon',150,'100');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n	(2,'Romulan','http://memory-alpha.org/en/wiki/Romulan',90,'10');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n	(3,'Cardassien','http://memory-alpha.org/en/wiki/Cardassian',120,'40');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n	(4,'Ferengi','http://memory-alpha.org/en/wiki/Ferengi',50,'20');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n	(5,'Borg','http://memory-alpha.org/en/wiki/Borg',102,'16');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n	(6,'Bejoran','http://memory-alpha.org/en/wiki/Bajoran',393,'23');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n	(7,'Betazoid','http://memory-alpha.org/en/wiki/Betazoid',42,'89');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n	(8,'wookiee','http://musicselections.files.wordpress.com/20',200,'54');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n	(9,'umpa lumpa','http://sipr.net/oompa_loompa.jpg',120,'40');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n	(10,'tribble','http://www.product-reviews.net/wp-content/use',10,'3');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n	(11,'tril','http://memory-alpha.org/en/wiki/Trill',24,'3');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n	(12,'goa''uld',NULL,127,'30');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n	(13,'wraith','http://memory-alpha.org/en/wiki/Wraith',579,'440');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n	(14,'furling',NULL,376,'146');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n	(15,'jem''hadar',NULL,234,'78');\n/*!40000 ALTER TABLE \"administration\" ENABLE KEYS;*/\nUNLOCK TABLES;\n/*!40101 SET SQL_MODE=@OLD_SQL_MODE;*/\n/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;*/", 14);
        
        
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
        
    }
               
}
