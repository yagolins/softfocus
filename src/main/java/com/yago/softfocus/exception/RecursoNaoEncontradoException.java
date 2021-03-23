package com.yago.softfocus.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RecursoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

    public RecursoNaoEncontradoException(final String msg) {
        super(msg);
    }
}
