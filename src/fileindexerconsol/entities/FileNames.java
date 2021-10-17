
package fileindexerconsol.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



public class FileNames implements Comparable<String>{
    private String basicFileName;
    private List<Integer> lines;

    //constructure
    public FileNames(String basicFileName, int lineNumber) {
        this.lines=new ArrayList<>();
        this.lines.add(lineNumber);
        this.basicFileName = basicFileName;
    }
    
    
    public String getBasicFileName() {
        return basicFileName;
    }

    public void setBasicFileName(String basicFileName) {
        this.basicFileName = basicFileName;
    }

    public List<Integer> getLines() {
        return lines;
    }
    

    public void addNewLineNumber(int lineNumber) {
        this.lines.add(lineNumber);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.basicFileName);
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
        final FileNames other = (FileNames) obj;
        if (!Objects.equals(this.basicFileName, other.basicFileName)) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public int compareTo(String str) {
        return this.basicFileName.compareTo(str);
    }

    @Override
    public String toString() {
        return  basicFileName + ' ';
    }
    
    
}
