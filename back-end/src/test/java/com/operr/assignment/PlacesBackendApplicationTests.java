/*
 * @author 	:		agarw
 * @Date	:	 	31-Oct-2019
 * @Project :		places-backend
 * @Package : 		com.operr.assignment
 * @Type	: 		PlacesBackendApplicationTests
 */
package com.operr.assignment;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.operr.assignment.controller.LocationRestController;
import com.operr.assignment.services.LocationService;

// TODO: Auto-generated Javadoc
/**
 * The Class PlacesBackendApplicationTests.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PlacesBackendApplicationTests {

	@Autowired
	MongoTemplate _mongo;

	@Autowired
	LocationService _service;

	@Autowired
	LocationRestController locationController;

	/**
	 * Context loads.
	 */
	@Test
	public void contextLoads() {

		assertThat(locationController).isNotNull();
		assertThat(_mongo).isNotNull();
		assertThat(_service).isNotNull();
	}

}
