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
        //mustBeResult = new String(file.readAllBytes());
        mustBeResult = new String(readAllBytes(file));
    }

    @Test
    public void readImageAndCompare() {
        String readText = reader.readFromImage(imageToRead);
        Assertions.assertEquals(mustBeResult, readText);
    }

    public static byte[] readAllBytes(InputStream inputStream) throws IOException {
        final int bufLen = 1024;
        byte[] buf = new byte[bufLen];
        int readLen;
        IOException exception = null;

        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            while ((readLen = inputStream.read(buf, 0, bufLen)) != -1)
                outputStream.write(buf, 0, readLen);

            return outputStream.toByteArray();
        } catch (IOException e) {
            exception = e;
            throw e;
        } finally {
            if (exception == null) inputStream.close();
            else try {
                inputStream.close();
            } catch (IOException e) {
                exception.addSuppressed(e);
            }
        }
    }
}
