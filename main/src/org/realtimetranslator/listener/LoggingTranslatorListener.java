package org.realtimetranslator.listener;

import org.realtimetranslator.ImageTextReader;
import org.realtimetranslator.Translator;

public class LoggingTranslatorListener extends AbstractTranslatorListener {

    public LoggingTranslatorListener(Translator translator, ImageTextReader reader) {
        super(translator, reader);
    }

    @Override
    void doWithTranslatedText(String translated) {
        System.out.println(translated);
    }
}
