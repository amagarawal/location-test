/*
 * @author 	:		agarw
 * @Date	:	 	31-Oct-2019
 * @Project :		places-backend
 * @Package : 		com.operr.assignment.services
 * @Type	: 		LocationService
 */
package com.operr.assignment.services;

import java.util.List;

import org.springframework.data.geo.Metrics;

import com.operr.assignment.dto.LocationDto;

// TODO: Auto-generated Javadoc
/**
 * The Interface LocationService.
 */
public interface LocationService {

	/**
	 * Adds the.
	 *
	 * @param dto the dto
	 * @return the location dto
	 * @throws Exception the exception
	 */
	LocationDto add(LocationDto dto) throws Exception;

	/**
	 * Delete location.
	 *
	 * @param id the id
	 * @throws Exception the exception
	 */
	void deleteLocation(String id) throws Exception;

	/**
	 * Gets the all location.
	 *
	 * @return the all location
	 * @throws Exception the exception
	 */
	List<LocationDto> getAllLocation() throws Exception;

	/**
	 * Gets the by id.
	 *
	 * @param id the id
	 * @return the by id
	 * @throws Exception the exception
	 */
	LocationDto getById(String id) throws Exception;

	/**
	 * Gets the near by locations.
	 *
	 * @param name      the name
	 * @param latitude  the latitude
	 * @param longitude the longitude
	 * @param radius    the radius
	 * @param metrics   the metrics
	 * @return the near by locations
	 * @throws Exception the exception
	 */
	List<LocationDto> getNearByLocations(String name, Double latitude, Double longitude, Double radius, Metrics metrics)
			throws Exception;

	/**
	 * Update location.
	 *
	 * @param id  the id
	 * @param dto the dto
	 * @return the location dto
	 * @throws Exception the exception
	 */
	LocationDto updateLocation(String id, LocationDto dto) throws Exception;

}
