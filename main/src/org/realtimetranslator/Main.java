package org.realtimetranslator;

import org.realtimetranslator.captor.DefaultScreenCaptor;
import org.realtimetranslator.listener.LoggingListenerMock;
import org.realtimetranslator.listener.AbstractTranslatorListener;
import org.realtimetranslator.listener.LoggingTranslatorListener;
import org.realtimetranslator.reader.TesseractReader;
import org.realtimetranslator.setting.DefaultScreenSettingUI;
import org.realtimetranslator.translator.PapagoTranslator;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        long screenShotDelay = 1000;
        Translator translator = new PapagoTranslator();
        ImageTextReader reader = new TesseractReader("eng");
        List<CaptureListener> listenerList = Arrays.asList(
                new LoggingListenerMock(),
                new LoggingTranslatorListener(translator, reader)
        );
        ScreenCaptor captor = new DefaultScreenCaptor(Executors.newSingleThreadScheduledExecutor(),
                listenerList, screenShotDelay);
        ScreenSettingUI ui = new DefaultScreenSettingUI(captor);
        ui.startUI();
    }
}
