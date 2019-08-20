package com.assignment.numbertoword.convert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Subhajit
 * @since Aug-2019
 * @see com.assignment.numbertoword.convert#convert
 *
 */
@Component
public class NumberToWordService implements IConvert {

	private final static Logger LOGGER = LoggerFactory.getLogger(NumberToWordService.class);

	String unitsArray[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
			"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
	String tensArray[] = { "zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty",
			"ninety" };

	@Override
	public String convert(final Integer number) {
		Integer numberForConversion = number;
		StringBuilder words = new StringBuilder();
		if (numberForConversion == 0) {
			LOGGER.info("Number is zero");
			return words.append("zero").toString();
		}

		if (numberForConversion < 0) { // convert the number to a string
			String numberStr = "" + numberForConversion;
			// remove minus before the number
			numberStr = numberStr.substring(1);
			// add minus before the number and convert the rest of number
			words.append("minus ");
			return words.append(convert(Integer.parseInt(numberStr))).toString();
		}

		// if number is divisible by million
		if ((numberForConversion / 1000000) > 0) {
			words.append(convert(numberForConversion / 1000000) + " million ");
			numberForConversion %= 1000000;
		}

		// if number is divisible by thousand
		if ((numberForConversion / 1000) > 0) {
			words.append(convert(numberForConversion / 1000) + " thousand ");
			numberForConversion %= 1000;
		}

		//  if number is divisible by hundred
		if ((numberForConversion / 100) > 0) {
			words.append(convert(numberForConversion / 100) + " hundred and ");
			numberForConversion %= 100;
		}
		if (numberForConversion > 0) {
			//  if number is within teens
			if (numberForConversion < 20) {
				words.append(unitsArray[numberForConversion]);
			} else {
				words.append(tensArray[numberForConversion / 10]);
				if ((numberForConversion % 10) > 0) {
					words.append(" " + unitsArray[numberForConversion % 10]);
				}
			}
		}
		return words.toString();
	}
}
