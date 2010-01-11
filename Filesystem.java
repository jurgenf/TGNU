
/**
 * Write a description of class Filesystem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Filesystem
{
    //De directories
    private static Directory root = new Directory("/");
    private static Directory home = new Directory("home", root);
    private static Directory userdir = new Directory(GameController.getUsername(), home);
    private static Directory mainframe = new Directory("mainframe", root);
    private static Directory mainframeEtc = new Directory("etc", mainframe);
    private static Directory mainframeBin = new Directory("bin", mainframe);
    private static Directory mainframeHome = new Directory("home", mainframe);
    private static Directory mainframeTmp = new Directory("tmp", mainframe);
    private static Directory mainframeVar = new Directory("var", mainframe);
    private static Directory earl = new Directory("earl", "My Name=", mainframeHome);
    private static Directory thomas = new Directory("thomas", "1337", mainframeHome);
    private static Directory et = new Directory("et", "Go Home", mainframeHome);
    private static Directory henry = new Directory("henry", "Frankenstein", mainframeHome);    
    private static Directory www = new Directory("www", mainframeVar);
    
    //The Files
    private static File passwords = new File("passwords", "user:thomas \npassword:1337 \nuser:et \npassword:Go Home \nuser:earl \npassword:My Name= \nuser:henry \npassword:Frankenstein", 10, mainframeEtc);
    private static File shadow = new File("shadow", "6zI18EUZW4watEJ15NEmk0GpQjrAJU5h5BVWPMxwnPdjtdQdqhpRf7bWQo+4TcB2XkRKYL1q+hYZkDaLSi4+BltcmIYeWq0Y9ByNU7LPJsF11vkfGp8LoSaKBMwWG23DJNKk/tVH2Lu9R/Z60HhdhbbWQo+4TcB2CNLlRpNkZ8tMaPesK9xEog==", 50, mainframeEtc);
    private static File profile = new File("profile", "", 1, mainframeEtc);
    private static File networks = new File("networks", "", 1, mainframeEtc);
    private static File modules = new File("modules", "", 1, mainframeEtc);
    private static File host = new File("host.conf", "", 1, mainframeEtc);
    private static File services = new File("sevices", "", 18, mainframeEtc);
    private static File bash = new File("bash", "", 712, mainframeBin);
    private static File cat = new File("cat", "", 30, mainframeBin);
    private static File cp = new File("cp", "", 74, mainframeBin);
    private static File ls = new File("ls", "", 94, mainframeBin);
    private static File aliendb = new File("aliendb.sql","#\n# Database structure for database 'alien'\n#\n\nCREATE DATABASE /*!32312 IF NOT EXISTS*/ \"alien\" /*!40100 DEFAULT CHARACTER SET latin1 */;\n\nUSE \"alien\";\n\n\n#\n# Table structure for table 'administration'\n#\n\nCREATE TABLE /*!32312 IF NOT EXISTS*/ \"administration\" (\n  \"idAlien\" int(11) NOT NULL,\n  \"alienSpecie\" varchar(45) DEFAULT NULL,\n  \"picture\" varchar(45) DEFAULT NULL,\n  \"length\" int(11) DEFAULT NULL,\n  \"weight\" varchar(45) DEFAULT NULL,\n  PRIMARY KEY (\"idAlien\")\n);\n\n\n\n#\n# Dumping data for table 'administration'\n#\n\nLOCK TABLES \"administration\" WRITE;\n/*!40000 ALTER TABLE \"administration\" DISABLE KEYS;*/\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n    (0,'Vulcan','http://memory-alpha.org/en/wiki/Vulcan',179,'63');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n   (1,'Klingon','http://memory-alpha.org/en/wiki/Klingon',150,'100');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n    (2,'Romulan','http://memory-alpha.org/en/wiki/Romulan',90,'10');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n  (3,'Cardassien','http://memory-alpha.org/en/wiki/Cardassian',120,'40');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n   (4,'Ferengi','http://memory-alpha.org/en/wiki/Ferengi',50,'20');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n  (5,'Borg','http://memory-alpha.org/en/wiki/Borg',102,'16');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n   (6,'Bejoran','http://memory-alpha.org/en/wiki/Bajoran',393,'23');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n (7,'Betazoid','http://memory-alpha.org/en/wiki/Betazoid',42,'89');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n    (8,'wookiee','http://musicselections.files.wordpress.com/20',200,'54');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n   (9,'umpa lumpa','http://sipr.net/oompa_loompa.jpg',120,'40');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n (10,'tribble','http://www.product-reviews.net/wp-content/use',10,'3');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n    (11,'tril','http://memory-alpha.org/en/wiki/Trill',24,'3');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n   (12,'goa''uld',NULL,127,'30');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n    (13,'wraith','http://memory-alpha.org/en/wiki/Wraith',579,'440');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n (14,'furling',NULL,376,'146');\nREPLACE INTO \"administration\" (\"idAlien\", \"alienSpecie\", \"picture\", \"length\", \"weight\") VALUES\n    (15,'jem''hadar',NULL,234,'78');\n/*!40000 ALTER TABLE \"administration\" ENABLE KEYS;*/\nUNLOCK TABLES;\n/*!40101 SET SQL_MODE=@OLD_SQL_MODE;*/\n/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;*/", 14, mainframeTmp);

        //Set exits for all maps
       // filesystem.setExit("mainframe", mainframe);
       // filesystem.setExit("home", mainframeHome);
    public static void addChilds()
    {
        home.addChild(userdir);
        root.addChild(home);
        root.addChild(mainframe);
        mainframe.addChild(mainframeEtc);
        mainframe.addChild(mainframeHome);
        mainframe.addChild(mainframeBin);
        mainframe.addChild(mainframeTmp);
        mainframe.addChild(mainframeVar);
        mainframeHome.addChild(earl);
        mainframeHome.addChild(thomas);
        mainframeHome.addChild(et);
        mainframeHome.addChild(henry); 
        mainframeVar.addChild(www);
    }
}
