/**
 * Write a description of class Shell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shell
{
    private Commands commandWord; 
    private String secondWord;
    private Command command;
    private Terminal terminal;
    private Directory filesystem;
    
    /**
     * Create a shell object. The command and the parameter must be supplied,
     * but both or one of them can be null.
     * 
     * @param   command represents the input command of the player.
     * @param   parameter represents the directory or the parameter of the command.
     */
    public Shell(Commands commandWord, String secondWord)
    {
        this.commandWord = commandWord;
        this.secondWord = secondWord;
        command = new Command();
    }
    /**
     * Return the command word, the first word, of this command.
     * If the command is Unkown the result will be null
     * @return      The command word.
     */
    public Commands getCommand()
    {
        return commandWord;
    }
    
    /**
     * Return the secondWord of the command, returns null if there is no second word.
     * @return      The second word of the command, returns null if there is no second word.
     */
    public String getSecondWord()
    {
        return secondWord;
    }
     
    public boolean isUnknown()
    {
        return (commandWord == Commands.UNKNOWN);
    }
    
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
    
    public void printHelp()
    {
        command.showAll();
    }
    
    public boolean exit(Shell command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
