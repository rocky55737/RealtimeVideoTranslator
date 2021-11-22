package org.realtimetranslator.reader;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.realtimetranslator.ImageTextReader;

import java.awt.image.BufferedImage;

public class TesseractReader implements ImageTextReader {

    private final ITesseract tesseract;

    public TesseractReader(String srcLang, String dataPath) {
        this.tesseract = new Tesseract();
        this.tesseract.setDatapath(dataPath);
        this.tesseract.setLanguage(srcLang);
    }

    @Override
    public String readFromImage(BufferedImage image) {
        try {
            return tesseract.doOCR(image);
        } catch (TesseractException e) {
            e.printStackTrace();
            return null;
        }
    }
}
