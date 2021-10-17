

package fileindexerconsol.tests;

import fileindexerconsol.readers.ODT_reader;
import java.util.List;


public class ODTReaderTest {
    public static void main(String[] args) {
        ODT_reader p=new ODT_reader();
        //List<String> sList=p.getAllLines("D:/test.odt");
        //List<String> sList1=p.getAllLines("D:/test.docx");
        List<String> sList1=p.getAllLines("D:/test.odt");
        //printList(sList);
    }
    
    static void printList(List<String> l) {
        for (String s : l) {
            System.out.println( s);
        }
    }
}


    