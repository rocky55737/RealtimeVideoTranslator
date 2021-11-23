package org.realtimetranslator.translator;

import org.realtimetranslator.Translator;
import java.util.WeakHashMap;

public class CachingTranslator implements Translator{
    private Translator delegate;
    private WeakHashMap<String, String> requestCache = new WeakHashMap<>();

    public CachingTranslator(Translator delegate) {
        this.delegate = delegate;
    }

    @Override
    public String translate(String origin) {
        if (requestCache.containsKey(origin))
            return requestCache.get(origin);
        String translated = delegate.translate(origin);
        requestCache.put(origin, translated);
        return translated;
    }
}
