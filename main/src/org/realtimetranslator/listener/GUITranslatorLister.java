package org.realtimetranslator.listener;

import org.realtimetranslator.ImageTextReader;
import org.realtimetranslator.Translator;
import org.realtimetranslator.displayer.DisplayerGUI;

public class GUITranslatorLister extends AbstractTranslatorListener {

    DisplayerGUI displayerGUI;
    public GUITranslatorLister(Translator translator, ImageTextReader reader) {
        super(translator, reader);
        displayerGUI = new DisplayerGUI();
    }

    @Override
    void doWithTranslatedText(String translated) {

        displayerGUI.display(translated);
    }


}
