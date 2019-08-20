package com.assignment.numbertoword;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.assignment.numbertoword.convert.NumberToWordService;

/**
 * Unit test for number to word converter service.
 */
public class NumberToWordServiceTest {

	@InjectMocks
	private NumberToWordService numberToWordService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void convert_onedigitnumber() {
		assertEquals("one", numberToWordService.convert(1));
	}

	@Test
	public void convert_twodigitnumber() {
		assertEquals("twenty three", numberToWordService.convert(23));
	}

	@Test
	public void convert_threedigitnumber() {
		assertEquals("one hundred and five", numberToWordService.convert(105));
	}
	
	@Test
	public void convert_eightdigitnumber() {
		assertEquals("fifty six million nine hundred and forty five thousand seven hundred and eighty one", numberToWordService.convert(56945781));
	}
	
	@Test
	public void convert_lessthanzeronumber() {
		assertEquals("minus two", numberToWordService.convert(-2));
	}
}
