/*
 * @author 	:		agarw
 * @Date	:	 	31-Oct-2019
 * @Project :		places-backend
 * @Package : 		com.operr.assignment.exceptions
 * @Type	: 		LocationNotFoundException
 */
package com.operr.assignment.exceptions;

// TODO: Auto-generated Javadoc
/**
 * The Class LocationNotFoundException.Exception Thrown when requested Location
 * is not found in the application.
 */
public class LocationNotFoundException extends AppExceptions {

	/**
	 *
	 */
	private static final long serialVersionUID = -967305651286064748L;

	/**
	 * Instantiates a new location not found exception.
	 */
	public LocationNotFoundException() {
		super("The request location is not available");
	}

	/**
	 * Instantiates a new location not found exception.
	 *
	 * @param errorMessage the error message
	 */
	public LocationNotFoundException(String errorMessage) {
		super(errorMessage);

	}
}
