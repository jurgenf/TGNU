import java.util.HashMap;
/**
 * Write a description of class Command here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Command
{
    private HashMap<String, Commands> validCommands;

    /**
     * Constructor - initialise the command words.
     */
    public Command()
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
     * Find the CommandWord associated with a command word.
     * @param commandWord The word to look up.
     * @return The CommandWord correspondng to commandWord, or UNKNOWN
     *         if it is not a valid command word.
     */
    public Commands getCommand(String commandWord)
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
     * Check whether a given String is a valid command word. 
     * @return true if it is, false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        return validCommands.containsKey(aString);
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