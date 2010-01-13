import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 * This class implements the terminal the user works in
 * This class will communicate with the real terminal from the user (the windows cmd or the linux terminal emulator for example)
 * 
 * @author TGNU team
 * @version 1.0
 * */
public class Terminal
{
    //initialize the class variables and assign there default value
    private static Scanner terminalReader = new Scanner(System.in);
    private static String prompt = "> ";

    
    /**
     * Print a line of text to the terminal
     * @param  text   the text to print to the terminal
     */
    public static void print(String text)
    {
        System.out.println(text);
    }
    
    /**
     * Print a line of text without printing a newline.
     * @param   text   the text to print to the terminal
     */    
    public static void printInline(String text)
    {
        System.out.print(text);
    }
    
    /**
     * Print a line of text to the terminal as it was typed (typewriter effect)
     * @param  text   the text to print to the terminal
     */
    public static void printAsTyped(String text)
    {
        char[] textArray = text.toCharArray();
        for(char character : textArray)
        {
            System.out.print(character);
            GameController.sleep(100);
        }
        System.out.print("\n");
    }

    /**
     * Ask the user to fill in a username, clean it up and return it.
     * @return  the username the user choosed
     */    
    public static String askUsername() 
    {
        Terminal.printInline(prompt);
        String username = terminalReader.nextLine().trim().toLowerCase().replace(' ','-');
        return username;
    }  
    
    /**
     * Set the prompt (the tekst before the cursor where you are suppose to type) to the given tekst
     * 
     * @param  prompt the new prompt tekst to use
     */    
    public static void setPrompt(String newPrompt) 
    {
        prompt = newPrompt;
    }
    
    /**
     * Get the prompt (the tekst before the cursor where you are suppose to type)
     * This can be used in cinematics to fake a prompt
     * 
     * @return  the currently used prompt tekst
     */    
    public static String getPrompt() 
    {
        return prompt;
    }
   
    /**
     * Get the text the user has typed in the terminal and return it.
     * @return  a String containing the text the user has typed.
     */
    public static String getRawUserInput() 
    {
            String inputLine = terminalReader.nextLine();
            return inputLine;
    }
    
    
    /**
     * Get the user input and process it so the processCommand method can interpret the command and the arguments.
     * @return  an ArrayList containing strings that where typed into the terminal
     */    
    public static boolean getInput() 
    {
        System.out.print(prompt);
        String inputLine = Terminal.getRawUserInput();

        String[] wordArray = inputLine.split(" ");

        ArrayList<String> words = new ArrayList<String>();
        for(String word : wordArray) {
            words.add(word);
        }
        // return the result of the processCommand method so the GameController can decide what to do next.
        return Command.processCommand(words);
    }
}