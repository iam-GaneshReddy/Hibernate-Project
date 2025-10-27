package com.scaleupindia.exceptions;

public class OwnerAlreadyExistsException extends Exception {
    private static final long serialVersionUID = 1L;

	public OwnerAlreadyExistsException(String message) {
		super(message);
	}
}
