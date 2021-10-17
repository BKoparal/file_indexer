

package fileindexerconsol.tests;

import fileindexerconsol.readers.DOC_DOCX_Reader;
import java.util.List;


public class DOCReaderTest {
    public static void main(String[] args) {
        DOC_DOCX_Reader p=new DOC_DOCX_Reader();
        List<String> sList=p.getAllLines("D:/test.doc");
        List<String> sList1=p.getAllLines("D:/test.docx");
        //printList(sList);
    }
    
    static void printList(List<String> l) {
        for (String s : l) {
            System.out.println( s);
        }
    }
}


    