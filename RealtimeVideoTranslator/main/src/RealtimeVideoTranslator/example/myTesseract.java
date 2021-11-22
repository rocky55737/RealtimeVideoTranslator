package RealtimeVideoTranslator.example;

import java.io.File;
import net.sourceforge.tess4j.*;

public class myTesseract {
    private static String srcLang = "eng";

    public void setImgLang(String imgLang) { srcLang = imgLang; }
    public String imgToString(String fileName) {
        File cwd = new File(".");
        String cwdPath = cwd.getAbsolutePath();
        File imageFile = new File(cwdPath + "\\src\\img\\" + fileName); // Path to the target image file.
        ITesseract instance = new Tesseract(); // JNA Interface Mapping.
        instance.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata"); // Path to the tesseract data files.
        instance.setLanguage(srcLang);

        try {
            return (String)instance.doOCR(imageFile);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }

        return null;
    }
}
