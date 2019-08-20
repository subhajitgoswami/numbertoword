package com.assignment.numbertoword.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Subhajit
 * @since Aug-2019
 * @see com.assignment.numbertoword.config#productApi
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 *
	 * @return Docket
	 */
	@Bean
	public Docket productApi() {

		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(Predicates.not(PathSelectors.regex("/error"))).build().apiInfo(apiInfo());
	}

	/**
	 *
	 * @return ApiInfo
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("SpringBoot Number to Word").description("")
				.contact(new Contact("Developers", "https://projects.spring.io/spring-boot/", ""))
				.license("Open Source").licenseUrl("https://www.apache.org/licenses/LICENSE-2.0").version("0.0.1")
				.build();

	}

}