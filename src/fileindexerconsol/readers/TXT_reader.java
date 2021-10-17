package fileindexerconsol.readers;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TXT_reader implements IFileFormatReadders {
    //The TreeSet stores the objects in the ascending order
    //It contains unique elements
    

    @Override
    public List<String> getAllLines(final String file) {
        return readFile(file);
    }

    
    
    /*
        read a file line by line
       then return it
    */
    List<String> readFile(final String file) {
        List<String> lines=new ArrayList<>();
        final File f = new File(file);
        try {
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                lines.add(sc.nextLine());
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            System.out.println(file + " oluşturulurken hata oluştu. detay: " + ex.getMessage());
        }
        return lines;
    } 
}
