import java.util.HashMap;
import java.util.ArrayList;

/**
 * A class that will processes all commands which are available
 * in TGNU.
 * 
 * @author TGNU Team
 * @version 1.0
 */
public class Command
{
    private static HashMap<String, CommandString> validCommands;

    /**
     * Initialize the HashMap for the validcommands and
     * put the commands in the HashMap.
     */
    public static void initCommandList()
    {
        validCommands = new HashMap<String, CommandString>();
        validCommands.put("help", CommandString.HELP);
        validCommands.put("cp", CommandString.COPY);
        validCommands.put("exit", CommandString.QUIT);
        validCommands.put("cd", CommandString.CD);
        validCommands.put("cat", CommandString.CAT);
        validCommands.put("ls", CommandString.LIST);
        validCommands.put("rm", CommandString.RM);
        validCommands.put("df", CommandString.DF);
    }
    
    /**
     * Check whether a given String is a valid command word. 
     * 
     * @return  true if it is, false if it isn't.
     * @param   String aString which could be a valid command word
     */
    public static boolean isCommand(String aString)
    {
        return validCommands.containsKey(aString);
    }
    
    /**
     * Find the CommandWord associated with a command word.
     * 
     * @param   commandWord The word to look up.
     * @return  The CommandWord correspondng to commandWord, 
     * or UNKNOWN if it is not a valid command word.           
     */
    public static CommandString getCommand(String commandWord)
    {
        CommandString command = validCommands.get(commandWord);
        if(command != null) {
            return command;
        }
        else {
            return CommandString.UNKNOWN;
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
     * @return  wantToQuit will return true if the players wants to exit.
     * @param   ArrayList<String> words, which are the words which the player typed.
     */
    public static boolean processCommand(ArrayList<String> words)
    {
        boolean wantToQuit = false;
        
        CommandString commands = getCommand(words.get(0));       
        
        if(commands == CommandString.UNKNOWN) {
            Terminal.print("Unknown Command.");
        }
        else if(commands == CommandString.HELP) {
            if(words.size() == 2) { 
                showCommandHelp(words.get(1));
            }
            else
            {
                showAllCommands();
            }
        }
       else if (commands == CommandString.COPY) {
          if(words.size() == 3) { 
              cp(words.get(1),words.get(2));
          }
          else {
            Terminal.print("Error: Insufficient parameters.");
            Terminal.print("For more information about the usage of this command type \"help cp\"");
          }
        }
        else if (commands == CommandString.CD) {
            if(words.size() == 2){  
                cd(words.get(1));
            }else{
                Terminal.print("For more information about the usage of this command type \"help cd\"");
            }
        }
        else if (commands == CommandString.CAT) {
           if(words.size() == 2){
               cat(words.get(1));
            }
            else{
                Terminal.print("For more information about the usage of this command type \"help cat\"");
            }
        }
        else if (commands == CommandString.LIST) {
            if(words.size() == 1){
                ls();
            }
            else{
                Terminal.print("For more information about the usage of this command type \"help ls\"");
            }
        }
        else if (commands == CommandString.RM) {
            if(words.size() == 2){
                rm(words.get(1));
            }
            else{
                Terminal.print("For more information about the usage of this command type \"help rm\"");
            }
        }
        else if (commands == CommandString.DF) {
            if(words.size() == 1){
                df();
            }
        }
       else if (commands == CommandString.QUIT) {
           wantToQuit = true;
        } 
       return wantToQuit;
    }
    
    /**
     * Print all valid commands to the Terminal
     */
    public static void showAllCommands() 
    {
        for(String existingCommand : validCommands.keySet()) {
            Terminal.printInline(existingCommand + "  ");
        }
        Terminal.print("");
        Terminal.print("for more information about a command type help [command]");
    }
    
    /**
     * Method to print the description and the use of the specific command word.
     * 
     * @param   String command, command is the word which should be a command word to get the correct message for a command.
     */    
    public static void showCommandHelp(String command)
    {
        //check trough all available help messages to find the one the user wants more information abou
        if(command.equals("help")) Terminal.print("There is no help about help because this would destroy the earth, just use help without a parameter");
        else if(command.equals("cp")) Terminal.print("WRITE THIS!!!");
        else if(command.equals("cd")) Terminal.print("WRITE THIS!!!");
        else if(command.equals("cat")) Terminal.print("WRITE THIS!!!");
        else if(command.equals("ls")) Terminal.print("WRITE THIS!!!");
        else if(command.equals("exit")) Terminal.print("This command exits the game/shell.");
        else Terminal.print("Sorry, there is no help topic found for the that command.");
    }
    
    /**
     * Method which processes the command "cd".
     * Checks wether if the user gives any parameters to cd or
     * if there is a password on a directory. 
     * 
     * cd command also checks if there is a directory which
     * the user types after the cd command.
     * 
     * @param   String options, the second word of the ArrayList<String> words which should be a directory.
     */    
    public static void cd(String options) 
    {               
        if(options.equals("..") == true)
        {
             if(Filesystem.getCurrentDirectory().getParent() != null)
             {
                 Filesystem.setCurrentDirectory(Filesystem.getCurrentDirectory().getParent());
             }
             else
             {
                 Terminal.print("You are already at root");
             }
         }
         
        else if(options.equals("/"))
        {
            Filesystem.setCurrentDirectory(Filesystem.getRoot());
        }
            
        else
        {
            Directory found = Filesystem.findDirectoryByName(options);
            if(found != null)
            {                
                if(options.equals("roadhouse") || options.equals("Dont_look") || options.equals("important"))
                {
                        GameController.gameOver();
                }
                else if(found.getPassword() == null)
                {
                    Filesystem.setCurrentDirectory(found);
                }
                else{ 
                    Terminal.printInline("Password: ");
                    String input = Terminal.getRawUserInput();
                    String password = found.getPassword();
                       
                    if(input.equals(password)){
                        Filesystem.setCurrentDirectory(found);
                    }
                    else
                    {
                        Terminal.print("Sorry, try again");
                    }
                }
            }                
            else
            {
                Terminal.print("Sorry no such file or directory");
            }
        }     
    }
    
    /**
     *  Method that processes the ls command.
     *  
     *  The command whill get all the directory´s and files 
     *  of the currentDirectory. He will display for the directory´s
     *  that is it actually a directory ([dir]) and for files he will print
     *  that it are files with a file sizes ([file] && "kb")
     */    
    public static void ls() 
    {
        for(Directory dir : Filesystem.getCurrentChilds())
        {
            Terminal.print("[dir]     " + dir.getName());
        }
        for(File file : Filesystem.getCurrentFiles())
        {
            Terminal.print("[file]    " + file.getName() + "    " + file.getSize() + " kb");
        }
    }
    
    /**
     * command that will excute the copy command.
     * 
     * It checks if he copies too the right folder,
     * if so he will copy the file, if not he will print the 
     * second error message that the required persmissions are not ok.
     * 
     * If the file already exists in the home folder it will say that the file
     * is already in the home folder. If the file cannot be found it wil say that
     * he can't find the file.
     * 
     * @param   String param1 is the file which is going to be copied
     * @param   String param2 is the directory where the file is going to be copied too.
     */    
    public static void cp(String param1, String param2)
    {
        File searchResult = Filesystem.findFileByName(param1);
        if(searchResult != null) {
            if(param2.equals("/home/"+GameController.getUsername()) || param2.equals("/home/" + GameController.getUsername() + "/")) {
                if(Filesystem.fileExists(searchResult) != true)
                {
                    if(Filesystem.getUsedDiskspace() + searchResult.getSize() <= Filesystem.getDiskSize())
                    {
                        Filesystem.copyFile(searchResult);
                        Filesystem.updateDiskspace();
                        GameController.checkVictory();
                    }
                    else
                    {
                        Terminal.print("Error: insufficient diskspace");
                    }
                }
                else
                {
                    Terminal.print("Error: File already exists in the directory /home/" + GameController.getUsername());
                }
            }
            else {
                Terminal.print("Error: You don't have the required permissions to copy the file " + param1 + " to the folder " + param2);     
             }
        }
        else {
            Terminal.print("Error: The source file you specified can not be found.");
        }  
    }

    /**
     * the cat command will show the content of the file.
     * 
     * If there is no content than it will say that
     * he can't view the content of it.
     * Or the file which the user types doesn't exists.
     * 
     * @param   String options, the second word of the ArrayList<String> words which should be a file.
     */
    public static void cat(String options)
    {
        File searchResult = Filesystem.findFileByName(options);
        if(searchResult != null) {
            if(searchResult.getContent() != null){
                Terminal.print(searchResult.getContent());
            }
            else{
                Terminal.print("Sorry: cat can not view this content-type");
            }
        }
        else{
            Terminal.print("Error: The source file you specified can not be found.");
        }
    }

    /**
     * Processes the rm command.
     * Checks if the user that is trying to use the rm command
     * is in it's home directory (/home/<username>). If so
     * it will display the files which the player has copied to his folder and can
     * if he wants to, remove the files which are unnecessary.
     * 
     * Gives error if the user tries to delete a file which doesn't exsists in
     * his home folder. 
     * 
     * If the user isn't in his home folder and tries to delete a file or directory,
     * it will give an error that he is not authorized to delete files or directory's.
     * 
     * @param   String options, the second word of the ArrayList<String> words which should be a file.
     */
    public static void rm(String options)
    {
            File file = Filesystem.findFileByName(options);
            boolean message = false;
            if(file != null)
            {
                if(Filesystem.getCurrentDirectory().getName().equals(GameController.getUsername()))
                {
                     Filesystem.removeFile(file);
                     Filesystem.updateDiskspace();
                     Terminal.print("File deleted");
                }
                else
                {
                    Terminal.print("Error: You are not authorized to make changes in this directory");
                    message = true;
                }
            }        
            else if(message == false)
            {
                Terminal.print("Error: The source file you specified can not be found.");
            }
    }
    
    public static void df()
    {
        Terminal.print("Filesystem              used               available");
        Terminal.print("/                       300 gb              500 gb");
        Terminal.print("/home                   " + Filesystem.getUsedDiskspace() + " kb              " + Filesystem.getDiskSize() + " kb");
        Terminal.print("/mnt/mainframe          300 gb              10000 gb");
    }
}