import java.util.HashMap;
import java.util.ArrayList;

public class Command
{
    private static HashMap<String, Commands> validCommands;

    /**
     * Initialize the HashMap for the validcommands and
     * put the commands in the HashMap.
     */
    public static void initCommandList()
    {
        validCommands = new HashMap<String, Commands>();
        validCommands.put("help", Commands.HELP);
        validCommands.put("cp", Commands.COPY);
        validCommands.put("exit", Commands.QUIT);
        validCommands.put("cd", Commands.CD);
        validCommands.put("cat", Commands.CAT);
        validCommands.put("uptime", Commands.UPTIME);
        validCommands.put("ls", Commands.LIST);  
    }
    
    /**
     * Check whether a given String is a valid command word. 
     * @return true if it is, false if it isn't.
     */
    public static boolean isCommand(String aString)
    {
        return validCommands.containsKey(aString);
    }
    
     /**
     * Find the CommandWord associated with a command word.
     * @param commandWord The word to look up.
     * @return The CommandWord correspondng to commandWord, or UNKNOWN
     *         if it is not a valid command word.
     */
    public static Commands getCommand(String commandWord)
    {
        Commands command = validCommands.get(commandWord);
        if(command != null) {
            return command;
        }
        else {
            return Commands.UNKNOWN;
        }
    }

    /**
     * Processes the commands and the words which he receives
     * from the terminal and will look if the first word 
     * is a command, if so he will excute the method of that command,
     * if not he will say that it is a unknown command.
     * 
     * checks if the player wants to exit the game,
     * if not wantToQuit will be false and checks if the word
     * is another command. If the player types exit, wantToQuit
     * will be true and the game will stop.
     * 
     * @return      wantToQuit will return true if the players wants to exit.
     */
    public static boolean processCommand(ArrayList<String> words)
    {
        boolean wantToQuit = false;
        
        Commands commands = getCommand(words.get(0));       
        
        if(commands == Commands.UNKNOWN) {
            Terminal.print("Unknown Command.");
        }
        else if(commands == Commands.HELP) {
                printHelp();
        }
        else if (commands == Commands.COPY) {
              // printHelp();
        }
        else if (commands == Commands.CD) {
            if(words.size() != 1){  
                cd(words.get(1));
            }else{
                Terminal.print("You didn't give any parameters.");
            }
        }
        else if (commands == Commands.CAT) {
           //printHelp();
        }
        else if (commands == Commands.UPTIME) {
           //printHelp();
        }
        else if (commands == Commands.LIST) {
           // printHelp();
        }
       else if (commands == Commands.QUIT) {
           wantToQuit = true;
        } 
       return wantToQuit;
    }
    
    /**
     * Print all valid commands to System.out.
     */
    public static void showAll() 
    {
        for(String command : validCommands.keySet()) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }    
    
    /**
     * Method to show all the available commands.
     */
    public static void printHelp()
    {
        showAll();
    }
    
    public static void cd(String options) 
    {
        if(options == null)
        {
            Terminal.print("faal.");
        }
        else
        {
            Filesystem.getCurrentDirectory();
            Directory find = Filesystem.findDirectoryByName(options);
            if(find != null)
            {
                Filesystem.setCurrentDirectory(find);
            }
            else
            {
                Terminal.print("je foutmelding, bijv. Sorry deze directory bestaat niet");
            }
        }
    }
    
    public static void cp(String options) 
    {
        if(options == null)
        {
            Terminal.print("faal.");
        }
        else
        {
            Terminal.print("test");
        }
    }
    
}