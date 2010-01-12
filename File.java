
/**
 * An object of the class File represents a single file.
 * 
 * @author Patrick Brand 
 * @version v0.1
 */
public class File
{
    private String name;
    private String content;
    private int size;


    /**
     * Constructor for objects of class file
     * 
     * @param   String name     The name of the file
     * @param   String content  The content of the file
     * @param   int size        The size of the file
     */
    public File(String name, String content, int size)
    {
        this.name = name;
        this.size = size;
        this.content = content;
    }

    /**
     * Get the name of the file
     * 
     * @return  name    The name of the file
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Get the content of the file.
     * 
     * @return  content     The content of the file
     */
    public String getContent()
    {
        return content;
    }
    
    /**
     * Get the size of the file.
     * 
     * @return size     The size of the file
     */
    public int getSize()
    {
        return size;
    }
}
