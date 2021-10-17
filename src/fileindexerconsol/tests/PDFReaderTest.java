

package fileindexerconsol.tests;

import fileindexerconsol.readers.PDF_Reader;
import java.util.List;


public class PDFReaderTest {
    public static void main(String[] args) {
        PDF_Reader p=new PDF_Reader();
        List<String> sList=p.getAllLines("D:/test.pdf");
        printList(sList);
    }
    
    static void printList(List<String> l) {
        for (String s : l) {
            System.out.println( s);
        }
    }
}


    