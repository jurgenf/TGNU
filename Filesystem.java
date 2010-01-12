
/**
 * This class makes it possible to create a filesystem by making directories and files 
 * and link them together
 * 
 * @author penguisher 
 * @version v0.3
 */
public class Filesystem
{
    private static Directory root = new Directory("/");
    //Set the default Directory to root   
    private static Directory currentDirectory = root;

           
    /**
     * Add the Child directories to their parents
     */
    public static void createFilesystem()
    {
        //De directories
        Directory home = new Directory("home", root);
        Directory userdir = new Directory(GameController.getUsername(), home);
        Directory mnt = new Directory("mnt", root);
        
        Directory boot = new Directory("mnt", root);
        Directory bin = new Directory("bin", "1203Q@)93204830943201sadfkj13", root);
        Directory etc = new Directory("bin", "1203Q@)93204830943201sadfkj13", root);
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
        Directory www = new Directory("www", mainframeVar);
        Directory cdrom = new Directory("cdrom", mainframeMedia);
        Directory cdrom0 = new Directory("cdrom0", mainframeMedia);
        Directory earl = new Directory("earl", "My Name=", mainframeHome);
        Directory thomas = new Directory("thomas", "1337", mainframeHome);
        Directory et = new Directory("et", "Go Home", mainframeHome);
        Directory henry = new Directory("henry", "Frankenstein", mainframeHome);    
        Directory alien1 = new Directory("noalien4u", "Frankenstein", henry);
        Directory alien2 = new Directory("documents", "My Name=", earl);
        Directory alien3 = new Directory("phone", et);
        Directory fake1 = new Directory("schedule", henry);
        Directory fake2 = new Directory("alienate", et);
        Directory fake3 = new Directory("work", thomas);
        Directory research1 = new Directory("research", henry);
        Directory research2 = new Directory("research", earl);
        Directory research3 = new Directory("research", et);
        Directory research4 = new Directory("research", thomas);

        //addChilds
        root.addChild(home);
        home.addChild(userdir);        
        root.addChild(mnt);
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
                            
        //The Files
        mainframeEtc.addFile(new File("passwords", "user:thomas \npassword:1337 \nuser:et \npassword:Go Home \nuser:earl \npassword:My Name= \nuser:henry \npassword:Frankenstein", 10));
        mainframeEtc.addFile(new File("shadow", "6zI18EUZW4watEJ15NEmk0GpQjrAJU5h5BVWPMxwnPdjtdQdqhpRf7bWQo+4TcB2XkRKYL1q+hYZkDaLSi4+BltcmIYeWq0Y9ByNU7LPJsF11vkfGp8LoSaKBMwWG23DJNKk/tVH2Lu9R/Z60HhdhbbWQo+4TcB2CNLlRpNkZ8tMaPesK9xEog==", 50));
        mainframeEtc.addFile(new File("profile", "", 1));
        mainframeEtc.addFile(new File("networks", "", 1));
        mainframeEtc.addFile(new File("modules", "", 1));
        mainframeEtc.addFile(new File("host.conf", "", 1));
        mainframeEtc.addFile(new File("sevices", "", 18));
        mainframeEtc.addFile(new File("adduser.conf", "", 12));
        mainframeEtc.addFile(new File("inetd.conf", "", 24));
        mainframeEtc.addFile(new File("magic", "", 25));
        mainframeEtc.addFile(new File("profile", "", 21));
        mainframeEtc.addFile(new File("services", "", 96));
        
        mainframeBin.addFile(new File("bash", "", 712));
        mainframeBin.addFile(new File("cat", "", 30));
        mainframeBin.addFile(new File("cp", "", 74));
        mainframeBin.addFile(new File("ls", "", 94));
        mainframeBin.addFile(new File("rm", "", 38));
        
        
        mainframeTmp.addFile(new File("aliendb.sql","#\n# Database structure for database 'alien'\n#\n\nCREATE DATABASE /*!32312 IF NOT EXISTS*/ \"alien\" /*!40100 DEFAULT CHARACTER SET latin1 */;\n\nUSE \"alien\";\n\n\n#\n# Table structure for table 'administration'\n#\n\nCREATE TABLE /*!32312 IF NOT EXISTS*/ \"administration\" (\n  \"idAlien\" int(11) NOT NULL,\n  \"alienSpecie\" varchar(45) DEFAULT NULL,\n  \"picture\" varchar(45) DEFAULT NULL,\n  \"length\" int(11) DEFAULT NULL,\n  \"weight\" varchar(45) DEFAULT NULL,\n  PRIMARY KEY (\"idAlien\")\n);\n\n\n\n#\n# Dumping data for table 'administration'\n#\n\nLOCK TABLES \"administration\" WRITE;\n/*!40000 ALTER TABLE \"administration\" DISABLE KEYS;*/\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n    (0,'Vulcan','http://memory-alpha.org/en/wiki/Vulcan',179,'63');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n   (1,'Klingon','http://memory-alpha.org/en/wiki/Klingon',150,'100');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n    (2,'Romulan','http://memory-alpha.org/en/wiki/Romulan',90,'10');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n  (3,'Cardassien','http://memory-alpha.org/en/wiki/Cardassian',120,'40');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n   (4,'Ferengi','http://memory-alpha.org/en/wiki/Ferengi',50,'20');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n  (5,'Borg','http://memory-alpha.org/en/wiki/Borg',102,'16');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n   (6,'Bejoran','http://memory-alpha.org/en/wiki/Bajoran',393,'23');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n (7,'Betazoid','http://memory-alpha.org/en/wiki/Betazoid',42,'89');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n    (8,'wookiee','http://musicselections.files.wordpress.com/20',200,'54');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n   (9,'umpa lumpa','http://sipr.net/oompa_loompa.jpg',120,'40');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n (10,'tribble','http://www.product-reviews.net/wp-content/use',10,'3');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n    (11,'tril','http://memory-alpha.org/en/wiki/Trill',24,'3');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n   (12,'goa''uld',NULL,127,'30');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n    (13,'wraith','http://memory-alpha.org/en/wiki/Wraith',579,'440');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n (14,'furling',NULL,376,'146');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n    (15,'jem''hadar',NULL,234,'78');\n/*!40000 ALTER TABLE \"administration\" ENABLE KEYS;*/\nUNLOCK TABLES;\n/*!40101 SET SQL_MODE=@OLD_SQL_MODE;*/\n/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;*/", 14));
        mainframeTmp.addFile(new File("socket","", 25));
        mainframeTmp.addFile(new File("adjiw20123@12", "", 21));
        mainframeTmp.addFile(new File("linc-d72-sad23", "", 76));
        mainframeTmp.addFile(new File("asd-gpg-agent", "", 783));
        
        et.addFile(new File("jiskefet.avi", "Debiteuren Crediteuren", 700000));
        et.addFile(new File("alienarena", "Alien Arena 2009 is a free multiplayer online deathmatch game and a must-try for all shooter fans.", 518000));
        
        henry.addFile(new File("familyguy.avi", "episode 4 season 3", 7020012));
        henry.addFile(new File("status.txt", "I am examining this interesting specie at the moment. For some reason they seem attracted by current. I will keep you up to date", 123));
        
        fake1.addFile(new File("timetable.xls","", 100));
        fake1.addFile(new File("appointments.ics","", 40));
        fake1.addFile(new File("timetablebackup.xls","", 100));
        fake1.addFile(new File("appointmentsbackup.ics","", 40));
        fake1.addFile(new File("review09.xls","", 1000));
        fake2.addFile(new File("flame.doc","", 200));
        fake2.addFile(new File("george.doc","",20));
        fake2.addFile(new File("holiday2009.ppt","",40));
        fake2.addFile(new File("obama.txt","Obama denied our request for publishing our discoveries to the world.", 300));
        fake2.addFile(new File("bush.txt","Bush didn't seem very interested in our research.", 231));
        fake3.addFile(new File("cleaningschedule.xls","",124));
        fake3.addFile(new File("juffrouwjannie.jpg","",1247));
        fake3.addFile(new File("timetable.xls","", 289));
        fake3.addFile(new File("appointments.ics","", 40));
        fake3.addFile(new File("projects.xls","", 5023));
        
        alien1.addFile(new File("ufo-recovery.jpg", "", 2617));
        alien1.addFile(new File("identify.jpg", "", 1737));
        alien1.addFile(new File("corpse.jpg", "", 1275));
        alien1.addFile(new File("beach.jpg", "", 1752));
        alien1.addFile(new File("air.jpg", "", 17263));
        alien1.addFile(new File("unidentified.jpg", "", 1923));
        
        alien2.addFile(new File("owwmommah.jpg", "",2718));
        alien2.addFile(new File("gramps.jpg", "", 7519));
        alien2.addFile(new File("stitch.jpg", "", 1723));
        alien2.addFile(new File("wecallhimhomer.jpg", "", 1725));
        alien2.addFile(new File("clues.jpg", "", 1234));
        alien2.addFile(new File("tracks.jpg", "", 7820));
        
        alien3.addFile(new File("tracks.jpg", "", 1723));
        alien3.addFile(new File("ufo.jpg", "", 4191));
        alien3.addFile(new File("chacarron.mp3", "", 1873));
        alien3.addFile(new File("wookie.jpg", "" ,1828));
        alien3.addFile(new File("beach1.jpg", "", 2823));
        alien3.addFile(new File("beach2.jpg", "", 7132));
        alien3.addFile(new File("beach-tracks.jpg", "", 1823));
        alien3.addFile(new File("squirrel.jpg", "", 1732));
        alien3.addFile(new File("checkinthebox.jpg", "", 3721));
        alien3.addFile(new File("itsover9000.jpg", "", 2712));
        alien3.addFile(new File("description.txt", "sex: male \nage: 128 years \nlimbs: 24 \neyes: 5 \nskincolor: Chartreuse green", 18));

        research1.addFile(new File("200912Pacific", "A UFO crahed into the sea, we are going to investigate with a submarine", 29));
        research1.addFile(new File("200911Area", "The coffee machine doesn't work anymore, how many scientist do you need to repair a coffe machine?", 201));
        research1.addFile(new File("200922Belgium", "We found a sign of alien life in Belgium", 21));
        research1.addFile(new File("200907Tasmania", "Strange lights had been seen there by the inhabitants, but after some investigation it seemed to be a swarm of fireflies", 28));
        research2.addFile(new File("201001California", "After digging a lot of holes, we didn't find anything.", 45));
        research2.addFile(new File("200912Area", "Server crash deleted our data. Technicians are trying to retreive our data.", 12));
        research3.addFile(new File("201001Vlissingen", "Strange winds and extremely low temperatures were measured at Vlissingen, we are gathering intel about the weatherconditions now, it might be caused by aliens", 42));
        research3.addFile(new File("200912Area", "Server crashdeleted our data. Technicians re trying to retreive our data.", 12));
        research4.addFile(new File("2009EasterIsland", "I'm posted at EasterIsland for a year, to investigate the unknown glowing piece of rock which landed there. I will post my results next week", 25));
        
        
        acpi.addFile(new File("ejectbtn.sh", "", 20));
        acpi.addFile(new File("nextbtn.sh", "", 12));
        acpi.addFile(new File("hibernate.sh", "", 11));
        acpi.addFile(new File("sleep.sh", "", 13));
        acpi.addFile(new File("prepare.sh", "", 15));
        
        init.addFile(new File("acpid", "", 27));
        init.addFile(new File("cups", "", 17));
        init.addFile(new File("rc", "", 23));
        init.addFile(new File("rc.d", "", 29));
        init.addFile(new File("udev", "", 21));
        init.addFile(new File("halt", "", 34));
        init.addFile(new File("usplash", "", 57));
        
        grubEtc.addFile(new File("memtest86+", "", 13));
        
        x11.addFile(new File("xorg.conf", "", 25));
        x11.addFile(new File("Xsession", "", 12));
        x11.addFile(new File("X", "", 25));
                
    }
    /**
     * Get the current opened directory
     * 
     * @return  return the current opened directory
     */
    public static Directory getCurrentDirectory()
    {
        return currentDirectory;
    }
    
    /**
     * Set the current opened directory
     * 
     * @param   Directory dir   The directory which should be opened.  
     */
    public static void setCurrentDirectory(Directory dir)
    {
        currentDirectory = dir;
    }
    
    /**
     * Find an object of the class Directory with a specific name
     * 
     * @param   String name     The name of the directory one searches
     * @return  directory       The object of the class Directory. returns null if not found.
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
}
