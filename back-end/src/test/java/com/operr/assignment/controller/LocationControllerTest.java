/*
 * @author 	:		agarw
 * @Date	:	 	31-Oct-2019
 * @Project :		places-backend
 * @Package : 		com.operr.assignment.controller
 * @Type	: 		LocationControllerTest
 */
package com.operr.assignment.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.operr.assignment.PlacesBackendApplication;
import com.operr.assignment.services.LocationService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK, classes = { PlacesBackendApplication.class })
public class LocationControllerTest {

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Autowired
	private WebApplicationContext ctx;

	@MockBean
	private LocationService locationServiceMock;

	private MockMvc mockMvc;

	@Before
	public void init() {
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void shouldCreateLocationOnValidRequest() throws Exception {

	}

	@Test
	public void shouldDeleteLocation() throws Exception {

	}

	@Test
	public void shouldReturnListOfLocations() throws Exception {

	}

	@Test
	public void shouldReturnNearByLocationOnValidRequest() throws Exception {

	}

	@Test
	public void shouldUpdateLocation() throws Exception {

	}
}
