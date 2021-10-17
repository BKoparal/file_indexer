package fileindexerconsol.readers;

import java.util.List;



public interface IFileFormatReadders {
    //abstract methods
    List<String> getAllLines(final String docName);
}
