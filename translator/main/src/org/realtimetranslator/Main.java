package org.realtimetranslator;

import org.realtimetranslator.captor.DefaultScreenCaptor;
import org.realtimetranslator.listener.LoggingListenerMock;
import org.realtimetranslator.listener.LoggingTranslatorListener;
import org.realtimetranslator.reader.TesseractReader;
import org.realtimetranslator.setting.DefaultScreenSettingUI;
import org.realtimetranslator.translator.PapagoTranslator;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args)  {
        long screenShotDelay = 1000;
        Translator translator = new PapagoTranslator();
        ImageTextReader reader = new TesseractReader("eng", "tessdata");
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
