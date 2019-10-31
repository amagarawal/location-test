/*
 * @author 	:		agarw
 * @Date	:	 	31-Oct-2019
 * @Project :		places-backend
 * @Package : 		com.operr.assignment.dto
 * @Type	: 		DtoMapper
 */
package com.operr.assignment.dto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Component;

import com.operr.assignment.model.Location;

import lombok.extern.log4j.Log4j2;

// TODO: Auto-generated Javadoc
/**
 * The Class DtoMapper.
 */
@Component

/** The Constant log. */

/** The Constant log. */

/** The Constant log. */
@Log4j2
public class DtoMapper {

	/** The mapper. */
	@Autowired
	ModelMapper _mapper;

	/**
	 * Convert location dto to entity.
	 *
	 * @param dto the dto
	 * @return the location
	 * @throws NumberFormatException the number format exception
	 */
	public Location convertLocationDtoToEntity(LocationDto dto) throws NumberFormatException {
		Location entity = _mapper.map(dto, Location.class);
		try {
			entity.setPoint(new GeoJsonPoint(Double.valueOf(dto.getLatitude()), Double.valueOf(dto.getLongitude())));
		} catch (NumberFormatException e) {
			log.error("Cannot Cast Cor-doinates to GeoJson Object {} {}", dto.getLatitude(), dto.getLongitude());
			throw e;
		}

		return entity;
	}

	/**
	 * Convert location entity to dto.
	 *
	 * @param entity the entity
	 * @return the location dto
	 */
	public LocationDto convertLocationEntityToDto(Location entity) {
		LocationDto dto = _mapper.map(entity, LocationDto.class);

		dto.setLatitude(Double.toString(entity.getPoint().getX()));
		dto.setLongitude(Double.toString(entity.getPoint().getY()));

		return dto;
	}
}
