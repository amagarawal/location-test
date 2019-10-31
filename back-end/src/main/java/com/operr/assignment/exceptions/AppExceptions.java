/*
 * @author 	:		agarw
 * @Date	:	 	31-Oct-2019
 * @Project :		places-backend
 * @Package : 		com.operr.assignment.exceptions
 * @Type	: 		AppExceptions
 */
package com.operr.assignment.exceptions;

/**
 * The Class AppExceptions.Global Exception Object for the Application.
 */
public class AppExceptions extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = -8201599504880284414L;

	/** The error message. */
	String errorMessage;

	/**
	 * Instantiates a new app exceptions.
	 */
	public AppExceptions() {
		super("Something Went Wrong while Processing the Request");
	}

	/**
	 * Instantiates a new app exceptions.
	 *
	 * @param errorMessage the error message
	 */
	public AppExceptions(String errorMessage) {
		super(errorMessage);
	}
}
