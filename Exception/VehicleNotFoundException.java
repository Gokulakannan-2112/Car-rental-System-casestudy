package com.carrent.exception;

public class VehicleNotFoundException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VehicleNotFoundException(String message) {
        super(message);
    }
}