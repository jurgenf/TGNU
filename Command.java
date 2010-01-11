import java.util.HashMap;
import java.util.ArrayList;

public class Command
{


    private static HashMap<String, Commands> validCommands;

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

    
    public static boolean processCommand(ArrayList<String> words)
    {
        boolean wantToQuit = false;
        
        Commands commands = getCommand(words.get(0));       
        
        if(commands == Commands.UNKNOWN) {
            Terminal.print("Unknown Command.");
        }
        else if(commands == Commands.HELP) {
               //printHelp();
        }
        else if (commands == Commands.COPY) {
              // printHelp();
        }
        else if (commands == Commands.CD) {
                //goMap(command);
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
    public void showAll() 
    {
        for(String command : validCommands.keySet()) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }    

}