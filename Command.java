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
        validCommands.put("ls", Commands.LIST);
        validCommands.put("rm", Commands.RM);
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
            if(words.size() == 2) { 
                showCommandHelp(words.get(1));
            }
            else
            {
                showAllCommands();
            }
        }
       else if (commands == Commands.COPY) {
          if(words.size() == 3) { 
              cp(words.get(1),words.get(2));
          }
          else {
            Terminal.print("Error: Insufficient parameters.");
            Terminal.print("For more information about the usage of this command type \"help cp\"");
          }
        }
        else if (commands == Commands.CD) {
            if(words.size() == 2){  
                cd(words.get(1));
            }else{
                Terminal.print("For more information about the usage of this command type \"help cd\"");
            }
        }
        else if (commands == Commands.CAT) {
           if(words.size() == 2){
               cat(words.get(1));
            }
            else{
                Terminal.print("For more information about the usage of this command type \"help cat\"");
            }
        }
        else if (commands == Commands.LIST) {
            if(words.size() == 1){
                ls();
            }
            else{
                Terminal.print("For more information about the usage of this command type \"help ls\"");
            }
        }
        else if (commands == Commands.RM) {
            if(words.size() == 2){
                rm(words.get(1));
            }
            else{
                Terminal.print("For more information about the usage of this command type \"help rm\"");
            }
        }
       else if (commands == Commands.QUIT) {
           wantToQuit = true;
        } 
       return wantToQuit;
    }
    
    /**
     * Print all valid commands to System.out.
     */
    public static void showAllCommands() 
    {
        for(String existingCommand : validCommands.keySet()) {
            Terminal.printInline(existingCommand + "  ");
        }
        Terminal.print("");
        Terminal.print("for more information about a command type help [command]");
    }
    
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
    
    public static void cd(String options) 
    {
            if(options.equals("roadhouse") == false && options.equals("..") == false)
            {
                Directory find = Filesystem.findDirectoryByName(options);
                if(find != null)
                {
<<<<<<< HEAD
                    if(find.getPassword() == null)
                    {
=======
                    Terminal.print("test");
                    //Terminal.print(Terminal.getPassPrompt());
                    Filesystem.setCurrentDirectory(find);
                }else{ 
                    Terminal.print("enter password:");
                    String input = Terminal.getRawUserInput();
                    String password = find.getPassword();
                    
                    if(input.equals(password)){
>>>>>>> b42c9efe30d7996ebb61aa178e88e95efd35f373
                        Filesystem.setCurrentDirectory(find);
                    }
                    else{ 
                        Terminal.printInline("Password: ");
                        String input = Terminal.getUserInput();
                        String password = find.getPassword();
                        
                        if(input.equals(password)){
                            Filesystem.setCurrentDirectory(find);
                        }
                        else{
                            Terminal.print("Sorry, try again");
                        }
                    }
                }
                else
                {
                    Terminal.print("Sorry no such file or directory");
                }
            }
             else if(options.equals("roadhouse") == true)
              {
                  GameController.gameOver();
              }
            
            else if(options.equals(".."))
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

    }
    
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
    
    public static void cp(String param1, String param2)
    {
        File searchResult = Filesystem.findFileByName(param1);
        if(searchResult != null) {
            if(param2.equals("/home/"+GameController.getUsername()) || param2.equals("/home/" + GameController.getUsername() + "/")) {
                if(Filesystem.fileExists(searchResult) != true)
                {
                    Filesystem.copyFile(searchResult);
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
    
    public static void rm(String options)
    {
        if(Filesystem.getCurrentDirectory().getName().equals(GameController.getUsername()))
        {
            boolean removed = false;
            for(File file : Filesystem.getCurrentFiles())
            {
                if(file.getName().equals(options))
                {
                    Filesystem.getCurrentFiles().remove(file);
                    removed = true;
                }
            }
            if(removed == true)
            {
                Terminal.print("File deleted");
            }
            else
            {
                Terminal.print("Error: The source file you specified can not be found.");
            }
        }
        else
        {
            Terminal.print("Error: You are not authorized to make changes in this directory");
        }
    }
}