/*
 * @author 	:		agarw
 * @Date	:	 	31-Oct-2019
 * @Project :		places-backend
 * @Package : 		com.operr.assignment.controller
 * @Type	: 		LocationApi
 */
package com.operr.assignment.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.operr.assignment.dto.LocationDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

// TODO: Auto-generated Javadoc
/**
 * The Interface LocationApi.
 */
@Api(description = "Rest Endpoints For Location CRUD ", value = "Locations")
public interface LocationApi {

	/**
	 * Adds the new location.
	 *
	 * @param locationDto the location dto
	 * @return the response entity
	 * @throws Exception the exception
	 */
	@ApiOperation(notes = "Add a new Location", tags = { "Locations" }, value = "Add a new Location")
	ResponseEntity<LocationDto> addNewLocation(@ApiParam LocationDto locationDto) throws Exception;

	/**
	 * Delete locaiton.
	 *
	 * @param id the id
	 * @return the response entity
	 * @throws Exception the exception
	 */
	ResponseEntity<?> deleteLocation(String id) throws Exception;

	/**
	 * Gets the all location.
	 *
	 * @return the all location
	 * @throws Exception the exception
	 */
	@ApiOperation(notes = "Get the List of All Locations", tags = { "Locations" }, value = "Get All Location")
	ResponseEntity<List<LocationDto>> getAllLocation() throws Exception;

	/**
	 * Gets the locationby id.
	 *
	 * @param id the id
	 * @return the location By id
	 * @throws Exception the exception
	 */
	@ApiOperation(notes = "Get The Location By Id ", tags = { "Locations" }, value = "Get Location By Id")
	ResponseEntity<LocationDto> getLocationById(String id) throws Exception;

	/**
	 * Gets the location near by.
	 *
	 * @param latitude  the latitude
	 * @param longitude the longitude
	 * @param distance  the distance
	 * @param name      the name
	 * @return the location near by
	 * @throws Exception the exception
	 */
	@ApiOperation(notes = "Get nearby locaiton based on Current Location Co-ordinates and name", tags = {
			"Locations" }, value = "Get NearBy Location")
	ResponseEntity<List<LocationDto>> getLocationNearBy(String latitude, String longitude, Double distance, String name)
			throws Exception;

	/**
	 * Update location.
	 *
	 * @param id  the id
	 * @param dto the dto
	 * @return the response entity
	 * @throws Exception the exception
	 */
	ResponseEntity<LocationDto> updateLocation(String id, LocationDto dto) throws Exception;

}
