/*
 * @author 	:		agarw
 * @Date	:	 	31-Oct-2019
 * @Project :		places-backend
 * @Package : 		com.operr.assignment.dto
 * @Type	: 		LocationDto
 */
package com.operr.assignment.dto;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new location dto.
 */

/**
 * Instantiates a new location dto.
 */

/**
 * Instantiates a new location dto.
 */

/**
 * Instantiates a new location dto.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto {

	/** The id. */
	String id;

	/** The latitude. */
	@NotEmpty
	String latitude;

	/** The longitude. */
	@NotEmpty
	String longitude;

	/** The name. */
	String name;

}
