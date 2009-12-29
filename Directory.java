import java.util.ArrayList;

/**
 * An object of the class Directory represents a directory of the filesystem.
 * 
 * @author Patrick Brand
 * @version v0.1
 */
public class Directory
{
    private String name;
    private String password;
    private ArrayList<Directory> childs;
    private Directory parent;

    /**
     * The constructor creates an object of the class Directory.
     * It requires a String name and a String password.
     * 
     * @param   String name         The name of the directory.
     * @param   String password     The password which is required to access this directory.
     * @param   Directory parent    The directories parent.
     */
    public Directory(String name, String password, Directory parent)
    {
        this.name = name;
        this.password = password;
        this.parent = parent;
        childs = new ArrayList<Directory>();
    }
    
    /**
     * The constructor creates an object of the class Directory.
     * It requires a String name and a String password.
     * 
     * @param   String name         The name of the directory.
     * @param   String password     The password which is required to access this directory.
     */
    public Directory(String name, Directory parent)
    {
        this.name = name;
        this.password = password;
        childs = new ArrayList<Directory>();
        this.parent = parent;
    }
    
    /**
     * The constructor creates an object of the class Directory.
     * It requires a String name.
     * 
     * @param String name       The name of the directory.
     */
    public Directory(String name)
    {
        this.name = name;
        childs = new ArrayList<Directory>();
    }
    
    /**
     * Get the name of this directory
     * 
     * @return  String name     The name of the directory.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Get the password of this directory
     * 
     * @return  String password     The password of this directory
     */
    public String getPassword()
    {
        return password;
    }
    
    /**
     * Add a directory object to the ArrayList childs
     * 
     * @param   Directory child     The instance of the class Directory which needs to be added to de ArrayList childs
     */
    public void addChild(Directory child)
    {
        childs.add(child);
    }
}
