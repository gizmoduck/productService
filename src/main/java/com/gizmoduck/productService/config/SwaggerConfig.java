package com.gizmoduck.productService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(paths())
				.build();
	}

	/**
	 * only selects API matching the predicates
	 * @return
	 */
	private Predicate<String> paths() {
		//MAtch all path except /error
		return Predicates.and(
				PathSelectors.regex("/.*"),
				Predicates.not(PathSelectors.regex("/error.*")));
	}

	/**
	 * describe API using ApiInfoBuilder
	 * @return
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Swagger documentation")
				.description("Learning swagger for product service api documentation")
				.version("1.0-SNAPSHOT")
				.build();
	}
}
