/*
 * @author 	:		agarw
 * @Date	:	 	31-Oct-2019
 * @Project :		places-backend
 * @Package : 		com.operr.assignment.exceptions
 * @Type	: 		InvalidRequestException
 */
package com.operr.assignment.exceptions;

// TODO: Auto-generated Javadoc
/**
 * The Class InvalidRequestException.Exception Class Determining the Bad Request
 * in the application request.
 */
public class InvalidRequestException extends AppExceptions {

	/**
	 *
	 */
	private static final long serialVersionUID = -2329061314463345546L;

	/**
	 * Instantiates a new invalid request exception.
	 */
	public InvalidRequestException() {
		super("Bad Request Parameters provided.");
	}

	/**
	 * Instantiates a new invalid request exception.
	 *
	 * @param errorMessage the error message
	 */
	public InvalidRequestException(String errorMessage) {
		super(errorMessage);
	}

}
