/*
 * @author 	:		agarw
 * @Date	:	 	31-Oct-2019
 * @Project :		places-backend
 * @Package : 		com.operr.assignment.config.web
 * @Type	: 		SwaggerConfig
 */
package com.operr.assignment.config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// TODO: Auto-generated Javadoc
/**
 * The Class SwaggerConfig. Basic Swagger Configuration For the Oper-BackEnd
 * Project.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * Api.
	 *
	 * @return the docket
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Locations").select()
				.apis(RequestHandlerSelectors.basePackage("com.operr.assignment")).paths(PathSelectors.any()).build();
	}

}
