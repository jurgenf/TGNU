
/**
 * This class is the main class for the program. From this class the game starts and all the other objects are initialized.
 * 
 * @author Jurgen Franse <fran0060@hz.nl>
 * @version 0.1
 */
public class GameController
{
    private Terminal terminal;
    //private Shell shell;

    /**
     * Constructor for objects of class GameController
     */
    public GameController()
    {
        //initialize the instance variables
        terminal = new Terminal();
       // shell = new Shell();
        
        //output the start screen
        terminal.print("******************************************************");
        terminal.print("*   _______ _____ _   _ _    _                       *");
        terminal.print("*   |__   __/ ____| \\  | |  | |                      *");
        terminal.print("*     | | | |  __|  \\| | |  | |                      *");
        terminal.print("*     | | | | |_ | . ` | |  | |                      *");
        terminal.print("*     | | | |__| | |\\  | |__| |                      *");
        terminal.print("*     |_|  \\_____|_| \\_|\\____/                      *");
        terminal.print("*        This Game is Not Unix version 0.1           *");
        terminal.print("*****************************************************");
        terminal.print("");
        terminal.print("");
        terminal.print("Please enter your username:");
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */

}
