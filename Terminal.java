import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 * This class implements a terminal from wich the program talks to the terminal.
 * 
 * @author Jurgen Franse <fran0060@hz.nl>
 * @version 0.2
 * */
public class Terminal
{

    private static Scanner terminalReader = new Scanner(System.in);
    private static String prompt = "> ";
    private static String passprompt = "password: ";

    
    /**
     * Print a line of text to the terminal
     * 
     * @param  text   the text to print to the terminal
     */
    public static void print(String text)
    {
        System.out.println(text);
    }
    
    /**
     * Print a line of tekst without printing a newline.
     * 
     * @param   text   the text to print to the terminal
     */    
    public static void printInline(String text)
    {
        System.out.print(text);
    }
    
    /**
     * Print a line of text to the terminal as it was typed (typewriter effect)
     * 
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
     * Return the username the user logs in with and return it
     * 
     * @return  the username the user choosed
     */    
    public static String askUsername() 
    {
        System.out.print(prompt);
        String username = terminalReader.nextLine().trim().toLowerCase();
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
     * 
     * 
     */
    public static String getPassPrompt()
    {
        return passprompt;
    }
    
    public static String getUserInput() 
    {
            //setPrompt(getPassPrompt());
            String inputLine = terminalReader.nextLine();
            return inputLine;
    }
    
    
    /**
     * Return the user input from the terminal as a ArrayList containing all words that where typed in the console.
     * 
     * @return  an ArrayList containing strings that where typed into the terminal
     */    
    public static boolean getInput() 
    {
        System.out.print(prompt);
        String inputLine = terminalReader.nextLine().trim().toLowerCase();

        String[] wordArray = inputLine.split(" ");

        ArrayList<String> words = new ArrayList<String>();
        for(String word : wordArray) {
            words.add(word);
        }
        // return the result of the processCommand method so the GameController can decide what to do next.
        return Command.processCommand(words);
    }
}