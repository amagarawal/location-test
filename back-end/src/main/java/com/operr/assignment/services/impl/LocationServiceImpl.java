/*
 * @author 	:		agarw
 * @Date	:	 	31-Oct-2019
 * @Project :		places-backend
 * @Package : 		com.operr.assignment.services.impl
 * @Type	: 		LocationServiceImpl
 */
package com.operr.assignment.services.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.operr.assignment.dao.LocationDao;
import com.operr.assignment.dto.DtoMapper;
import com.operr.assignment.dto.LocationDto;
import com.operr.assignment.exceptions.AppExceptions;
import com.operr.assignment.exceptions.LocationNotFoundException;
import com.operr.assignment.model.Location;
import com.operr.assignment.services.LocationService;

import lombok.extern.log4j.Log4j2;

// TODO: Auto-generated Javadoc
/**
 * The Class LocationServiceImpl.
 */
@Service

/** The Constant log. */

/** The Constant log. */

/** The Constant log. */
@Log4j2
@Transactional
public class LocationServiceImpl implements LocationService {

	/** The location dao. */
	@Autowired
	LocationDao _locationDao;

	/** The mapper. */
	@Autowired
	DtoMapper _mapper;

	/**
	 * Adds the.
	 *
	 * @param dto the dto
	 * @return the location dto
	 * @throws AppExceptions the app exceptions
	 */
	@Override
	public LocationDto add(LocationDto dto) throws AppExceptions {
		log.debug("Starting Transaction - Insert Location {}", dto.toString());
		Location newLocation = _locationDao.insert(_mapper.convertLocationDtoToEntity(dto));
		log.info("Location Inserted Successfully - {}", newLocation.toString());
		return _mapper.convertLocationEntityToDto(newLocation);

	}

	/**
	 * Delete location.
	 *
	 * @param id the id
	 * @throws Exception the exception
	 */
	@Override
	public void deleteLocation(String id) throws Exception {

		Location locationToDelete = _locationDao.getById(id);
		if (null != locationToDelete)
			_locationDao.delete(locationToDelete);
		else
			throw new Exception();
	}

	/**
	 * Gets the all location.
	 *
	 * @return the all location
	 * @throws AppExceptions the app exceptions
	 */
	@Override
	public List<LocationDto> getAllLocation() throws AppExceptions {

		log.debug("Starting Transaction - Get All locations ");
		List<Location> locations = _locationDao.getAll();
		log.debug("Number of Locations found : {} ", locations.size());
		return locations.stream().map(location -> _mapper.convertLocationEntityToDto(location))
				.collect(Collectors.toList());
	}

	/**
	 * Gets the by id.
	 *
	 * @param id the id
	 * @return the by id
	 * @throws Exception the exception
	 */
	@Override
	public LocationDto getById(String id) throws Exception {

		log.debug("Starting Transaction - Get  Location by Id {}", id);
		Location location = _locationDao.getById(id);
		if (null != location) {
			log.debug("location Found :- {}", location.toString());
			log.debug("Transaction Completed with Success");
			return _mapper.convertLocationEntityToDto(location);

		} else {
			log.error("Unable to find location for the Given argument : {}", id);
			log.debug("Transaction Completed with Error : No Entity found for the Argument");
			throw new LocationNotFoundException();
		}
	}

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
	@Override
	public List<LocationDto> getNearByLocations(String name, Double latitude, Double longitude, Double radius,
			Metrics metrics) throws Exception {

		try {
			Point centerPoint = new Point(latitude, longitude);
			List<Location> nearByLocations = _locationDao.getNearByLocationsByName(centerPoint, name, radius);

			return nearByLocations.stream().map(location -> _mapper.convertLocationEntityToDto(location))
					.collect(Collectors.toList());
		} catch (Exception e) {

			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	/**
	 * Update location.
	 *
	 * @param id  the id
	 * @param dto the dto
	 * @return the location dto
	 * @throws AppExceptions the app exceptions
	 */
	@Override
	public LocationDto updateLocation(String id, LocationDto dto) throws AppExceptions {

		if (_locationDao.existsById(id)) {
			Location updateLocation = _locationDao.update(_mapper.convertLocationDtoToEntity(dto));
			return _mapper.convertLocationEntityToDto(updateLocation);
		} else
			throw new LocationNotFoundException();

	}

}
