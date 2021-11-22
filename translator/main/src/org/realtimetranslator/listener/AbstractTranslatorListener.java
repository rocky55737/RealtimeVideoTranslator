package org.realtimetranslator.listener;

import org.realtimetranslator.ImageTextReader;
import org.realtimetranslator.Translator;
import org.realtimetranslator.CaptureListener;

import java.awt.image.BufferedImage;

public abstract class AbstractTranslatorListener implements CaptureListener {

    private final Translator translator;
    private final ImageTextReader reader;

    public AbstractTranslatorListener(Translator translator, ImageTextReader reader) {
        this.translator = translator;
        this.reader = reader;
    }

    @Override
    public void onImageCapture(BufferedImage image) {
        String srcText = reader.readFromImage(image);
        String translated = translator.translate(srcText);
        doWithTranslatedText(translated);
    }

    abstract void doWithTranslatedText(String translated);
}
