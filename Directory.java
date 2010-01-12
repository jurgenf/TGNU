import java.util.ArrayList;
import java.util.HashMap;
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
    private ArrayList<File> files;
    private Directory parent;
    private HashMap<String, Directory> exits;

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
        files = new ArrayList<File>();
        exits = new HashMap<String, Directory>();
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
        files = new ArrayList<File>();
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
        files = new ArrayList<File>();
    }
    
    /**
     * get the ArrayList<Directory> childs
     * 
     * @return  return the ArrayList<Directory> childs
     */
    public ArrayList<Directory> getChilds()
    {
        return childs;
    }
    
    /**
     * Print the names of the childs
     */
     public void printChilds()
    {
        for(Directory dir : childs)
        {
            Terminal.print(dir.getName());
        }
    } 
    
    public void setExit(String direction, Directory neighbor)
    {
        exits.put(direction, neighbor);
    }
    
    public Directory getExit(String direction) 
    {
        return exits.get(direction);
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
     * Add a Directory object to the ArrayList childs
     * 
     * @param   Directory child     The instance of the class Directory which needs to be added to the ArrayList childs
     */
    public void addChild(Directory child)
    {
        childs.add(child);
    }
    
    /**
     * Add a File object to the ArrayList files
     * 
     * @param   File file   The instance of the class File which needs to be added to the ArrayList files
     */
    public void addFile(File file)
    {
        files.add(file);
    }
     
    /**
     * 
     */
    public void printFiles()
    {
        for(File file : files)
        {
            Terminal.print(file.getName());
        }
    }
}