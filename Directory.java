import java.util.ArrayList;
/**
 * An object of the class Directory represents a directory of the filesystem.
 * 
 * @author TGNU Team
 * @version 1.0
 */
public class Directory
{
    private String name;
    private String password;
    private ArrayList<Directory> childs;
    private ArrayList<File> files;
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
        files = new ArrayList<File>();
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
     * @param   String name       The name of the directory.
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
     * Get the ArrayList<File> files
     * 
     * @return  return the ArrayList<File> files
     */
    public ArrayList<File> getFiles()
    {
        return files;
    } 

    /**
     * Get the parent of this directory
     * 
     * @return  Directory parent    The parent directory
     */
    public Directory getParent()
    {
        return parent;
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
}