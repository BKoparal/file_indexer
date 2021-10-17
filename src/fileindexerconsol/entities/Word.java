package fileindexerconsol.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Word implements Comparable<Word> {

    private String vocable;             //the word will be indexed
    private int freq;                   //frequency of the word
    private List<FileNames> fNameList;  //files containing the word

    //constructure
    public Word(String vocable) {
        fNameList = new ArrayList<>();
        this.vocable = vocable;
        this.freq = 1;
    }

    /**
     * for finding elements method used java8 stream
     */
    private FileNames findFileName(String fileName) {
        FileNames fn = fNameList
                .stream()
                .filter(fName -> fileName.equals(fName.getBasicFileName()))
                .findAny()
                .orElse(null);
        return fn;
    }
    

    /*
    if filename in list only add line number else add a new fileName object
     * */
    public void addFileNames(String fileName, int lineNumber) {
        FileNames result = findFileName(fileName);
        if (result == null) {
            FileNames f=new FileNames(fileName,lineNumber);
            fNameList.add(f);
        } else {
            result.addNewLineNumber(lineNumber);
        }
    }
    
    

    public void increaseFrequency() {
        this.freq++;
    }

    public int getFreq() {
        return freq;
    }

    public String getVocable() {
        return vocable;
    }

    public void setVocable(String vocable) {
        this.vocable = vocable;
    }

    public List<FileNames> getFileNameList() {
        return fNameList;
    }
    
    public void printFileNameList() {
        for (FileNames fileNames : fNameList) {
            System.out.print(fileNames);
            System.out.print(fileNames.getLines());
            System.out.print(", ");
        }
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.vocable);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Word other = (Word) obj;
        if (!Objects.equals(this.vocable, other.vocable)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Word{" + "vocable=" + vocable + '}';
    }

    @Override
    public int compareTo(Word o) {
        return this.vocable.compareTo(o.vocable);
    }
}

