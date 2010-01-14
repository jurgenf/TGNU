import java.util.ArrayList;
/**
 * This class makes it possible to create a filesystem by making directories and files 
 * and link them together
 * 
 * @author TGNU Team 
 * @version 1.0
 */
public class Filesystem
{
    private static Directory root = new Directory("/");
    private static Directory userdir;
    //Set the default Directory to root   
    private static Directory currentDirectory = root;
    
    private static final int space = 10000;
    private static int spaceUsed = 0;
           
    /**
     * Add the Child directories to their parents
     */
    public static void createFilesystem()
    {
        //De directories
        Directory home = new Directory("home", root);
        userdir = new Directory(GameController.getUsername(), home);
        Directory mnt = new Directory("mnt", root);

        Directory boot = new Directory("boot", "1203Q@)93204830943201sadfkj13", root);
        Directory bin = new Directory("bin", "1203Q@)93204830943201sadfkj13", root);
        Directory etc = new Directory("etc", "1203Q@)93204830943201sadfkj13", root);
        Directory var = new Directory("var", "1203Q@)93204830943201sadfkj13", root);
        Directory tmp = new Directory("tmp", "1203Q@)93204830943201sadfkj13", root);
        
        //De directories van de area51 server
        Directory mainframe = new Directory("mainframe", root);
        Directory mainframeEtc = new Directory("etc", mainframe);
        Directory acpi = new Directory("acpi", mainframeEtc);
        Directory init = new Directory("init.d", mainframeEtc);
        Directory grubEtc = new Directory("grub.d", mainframeEtc);
        Directory x11 = new Directory("X11", mainframeEtc);
        Directory mainframeBin = new Directory("bin", mainframe);
        Directory mainframeHome = new Directory("home", mainframe);
        Directory mainframeTmp = new Directory("tmp", mainframe);
        Directory mainframeVar = new Directory("var", mainframe);
        Directory mainframeMedia = new Directory("media", mainframe);
        Directory mainframeBoot = new Directory("boot", mainframe);
        Directory grub = new Directory("grub", mainframeBoot);
        Directory cdrom = new Directory("cdrom", mainframeMedia);
        Directory cdrom0 = new Directory("cdrom0", mainframeMedia);
        Directory mainframeRoot = new Directory("root", mainframeHome);
        Directory earl = new Directory("earl", "My Name=", mainframeHome);
        Directory thomas = new Directory("thomas", "1337", mainframeHome);
        Directory et = new Directory("et", "Go Home", mainframeHome);
        Directory henry = new Directory("henry", "Frankenstein", mainframeHome);    
        Directory alien1 = new Directory("noalien4u", "Frankenstein", henry);
        Directory alien2 = new Directory("documents", "My Name=", earl);
        Directory alien3 = new Directory("phone", et);
        Directory roadhouse = new Directory("roadhouse", alien3);
        Directory fake1 = new Directory("schedule", henry);
        Directory fake2 = new Directory("alienate", et);
        Directory fake3 = new Directory("work", thomas);
        Directory research1 = new Directory("research", henry);
        Directory research2 = new Directory("research", earl);
        Directory research3 = new Directory("research", et);
        Directory research4 = new Directory("research", thomas);
        Directory website = new Directory("website", mainframeRoot);
        Directory www = website;
        Directory databaseVar = new Directory("database", mainframeVar);
        Directory databaseTmp = databaseVar;
        Directory here = new Directory("Dont_look", mainframeTmp);
        Directory important = new Directory("import", mainframeMedia);
        
        //addChilds
        root.addChild(home);
        home.addChild(userdir);        
        root.addChild(mnt);
        root.addChild(boot);
        root.addChild(bin);
        root.addChild(etc);
        root.addChild(var);
        root.addChild(tmp);
        mnt.addChild(mainframe);
        mainframe.addChild(mainframeEtc);
        mainframe.addChild(mainframeHome);
        mainframe.addChild(mainframeBin);
        mainframe.addChild(mainframeTmp);
        mainframe.addChild(mainframeVar);
        mainframe.addChild(mainframeMedia);
        mainframe.addChild(mainframeBoot);
        mainframeBoot.addChild(grub);
        mainframeMedia.addChild(cdrom);
        mainframeMedia.addChild(cdrom0);
        mainframeEtc.addChild(acpi);
        mainframeEtc.addChild(init);
        mainframeEtc.addChild(grubEtc);
        mainframeEtc.addChild(x11);
        mainframeVar.addChild(www);
        mainframeHome.addChild(earl);
        mainframeHome.addChild(thomas);
        mainframeHome.addChild(et);
        mainframeHome.addChild(henry);
        mainframeHome.addChild(mainframeRoot);
        mainframeTmp.addChild(databaseTmp);
        mainframeTmp.addChild(here);
        mainframeMedia.addChild(important);
        mainframeVar.addChild(databaseVar);
        henry.addChild(alien1);
        henry.addChild(research1);
        henry.addChild(fake1);
        earl.addChild(alien2);
        earl.addChild(research2);
        et.addChild(research3);
        et.addChild(alien3);
        et.addChild(fake2);
        thomas.addChild(research4);
        thomas.addChild(fake3);
        thomas.addChild(website);
        alien3.addChild(roadhouse);
        
        //The Files
        mainframeEtc.addFile(new File("passwords", "user:thomas \npassword:1337 \nuser:et \npassword:Go Home \nuser:earl \npassword:My Name= \nuser:henry \npassword:Frankenstein", 10));
        mainframeEtc.addFile(new File("shadow", "6zI18EUZW4watEJ15NEmk0GpQjrAJU5h5BVWPMxwnPdjtdQdqhpRf7bWQo+4TcB2XkRKYL1q+hYZkDaLSi4+BltcmIYeWq0Y9ByNU7LPJsF11vkfGp8LoSaKBMwWG23DJNKk/tVH2Lu9R/Z60HhdhbbWQo+4TcB2CNLlRpNkZ8tMaPesK9xEog==", 50));
        mainframeEtc.addFile(new File("networks", null, 1));
        mainframeEtc.addFile(new File("modules", null, 1));
        mainframeEtc.addFile(new File("host.conf", null, 1));
        mainframeEtc.addFile(new File("sevices", null, 18));
        mainframeEtc.addFile(new File("adduser.conf", null, 12));
        mainframeEtc.addFile(new File("inetd.conf", null, 24));
        mainframeEtc.addFile(new File("magic", null, 25));
        mainframeEtc.addFile(new File("profile", null, 21));
        mainframeEtc.addFile(new File("services", null, 96));
        
        mainframeBin.addFile(new File("bash", null, 712));
        mainframeBin.addFile(new File("cat", null, 30));
        mainframeBin.addFile(new File("cp", null, 74));
        mainframeBin.addFile(new File("ls", null, 94));
        mainframeBin.addFile(new File("rm", null, 38));
        
        
        databaseTmp.addFile(new File("aliendb.sql","#\n# Database structure for database 'alien'\n#\n\nCREATE DATABASE /*!32312 IF NOT EXISTS*/ \"alien\" /*!40100 DEFAULT CHARACTER SET latin1 */;\n\nUSE \"alien\";\n\n\n#\n# Table structure for table 'administration'\n#\n\nCREATE TABLE /*!32312 IF NOT EXISTS*/ \"administration\" (\n  \"idAlien\" int(11) NOT NULL,\n  \"alienSpecie\" varchar(45) DEFAULT NULL,\n  \"picture\" varchar(45) DEFAULT NULL,\n  \"length\" int(11) DEFAULT NULL,\n  \"weight\" varchar(45) DEFAULT NULL,\n  PRIMARY KEY (\"idAlien\")\n);\n\n\n\n#\n# Dumping data for table 'administration'\n#\n\nLOCK TABLES \"administration\" WRITE;\n/*!40000 ALTER TABLE \"administration\" DISABLE KEYS;*/\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n    (0,'Vulcan','http://memory-alpha.org/en/wiki/Vulcan',179,'63');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n   (1,'Klingon','http://memory-alpha.org/en/wiki/Klingon',150,'100');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n    (2,'Romulan','http://memory-alpha.org/en/wiki/Romulan',90,'10');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n  (3,'Cardassien','http://memory-alpha.org/en/wiki/Cardassian',120,'40');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n   (4,'Ferengi','http://memory-alpha.org/en/wiki/Ferengi',50,'20');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n  (5,'Borg','http://memory-alpha.org/en/wiki/Borg',102,'16');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n   (6,'Bejoran','http://memory-alpha.org/en/wiki/Bajoran',393,'23');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n (7,'Betazoid','http://memory-alpha.org/en/wiki/Betazoid',42,'89');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n    (8,'wookiee','http://musicselections.files.wordpress.com/20',200,'54');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n   (9,'umpa lumpa','http://sipr.net/oompa_loompa.jpg',120,'40');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n (10,'tribble','http://www.product-reviews.net/wp-content/use',10,'3');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n    (11,'tril','http://memory-alpha.org/en/wiki/Trill',24,'3');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n   (12,'goa''uld',NULL,127,'30');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n    (13,'wraith','http://memory-alpha.org/en/wiki/Wraith',579,'440');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n (14,'furling',NULL,376,'146');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n    (15,'jem''hadar',NULL,234,'78');\n/*!40000 ALTER TABLE \"administration\" ENABLE KEYS;*/\nUNLOCK TABLES;\n/*!40101 SET SQL_MODE=@OLD_SQL_MODE;*/\n/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;*/", 14));
        mainframeTmp.addFile(new File("socket", null, 25));
        mainframeTmp.addFile(new File("adjiw20123@12", null, 21));
        mainframeTmp.addFile(new File("linc-d72-sad23", null, 76));
        mainframeTmp.addFile(new File("asd-gpg-agent", null, 783));
        
        et.addFile(new File("jiskefet.avi", "Debiteuren Crediteuren", 700000));
        et.addFile(new File("alienarena", "Alien Arena 2009 is a free multiplayer online deathmatch game and a must-try for all shooter fans.", 518000));
        
        henry.addFile(new File("familyguy.avi", "|¯¯¯¯\\   /¯¯¯¯¯\\     /¯¯¯¯¯| |¯¯¯¯\\°' |¯¯¯|¯¯¯|  /¯¯¯¯¯\\|'¯¯|¯¯'|°/¯¯¯¯¯/ ' /¯x¯¯\\ \n|  x <|'|   x  |'  /   !   | |  x  \\  |       |°|x   |'|       | \\ __¯¯¯\' |  (\\_/|\n|__|\\__\\ \\_____/ /___/¯|__'||_____/  |___|___|  \\_____/   \\_____/ '/______/| \\____\\", 7020012));
        henry.addFile(new File("status.txt", "I am examining this interesting species at the moment. For some reason they seem attracted by electrical current. I will keep you up to date.", 123));
        
        fake1.addFile(new File("timetable.xls", null, 100));
        fake1.addFile(new File("appointments.ics", null, 40));
        fake1.addFile(new File("timetablebackup.xls", null, 100));
        fake1.addFile(new File("appointmentsbackup.ics", null, 40));
        fake1.addFile(new File("review09.xls", null, 1000));
        fake2.addFile(new File("flame.doc", null, 200));
        fake2.addFile(new File("george.doc", null,20));
        fake2.addFile(new File("holiday2009.ppt", null,40));
        fake2.addFile(new File("obama.txt","Obama denied our request for publishing our discoveries to the world.", 300));
        fake2.addFile(new File("bush.txt","Bush didn't seem very interested in our research.", 231));
        fake3.addFile(new File("cleaningschedule.xls", null,124));
        fake3.addFile(new File("juffrouwjannie.jpg", null,1247));
        fake3.addFile(new File("timetable.xls", null, 289));
        fake3.addFile(new File("appointments.ics", null, 40));
        fake3.addFile(new File("projects.xls", null, 5023));
        
        alien1.addFile(new File("ufo-recovery.jpg", null, 2617));
        alien1.addFile(new File("identify.jpg", null, 1737));
        alien1.addFile(new File("corpse.jpg", null, 1275));
        alien1.addFile(new File("beach.jpg", null, 1752));
        alien1.addFile(new File("air.jpg", null, 17263));
        alien1.addFile(new File("unidentified.jpg", null, 1923));
        
        alien2.addFile(new File("owwmommah.jpg", null,2718));
        alien2.addFile(new File("gramps.jpg", null, 7519));
        alien2.addFile(new File("stitch.jpg", null, 1723));
        alien2.addFile(new File("wecallhimhomer.jpg", null, 1725));
        alien2.addFile(new File("clues.jpg", null, 1234));
        alien2.addFile(new File("tracks.jpg", null, 7820));
        
        alien3.addFile(new File("ufo.jpg", null, 4191));
        alien3.addFile(new File("chacarron.mp3", null, 1873));
        alien3.addFile(new File("wookie.jpg", null ,1828));
        alien3.addFile(new File("beach1.jpg", null, 2823));
        alien3.addFile(new File("beach2.jpg", null, 7132));
        alien3.addFile(new File("beach-tracks.jpg", null, 1823));
        alien3.addFile(new File("squirrel.jpg", null, 1732));
        alien3.addFile(new File("checkinthebox.jpg", null, 3721));
        alien3.addFile(new File("itsover9000.jpg", null, 2712));
        alien3.addFile(new File("description.txt", "sex: male \nage: 128 years \nlimbs: 24 \neyes: 5 \nskincolor: Chartreuse green", 18));

        research1.addFile(new File("200912Pacific", "A UFO crahed into the sea, we are going to investigate with a submarine", 29));
        research1.addFile(new File("200911Area", "The coffee machine doesn't work anymore, how many scientist do you need to repair a coffee machine?", 201));
        research1.addFile(new File("200922Belgium", "We found a sign of alien life in Belgium", 21));
        research1.addFile(new File("200907Tasmania", "Strange lights had been seen there by the inhabitants, but after some investigation it seemed to be a swarm of fireflies", 28));
        research2.addFile(new File("201001California", "After digging a lot of holes, we didn't find anything.", 45));
        research2.addFile(new File("200912Area", "Server crash deleted our data. Technicians are trying to retreive our data.", 12));
        research3.addFile(new File("201001Vlissingen", "Strange winds and extremely low temperatures were measured at Vlissingen, we are gathering intel about the weatherconditions now, it might be caused by aliens", 42));
        research3.addFile(new File("200912Area", "Server crashdeleted our data. Technicians re trying to retreive our data.", 12));
        research4.addFile(new File("2009EasterIsland", "I'm posted at EasterIsland for a year, to investigate the unknown glowing piece of rock which landed there. I will post my results next week", 25));
        research4.addFile(new File("201001Vlissingen", "Strange entitys detected in offices in a local university", 27));
        
        acpi.addFile(new File("ejectbtn.sh", null, 20));
        acpi.addFile(new File("nextbtn.sh", null, 12));
        acpi.addFile(new File("hibernate.sh", null, 11));
        acpi.addFile(new File("sleep.sh", null, 13));
        acpi.addFile(new File("prepare.sh", null, 15));
        
        init.addFile(new File("acpid", null, 27));
        init.addFile(new File("cups", null, 17));
        init.addFile(new File("rc", null, 23));
        init.addFile(new File("rc.d", null, 29));
        init.addFile(new File("udev", null, 21));
        init.addFile(new File("halt", null, 34));
        init.addFile(new File("usplash", null, 57));
        
        grubEtc.addFile(new File("memtest86+", null, 13));
        
        x11.addFile(new File("xorg.conf", null, 25));
        x11.addFile(new File("Xsession", null, 12));
        x11.addFile(new File("X", null, 25));
        
        website.addFile(new File("index.php", null, 37));
        website.addFile(new File("menu.html", null, 23));
        website.addFile(new File("area.css", null, 14));
        website.addFile(new File("data.php", null, 137));
        website.addFile(new File("aliendata1.jpg", null, 1238));
        website.addFile(new File("aliendata2.jpg", null, 1273));
    }
    
    /**
     * Get the current opened directory
     * 
     * @return      return the current opened directory
     */
    public static Directory getCurrentDirectory()
    {
        return currentDirectory;
    }
    
    /**
     * Set the current opened directory
     * 
     * @param       Directory dir   The directory which should be opened.  
     */
    public static void setCurrentDirectory(Directory dir)
    {
        currentDirectory = dir;
    }
    
    /**
     * Get the root of the filesystem (/)
     */
    public static Directory getRoot()
    {
        return root;
    }
    
    /**
     * Get the userdirectory of the filesystem
     */
    public static Directory getUserdirectory()
    {
        return userdir;
    }
    
    /**
     * Copy the file to the list files in the userdirectory
     * 
     * @param       File subject    The file which needs to be copied to the userdirectory
     */
    public static void copyFile(File subject)
    {
        userdir.addFile(subject);
    }
    
    /**
     * Checks the list for the presence of the specified file
     * 
     * @return      return the boolean check
     */
    public static boolean fileExists(File subject)
    {
        boolean check = false;
        for(File file : userdir.getFiles())
        {
            if(userdir.getFiles().contains(subject) == true)
            {
                check = true;
            }
        }
        return check;
    }
    
    /**
     * Find an object of the class Directory with a specific name
     * 
     * @param       String name     The name of the directory one searches
     * @return      directory       The object of the class Directory. returns null if not found.
     */
    public static Directory findDirectoryByName(String name)
    {
        Directory directory = null;
        for(Directory dir : currentDirectory.getChilds())
        {
            if(dir.getName().equals(name) == true)
            {
                directory = dir;
            }
        }
        return directory;
    }
    
    /**
     * Find an object of the class File with a specific name
     * 
     * @param   String name     The name of the file one searches
     * @return  file            The object of the class File. returns null if not found.
     */
    public static File findFileByName(String name)
    {
        File file = null;
        for(File searchFile : currentDirectory.getFiles())
        {
            if(searchFile.getName().equals(name) == true)
            {
                file = searchFile;
            }
        }
        return file;
    }
    
    /**
     * Get the childs of the current directory
     * 
     * @return      return the ArrayList<Directory>
     */
    public static ArrayList<Directory> getCurrentChilds()
    {
        return currentDirectory.getChilds();
    }
    
    /**
     * Get the files of the current directory
     * 
     * @return      return the ArrayList<File>
     */
    public static ArrayList<File> getCurrentFiles()
    {
        return currentDirectory.getFiles();
    }
    
    /**
     * Remove the file from the list of files
     * 
     * @param       File file   The file which needs to be deleted
     */
    public static void removeFile(File file)
    {
        getCurrentFiles().remove(file);
    }
            
    /**
     * Gets how many diskspace is used
     * 
     * @return  returns how many space is used on your harddrive
     */
    public static int getUsedDiskspace()
    {
        return spaceUsed;
    }
    
    /**
     * Updates how many space there is used on your harddrive
     */
    public static void updateDiskspace()
    {
        ArrayList<File> list = userdir.getFiles();
        int subtotal = 0;
        for(File file : list)
        {
            subtotal += file.getSize();
        }
        spaceUsed = subtotal;
    }
    
    /**
     * Return the disksize of the disk with the /home partition
     * 
     * @return  int     the disk size in kb
     */
    public static int getDiskSize()
    {
        return space;
    }
}
