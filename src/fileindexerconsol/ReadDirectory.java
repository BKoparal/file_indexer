package fileindexerconsol;

import fileindexerconsol.entities.Directories;
import fileindexerconsol.entities.Word;
import fileindexerconsol.readers.Factory;
import fileindexerconsol.readers.IFileFormatReadders;
import java.io.File;
import java.util.List;


public class ReadDirectory {

    public Directories indexDirectory(String directoryName) {
        //variables
        Factory factory = new Factory();
        Directories directories = new Directories(directoryName);

        //get all files names in a directory
        File[] allfiles = Tool.getAllFilesBasicName(directoryName);

        //all files
        int countForRest = 0;
        for (File dicFile : allfiles) {
            countForRest++;
            if (countForRest == 1000) {
                try {
                    Thread.sleep(3000);
                    countForRest = 0;
                } catch (InterruptedException ex) {
                    System.out.println("ERROR: " + ex.getMessage());
                }
            }

            //variables
            int count = 0;
            final String fileName = dicFile.getName();
            final String extension = Tool.getFileExtension(fileName);
            final IFileFormatReadders reader = factory.createReader(extension);
            /*System.out.println("\nFILE PATH :"+ filePath);
            System.out.println("EXTENSION :"+ extension);
            System.out.println("------------------------");*/

            if (reader != null) {
                List<String> lst = reader.getAllLines(directoryName + "/" + fileName);
                    //all lines in list
                    for (String line : lst) {
                        count++;
                        //convert line 
                        line = Tool.convertToEnglish(line);
                        //get tokens as list
                        List<String> lineTokens = Tool.getTokenList(line);

                        if (!lineTokens.isEmpty()) {
                            for (String token : lineTokens) {
                                //System.out.println(token);
                                directories.addWordToTreeSet(new Word(token), fileName, count);
                            }
                        }
                    }
            }
        }
        return directories;
    }

    static void printList(List<String> l) {
        for (String s : l) {
            System.out.println(s);
        }
    }

}


/*
public static void main(String[] args) {

        Factory factory = new Factory();
        String directoryName = "alldocs";
        //String directoryName="others";
        File[] allfiles = Tool.getAllFilesBasicName(directoryName);
        HashSet<Directories> directories;
        for (File dicFile : allfiles) {
            final String filePath = dicFile.getAbsolutePath();
            final String extension = Tool.getFileExtension(dicFile.getName());
            System.out.println("FILE: " + filePath);
            System.out.println("FILE: " + extension);
            System.out.println("---------------------------------");
            IFileFormatReadders reader = factory.createReader(extension);
            if (reader != null) {
                List<String> lst = reader.getAllTokens(filePath);
                printList(lst);
            }

            //txt.getText("AllDocs/dortyol.sql");
        }
        /*IFileFormatReadders txt=new TXTreader();
        //txt.getText("AllDocs/dortyol.sql");
        txt.getText("AllDocs/merge.cpp");
    }

    static void printList(List<String> l) {
        for (String s : l) {
            System.out.println(s);
        }
    }
 */
