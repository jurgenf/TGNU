import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 * This class implements a terminal from wich the program talks to the terminal.
 * 
 * @author Jurgen Franse <fran0060@hz.nl>
 * @version 0.1
 * */
public class Terminal
{

    private Scanner terminalReader;
    private String prompt;
    private GameController theGame;
    private Command commands;
    private Shell shell;
    
    /**
     * Constructor for objects of class Terminal
     */
    public Terminal(GameController theGame)
    {
        terminalReader = new Scanner(System.in);
        commands = new Command();
        prompt = ">";
        this.theGame = theGame;
    
        shell = new Shell(null, null);
    }

    public Shell getCommand() 
    {
        String inputLine;   // will hold the full input line
        String word1 = null;
        String word2 = null;

        System.out.print(prompt);
       
        inputLine = terminalReader.nextLine();

        // Find up to two words on the line.
        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();      // get first word
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();      // get second word
                // note: we just ignore the rest of the input line.
            }
        }

        // Now check whether this word is known. If so, create a command
        // with it. If not, create a "null" command (for unknown command).
        return new Shell(commands.getCommand(word1), word2);
    }
    
    /**
     * Print a line of text to the terminal
     * 
     * @param  text   the text to print to the terminal
     */
    public void print(String text)
    {
        System.out.println(text);
    }
    
    /**
     * Print a line of tekst without printing a newline.
     * 
     * @param   text   the text to print to the terminal
     */    
    public void printInline(String text)
    {
        System.out.print(text);
    }
    
    /**
     * Print a line of text to the terminal as it was typed (typewriter effect)
     * 
     * @param  text   the text to print to the terminal
     */
    public void printAsTyped(String text)
    {
        char[] textArray = text.toCharArray();
        for(char character : textArray)
        {
            System.out.print(character);
            theGame.sleep(100);
        }
        System.out.print("\n");
    }

    /**
     * Return the username the user logs in with and return it
     * 
     * @return  the username the user choosed
     */    
    public String getUsername() 
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
    public void setPrompt(String prompt) 
    {
        this.prompt = prompt;
    }
    
    /**
     * Get the prompt (the tekst before the cursor where you are suppose to type)
     * This can be used in cinematics to fake a prompt
     * 
     * @return  the currently used prompt tekst
     */    
    public String getPrompt() 
    {
        return prompt;
    }
    
    
    /**
     * Return the user input from the terminal as a ArrayList containing all words that where typed in the console.
     * 
     * @return  an ArrayList containing strings that where typed into the terminal
     */    
    public ArrayList<String> getInput() 
    {
        System.out.print(prompt);
        String inputLine = terminalReader.nextLine().trim().toLowerCase();

        String[] wordArray = inputLine.split(" ");

        ArrayList<String> words = new ArrayList<String>();
        for(String word : wordArray) {
            words.add(word);
        }
        return words;
    }
    
    public void showCommands()
    {
        commands.showAll();
    }
}