package com.favoritemedium.mattermost.api.exception;

public class CookiesDisabledException extends Exception {

	private static final long serialVersionUID = 1L;

	public CookiesDisabledException(String message) {
		super(message);
	}
}
