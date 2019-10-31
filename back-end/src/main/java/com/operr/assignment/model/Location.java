/*
 * @author 	:		agarw
 * @Date	:	 	31-Oct-2019
 * @Project :		places-backend
 * @Package : 		com.operr.assignment.model
 * @Type	: 		Location
 */
package com.operr.assignment.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class Location. Entity Class for the Location Document in the underlying
 * mongodb.
 */
@Document(collection = "location")

/**
 * Instantiates a new location.
 */

/**
 * Instantiates a new location.
 */
@Data
public class Location {

	/** The id. */
	@Id
	String id;

	/** The name. */
	@TextIndexed
	String name;

	/** The point. Hold the GeoJson Coordinates in the Mongo Collection */
	@GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
	GeoJsonPoint point;

}
