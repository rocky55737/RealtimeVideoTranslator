package tess4j.example;

import java.io.File;
import net.sourceforge.tess4j.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        File cwd = new File(".");
        String cwdPath = cwd.getAbsolutePath();
        File imageFile = new File(cwdPath + "\\src\\img\\eurotext.png"); // Path to the target image file.
        ITesseract instance = new Tesseract(); // JNA Interface Mapping.
        instance.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata"); // Path to the tesseract data files.

        try {
            String result = instance.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
}
