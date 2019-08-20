package com.assignment.numbertoword.convert;

import javax.validation.constraints.NotBlank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Subhajit
 * @since Aug-2019
 * @see com.assignment.numbertoword.convert#convertNumber
 *
 */

@RestController
@Validated
@RequestMapping(path = "/convert")
public class NumberToWordResource {

	private final static Logger LOGGER = LoggerFactory.getLogger(NumberToWordResource.class);

	@Autowired
	private NumberToWordService numberToWordService;

	@RequestMapping(method = RequestMethod.GET, produces = "text/plain")
	public String convertNumber(final @RequestParam Integer number) {
		LOGGER.info("Request number : {} for conversion to string", number);
		return numberToWordService.convert(number);
	}
}
