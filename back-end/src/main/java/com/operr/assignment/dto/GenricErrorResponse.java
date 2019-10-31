/*
 * @author 	:		agarw
 * @Date	:	 	31-Oct-2019
 * @Project :		places-backend
 * @Package : 		com.operr.assignment.dto
 * @Type	: 		GenricErrorResponse
 */
package com.operr.assignment.dto;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new generic error response. A Generic Response Error Response Generated for the Error Failure
 */

/**
 * Instantiates a new genric error response.
 */
@Data
public class GenricErrorResponse {

	/** The error map. Map containing the Error details */
	Map<String, String> errorMap = new HashMap<>();

	/** The success flag, defaulted to False in case of Error Response. */
	boolean success = false;

}
