package fileindexerconsol.readers;

import fileindexerconsol.readers.IFileFormatReadders;

public class Factory {

    public IFileFormatReadders createReader(String extensions) {
        extensions = extensions.toLowerCase();
        switch (extensions) {
            case "c":
            case "cpp":
            case "sql":
            case "java":
            case "txt":
                return new TXT_reader();
        }
        return null;
    }
}
