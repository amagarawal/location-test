/*
 * @author 	:		agarw
 * @Date	:	 	31-Oct-2019
 * @Project :		places-backend
 * @Package : 		com.operr.assignment.controller
 * @Type	: 		LocationRestController
 */
package com.operr.assignment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Metrics;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.operr.assignment.dto.LocationDto;
import com.operr.assignment.services.LocationService;

import lombok.extern.log4j.Log4j2;

// TODO: Auto-generated Javadoc
/**
 * The Class LocationRestController.
 */
@RestController
@RequestMapping(value = "/location", produces = MediaType.APPLICATION_JSON_VALUE)

/** The Constant log. */

/** The Constant log. */
@Log4j2
public class LocationRestController implements LocationApi {

	/** The locaiton service. */
	@Autowired
	LocationService _locaitonService;

	/**
	 * Adds the new location.
	 *
	 * @param locationDto the location dto
	 * @return the response entity
	 * @throws Exception the exception
	 */
	@Override
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LocationDto> addNewLocation(@Valid @RequestBody LocationDto locationDto) throws Exception {

		log.info("Request Received for adding new Location {}", locationDto.toString());
		_locaitonService.add(locationDto);
		return ResponseEntity.status(HttpStatus.CREATED).header("locationId", locationDto.getId()).body(locationDto);
	}

	/**
	 * Delete locaiton.
	 *
	 * @param id the id
	 * @return the response entity
	 * @throws Exception the exception
	 */
	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteLocation(@PathVariable("id") String id) throws Exception {

		_locaitonService.deleteLocation(id);
		return ResponseEntity.accepted().build();
	}

	/**
	 * Gets the all location.
	 *
	 * @return the all location
	 * @throws Exception the exception
	 */
	@Override
	@GetMapping
	public ResponseEntity<List<LocationDto>> getAllLocation() throws Exception {

		return ResponseEntity.ok(_locaitonService.getAllLocation());
	}

	/**
	 * Gets the locationby id.
	 *
	 * @param id the id
	 * @return the location By id
	 * @throws Exception the exception
	 */
	@Override
	@GetMapping("/{id}")
	public ResponseEntity<LocationDto> getLocationById(@PathVariable("id") String id) throws Exception {

		log.info("Request Received for Search Location for id {}", id);
		LocationDto response = _locaitonService.getById(id);
		return ResponseEntity.ok(response);

	}

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
	@Override
	@GetMapping("/nearby")
	public ResponseEntity<List<LocationDto>> getLocationNearBy(@RequestParam("latitude") String latitude,
			@RequestParam("longitude") String longitude, @RequestParam("distance") Double distance,
			@RequestParam(name = "name", required = false) String name) throws Exception {

		List<LocationDto> results = _locaitonService.getNearByLocations(name, Double.valueOf(latitude),
				Double.valueOf(longitude), distance, Metrics.MILES);
		return ResponseEntity.ok(results);
	}

	/**
	 * Update location.
	 *
	 * @param id  the id
	 * @param dto the dto
	 * @return the response entity
	 * @throws Exception the exception
	 */
	@Override
	@PutMapping("/{id}")
	public ResponseEntity<LocationDto> updateLocation(@PathVariable("id") String id,
			@Valid @RequestBody(required = true) LocationDto dto) throws Exception {

		return ResponseEntity.ok(_locaitonService.updateLocation(id, dto));
	}
}
