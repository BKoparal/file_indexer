
package fileindexerconsol;

import fileindexerconsol.entities.Word;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;


public class Tool {
    /**
     * This method removes front, end spaces of line,
     * convert it to lowercases and convert turkish characters to english
     * @param orjLine
     * @return 
     */
    public static String convertToEnglish(String orjLine) {
        orjLine = orjLine.trim().toLowerCase();  //trim and lowercase
        orjLine = orjLine.replaceAll("\\\\n", "");
        orjLine = orjLine.replaceAll("\\\\t", "");
        orjLine = orjLine.replaceAll("\\\\r", "");
        orjLine = orjLine.replaceAll("ı", "i");
        orjLine = orjLine.replaceAll("ö", "o");
        orjLine = orjLine.replaceAll("ü", "u");
        orjLine = orjLine.replaceAll("ş", "s");
        orjLine = orjLine.replaceAll("ç", "c");
        orjLine = orjLine.replaceAll("ğ", "g");
        return orjLine;
    }

    
    
    
    public static List<String> getTokenList(String orjLine) {
        List<String> wordList=new ArrayList<>();
        if (orjLine.length() > 2) {
            wordList=new ArrayList<>();
            StringTokenizer st = new StringTokenizer(orjLine, " .=,&|(){}/\\<>:");
            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                token = token.replaceAll("[^a-z_$@*]", "");
                if (token.length() > 1) {
                    wordList.add(token);
                }
            }
        }
        return wordList;
    }
    
    

    
    //get all files from a directory
    public static File[] getAllFilesBasicName(String directoryName) {
        File kPath = new File(directoryName);
        if (kPath.isDirectory()) {
            return kPath.listFiles();
        } else {
            System.out.println(directoryName + " bir klasör veya dizin değil");
            return null;
        }
    }
    
    
    public static String getFileExtension(String filename) {
    return Optional.ofNullable(filename)
      .filter(f -> f.contains("."))
      .map(f -> f.substring(filename.lastIndexOf(".") + 1))
      .get();
    }

    public static List<String> convertTextToList(String text) {
        String []textArray=text.split("\n");
        return Arrays.asList(textArray);
    }

}


