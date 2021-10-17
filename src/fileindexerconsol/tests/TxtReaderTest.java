package fileindexerconsol.tests;

import fileindexerconsol.ReadDirectory;
import fileindexerconsol.entities.Directories;
import fileindexerconsol.readers.Factory;

public class TxtReaderTest {

    public static void main(String[] args) {
        Factory factory = new Factory();
        ReadDirectory readDirectory=new ReadDirectory();
        Directories d=readDirectory.indexDirectory("alldocs");
        d.printDirectories(d);
        
   
        System.out.println("------------");
        System.out.println("SIZE: "+d.getWordTreeSet().size());
    }
}
