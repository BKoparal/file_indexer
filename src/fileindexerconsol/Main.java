
package fileindexerconsol;

import fileindexerconsol.entities.Directories;
import fileindexerconsol.readers.Factory;



public class Main {

    public static void main(String[] args) {
        Factory factory = new Factory();
        ReadDirectory readDirectory = new ReadDirectory();
        Directories d = readDirectory.indexDirectory("alldocs");
        d.printDirectories(d);
    }
}

