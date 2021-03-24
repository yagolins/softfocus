package com.yago.softfocus.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SpotifyException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SpotifyException(final String msg) {
		super(msg);
	}
}
