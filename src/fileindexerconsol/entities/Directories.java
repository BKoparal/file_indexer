package fileindexerconsol.entities;

import java.util.TreeSet;

public class Directories {

    private String directoryName;
    private TreeSet<Word> wordTreeSet;

    public Directories(String directoryName) {
        this.directoryName = directoryName;
        this.wordTreeSet = new TreeSet<>();
    }

    private Word findWordInTree(Word vocabulary) {
        Word wCeil = this.wordTreeSet.ceiling(vocabulary);
        Word wFloor = this.wordTreeSet.floor(vocabulary);
        return wCeil == wFloor ? wCeil : null;
    }

    public void addWordToTreeSet(Word newWord, String filePath, int line) {
        Word findResult = findWordInTree(newWord);
        //if not in tree
        if (findResult == null) {
            newWord.addFileNames(filePath, line);
            addWord(newWord);
        } else {
            findResult.increaseFrequency();
            findResult.addFileNames(filePath, line);
        }
    }

    public String getDirectoryName() {
        return directoryName;
    }

    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
    }

    public TreeSet<Word> getWordTreeSet() {
        return wordTreeSet;
    }

    public void setWordTreeSet(TreeSet<Word> wordTreeSet) {
        this.wordTreeSet = wordTreeSet;
    }

    public void addWordTreeList(TreeSet<Word> wordList) {
        this.wordTreeSet.addAll(wordList);
    }

    public void addWord(Word word) {
        this.wordTreeSet.add(word);
    }
    
    
    public static void printDirectories(Directories d){
        for (Word word : d.getWordTreeSet()) {
            System.out.printf("%-20s%-6d",word.getVocable(),word.getFreq());
            word.printFileNameList();
            System.out.println("");
        }
    }
}
