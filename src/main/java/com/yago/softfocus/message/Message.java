package com.yago.softfocus.message;

import java.util.Locale;

public enum Message {

	NENHUM_REGISTRO_ENCONTRADO;

    public String getMessage() {
        return MessageBundle.getMessage(toKeyMessage());
    }

    public String getMessage(final String... campos) {
        return MessageBundle.getMessage(toKeyMessage(), campos);
    }

    public String toKeyMessage() {
        return this.toString().toLowerCase(Locale.getDefault()).replace("_", ".");
    }
}
