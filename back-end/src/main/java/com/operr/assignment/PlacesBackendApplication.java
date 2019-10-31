/*
 * @author 	:		agarw
 * @Date	:	 	31-Oct-2019
 * @Project :		places-backend
 * @Package : 		com.operr.assignment
 * @Type	: 		PlacesBackendApplication
 */

package com.operr.assignment;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

// TODO: Auto-generated Javadoc
/**
 * The Class PlacesBackendApplication.The Spring Runner Application Class.
 */
@SpringBootApplication
public class PlacesBackendApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(PlacesBackendApplication.class, args);
	}

	/**
	 * Model mapper.
	 *
	 * @return the model mapper
	 */
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
