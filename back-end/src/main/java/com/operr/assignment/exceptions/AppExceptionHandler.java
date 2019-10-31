/*
 * @author 	:		agarw
 * @Date	:	 	31-Oct-2019
 * @Project :		places-backend
 * @Package : 		com.operr.assignment.exceptions
 * @Type	: 		AppExceptionHandler
 */
package com.operr.assignment.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.operr.assignment.dto.GenricErrorResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class AppExceptionHandler. ControllerAdvise defining the Exception
 * Handling on the Global level.
 */
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Handle entity not found exception.
	 *
	 * @param ex the ex
	 * @return the response entity
	 */
	@ExceptionHandler({ LocationNotFoundException.class, InvalidRequestException.class })
	protected ResponseEntity<Object> handleEntityNotFoundException(AppExceptions ex) {
		GenricErrorResponse errorResponse = new GenricErrorResponse();
		errorResponse.getErrorMap().put(HttpStatus.BAD_REQUEST.name(), ex.getLocalizedMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}

	/**
	 * Handle exception internal.
	 *
	 * @param ex      the ex
	 * @param body    the body
	 * @param headers the headers
	 * @param status  the status
	 * @param request the request
	 * @return the response entity
	 */
	@Override
	@ExceptionHandler({ AppExceptions.class, Exception.class })
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		GenricErrorResponse errorResponse = new GenricErrorResponse();
		errorResponse.getErrorMap().put(HttpStatus.INTERNAL_SERVER_ERROR.name(), ex.getLocalizedMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	}

	/**
	 * Handle http media type not acceptable.
	 *
	 * @param ex      the ex
	 * @param headers the headers
	 * @param status  the status
	 * @param request the request
	 * @return the response entity
	 */
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		GenricErrorResponse errorResponse = new GenricErrorResponse();
		errorResponse.getErrorMap().put(HttpStatus.BAD_REQUEST.name(), ex.getLocalizedMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}

	/**
	 * Handle http media type not supported.
	 *
	 * @param ex      the ex
	 * @param headers the headers
	 * @param status  the status
	 * @param request the request
	 * @return the response entity
	 */
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		GenricErrorResponse errorResponse = new GenricErrorResponse();
		errorResponse.getErrorMap().put(HttpStatus.UNSUPPORTED_MEDIA_TYPE.name(), ex.getLocalizedMessage());
		return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body(errorResponse);
	}

	/**
	 * Handle method argument not valid.
	 *
	 * @param ex      the ex
	 * @param headers the headers
	 * @param status  the status
	 * @param request the request
	 * @return the response entity
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		GenricErrorResponse errorResponse = new GenricErrorResponse();
		errorResponse.getErrorMap().put(HttpStatus.BAD_REQUEST.name(), ex.getLocalizedMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}

}
