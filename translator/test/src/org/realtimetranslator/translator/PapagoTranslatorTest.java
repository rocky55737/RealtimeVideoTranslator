package org.realtimetranslator.translator;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.realtimetranslator.Translator;

public class PapagoTranslatorTest {

    private final Translator translator = new PapagoTranslator();
    private final String TEXT_TO_TRANSLATE = "Hello, World!";

    @Test
    public void translateText() {
        String translated = translator.translate(TEXT_TO_TRANSLATE);
        String mustBeResult = "안녕, 월드!";
        Assertions.assertEquals(mustBeResult, translated);
    }

}
