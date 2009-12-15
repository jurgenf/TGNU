import java.util.Scanner;
/**
 * This class implements a terminal from wich the program talks to the terminal.
 * 
 * @author Jurgen Franse <fran0060@hz.nl>
 * @version 0.1
 * */
public class Terminal
{

    private Scanner terminalReader;
    
    /**
     * Constructor for objects of class Terminal
     */
    public Terminal()
    {
        terminalReader = new Scanner(System.in);
    }

    /**
     * Print a line of data to the terminal
     * 
     * @param  text   the text to print to the terminal
     */
    public void print(String text)
    {
        System.out.println(text);
    }
    
    /**
     * Return the user input from the terminal as a ArrayList containing all words that where typed in the console.
     * 
     * @return  an ArrayList containing strings that where typed into the terminal
     */    
    public ArrayList<String> getInput() 
    {
        System.out.print("> ");                // print prompt
        String inputLine = reader.nextLine().trim().toLowerCase();

        String[] wordArray = inputLine.split(" ");  // split at spaces

        // add words from array into hashset 
        HashSet<String> words = new HashSet<String>();
        for(String word : wordArray) {
            words.add(word);
        }
        return words;
    }
}
