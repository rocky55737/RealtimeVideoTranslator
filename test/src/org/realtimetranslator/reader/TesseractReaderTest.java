package org.realtimetranslator.reader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.realtimetranslator.ImageTextReader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;


public class TesseractReaderTest {

    private static final String IMAGE_NAME = "K-009.png";
    private static final String SRC_LANG = "eng";
    private static final String RESULT_TEXT_NAME= "mustBeResult";
    private static final String DATA_PATH= "tessdata";
    private static BufferedImage imageToRead;
    private static String mustBeResult;

    private final ImageTextReader reader = new TesseractReader(SRC_LANG, DATA_PATH);

    @BeforeAll
    public static void setUpImageAndResult() {
        try {
            readImage();
            readResultText();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private static void readImage() throws IOException {
        InputStream imageStream = TesseractReader.class.getClassLoader().getResourceAsStream(IMAGE_NAME);
        Assertions.assertNotNull(imageStream);
        imageToRead = ImageIO.read(imageStream);
    }

    private static void readResultText() throws IOException {
        InputStream file = TesseractReader.class.getClassLoader().getResourceAsStream(RESULT_TEXT_NAME);
        Assertions.assertNotNull(file);
        mustBeResult = new String(file.readAllBytes());
    }

    @Test
    public void readImageAndCompare() {
        String readText = reader.readFromImage(imageToRead);
        Assertions.assertEquals(mustBeResult, readText);
    }
}
