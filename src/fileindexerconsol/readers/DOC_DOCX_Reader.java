package fileindexerconsol.readers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.extractor.ExtractorFactory;
import org.apache.poi.extractor.POITextExtractor;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class DOC_DOCX_Reader implements IFileFormatReadders {

    @Override
    public List<String> getAllLines(String docName) {
        try {
            
            
            File file = new File(docName);
            if (file.isFile()) {
                FileInputStream fis = new FileInputStream(file.getAbsolutePath());

                POITextExtractor extractor;
                // if docx
                if (file.getName().toLowerCase().endsWith(".docx")) {
                    XWPFDocument doc = new XWPFDocument(fis);
                    extractor = new XWPFWordExtractor(doc);
                } else  {
                    // if doc
                    POIFSFileSystem fileSystem = new POIFSFileSystem(fis);
                    extractor = ExtractorFactory.createExtractor(fileSystem);
                }
                String extractedText = extractor.getText();

                System.out.println(extractedText);
            }

        } catch (IOException ex) {
            Logger.getLogger(DOC_DOCX_Reader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
/*
InputStream fis = new FileInputStream(...);
POITextExtractor extractor;
// if docx
if (fileName.toLowerCase().endsWith(".docx")) {
    XWPFDocument doc = new XWPFDocument(fis);
    extractor = new XWPFWordExtractor(doc);
} else {
    // if doc
    POIFSFileSystem fileSystem = new POIFSFileSystem(fis);
    extractor = ExtractorFactory.createExtractor(fileSystem);
}
String extractedText = extractor.getText();
 */


 /*
 @Override
    public List<String> getAllLines(String docName) {
        try {
            File file = new File(docName);
            if(file.isFile()){
                FileInputStream fis=new FileInputStream(file.getAbsolutePath());
                HWPFDocument document=new HWPFDocument(fis);
                //XWPFDocument docx=new XWPFDocument(fis);
                //XWPFWordExtractor we=new XWPFWordExtractor(docx);
                WordExtractor w=new WordExtractor(document);
                System.out.println(Arrays.asList(w.getParagraphText()));
            }

        } catch (IOException ex) {
            Logger.getLogger(DOCX_Reader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
 */
