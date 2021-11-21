package RealtimeVideoTranslator.example;

import java.io.File;
import net.sourceforge.tess4j.*;

public class myTesseract {
    private static String srcLang = "eng";

    public void setImgLang(String imgLang) { srcLang = imgLang; }
    public String imgToString(String fileName) {
        File imageFile = new File(fileName); // Path to the target image file.
        ITesseract instance = new Tesseract(); // JNA Interface Mapping.
        instance.setDatapath("/home/junsekim/tessdata"); // Path to the tesseract data files.
        instance.setLanguage(srcLang);
        try {
            return (String)instance.doOCR(imageFile);
        } catch (TesseractException e) {
            e.printStackTrace();
        }

        return null;
    }
}
