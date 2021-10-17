package fileindexerconsol.readers;

import fileindexerconsol.Tool;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDF_Reader implements IFileFormatReadders {

    @Override
    public List<String> getAllLines(String docName) {
        String text="";
        try {
            File file = new File(docName);
            PDDocument document = PDDocument.load(file);
            PDFTextStripper pdfStripper = new PDFTextStripper();
            text = pdfStripper.getText(document);
            document.close();
        } catch (IOException ex) {
            System.out.println("Error details:"+ex.getMessage());
        }
        return Tool.convertTextToList(text);
    }

}
