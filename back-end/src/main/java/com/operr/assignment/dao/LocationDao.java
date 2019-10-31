/*
 * @author 	:		agarw
 * @Date	:	 	31-Oct-2019
 * @Project :		places-backend
 * @Package : 		com.operr.assignment.dao
 * @Type	: 		LocationDao
 */
package com.operr.assignment.dao;

import java.util.List;

import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.operr.assignment.model.Location;

import lombok.extern.log4j.Log4j2;

// TODO: Auto-generated Javadoc
/**
 * The Class LocationDao.
 */
@Repository

/** The Constant log. */

/** The Constant log. */

/** The Constant log. */
@Log4j2
public class LocationDao extends AbstractDao<Location> {

	/**
	 * Instantiates a new location dao.
	 */
	public LocationDao() {
		super(Location.class);

	}

	/**
	 * Gets the near by locations by name.
	 *
	 * @param point  the point
	 * @param name   the name
	 * @param radius the radius
	 * @return the near by locations by name
	 */
	public List<Location> getNearByLocationsByName(Point point, String name, Double radius) {

		BasicQuery query1 = new BasicQuery(""
				+ "{point:{ $near: "
					+ "{ $geometry: "
						+ "{ type: 'Point',coordinates: ["+ point.getX()+","+ point.getY()+" ] }, "
							+ "$minDistance: 10, $maxDistance: "+radius+"}}}");

		if (!StringUtils.isEmpty(name))
			query1.addCriteria(Criteria.where("name").regex(name));
		return _mongo.find(query1, Location.class);
	}

}
