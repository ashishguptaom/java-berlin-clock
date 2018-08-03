package com.ubs.opsit.interviews;

import static org.apache.commons.lang.StringUtils.EMPTY;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.ubs.opsit.interviews.clock.exception.InvalidTimeException;

public class TimeConverterImplTest {
	private TimeConverterImpl timeConverterImpl;

	@Before
	public void setUp() {
		timeConverterImpl = new TimeConverterImpl();
	}

	@Test(expected = InvalidTimeException.class)
	public void testConvertTimeWithNullInput() {
		timeConverterImpl.convertTime(null);
	}

	@Test(expected = InvalidTimeException.class)
	public void testConvertTimeWithEmptyInput() {
		timeConverterImpl.convertTime(EMPTY);
	}

	@Test(expected = InvalidTimeException.class)
	public void testConvertTimeWithAlphanumericInput() {
		timeConverterImpl.convertTime("0a:0b:ff");
	}

	@Test(expected = InvalidTimeException.class)
	public void testConvertTimeWithInvalidHour() {
		timeConverterImpl.convertTime("25:59:59");
	}

	@Test(expected = InvalidTimeException.class)
	public void testConvertTimeWithInvalidMinutes() {
		timeConverterImpl.convertTime("24:61:59");
	}

	@Test(expected = InvalidTimeException.class)
	public void testConvertTimeWithInvalidSeconds() {
		timeConverterImpl.convertTime("24:59:68");
	}

	@Test
	public void testConvertTimeWithValidTime() {
		assertEquals("O\r\nRROO\r\nRRRO\r\nYYROOOOOOOO\r\nYYOO", timeConverterImpl.convertTime("13:17:01"));
	}
}
