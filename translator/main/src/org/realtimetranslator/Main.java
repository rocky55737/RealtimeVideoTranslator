package org.realtimetranslator;

import org.realtimetranslator.captor.DefaultScreenCaptor;
import org.realtimetranslator.listener.LoggingListenerMock;
import org.realtimetranslator.listener.GUITranslatorLister;
import org.realtimetranslator.reader.TesseractReader;
import org.realtimetranslator.setting.DefaultScreenSettingUI;
import org.realtimetranslator.translator.PapagoTranslator;
import org.realtimetranslator.translator.CachingTranslator;

import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args)  {
        long screenShotDelay = 1000;
        // 시스템 인코딩 기반을 UTF-8 로 설정하는 부분.
        System.setProperty("file.encoding","UTF-8");
        try {
            Field charset = Charset.class.getDeclaredField("defaultCharset");
            charset.setAccessible(true);
            charset.set(null,null);
        } catch(Exception e) {
        }

        // 파파고
        Translator translator = new CachingTranslator(new PapagoTranslator());
        // 테서렉트
        ImageTextReader reader = new TesseractReader("eng", "tessdata");
        // 캡처리스트
        List<CaptureListener> listenerList = Arrays.asList(
                new LoggingListenerMock(),
                new GUITranslatorLister(translator, reader)
        );
        //캡처
        ScreenCaptor captor = new DefaultScreenCaptor(Executors.newSingleThreadScheduledExecutor(),
                listenerList, screenShotDelay);
        ScreenSettingUI ui = new DefaultScreenSettingUI(captor);
        ui.startUI();
    }
}
