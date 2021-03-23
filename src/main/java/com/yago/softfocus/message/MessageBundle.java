package com.yago.softfocus.message;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public final class MessageBundle {

    private static final String BUNDLE_NAME = "message";

    private MessageBundle() {
        super();
    }

    public static String getMessage(final String key) {
        return ResourceBundle.getBundle(BUNDLE_NAME, getLocale()).getString(key);
    }

    public static String getMessage(final String key, final String... args) {
        return MessageFormat.format(getMessage(key), (Object[]) args);
    }

    private static Locale getLocale() {
        return new Locale("pt", "BR");
    }
}