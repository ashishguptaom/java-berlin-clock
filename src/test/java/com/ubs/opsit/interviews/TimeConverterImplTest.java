package com.ubs.opsit.interviews;

import static org.apache.commons.lang.StringUtils.EMPTY;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.verifyNew;
import static org.powermock.api.mockito.PowerMockito.whenNew;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.ubs.opsit.interviews.clock.BerlinClock;
import com.ubs.opsit.interviews.clock.exception.InvalidTimeException;

@RunWith(PowerMockRunner.class)
@PrepareForTest(TimeConverterImpl.class)
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
	public void testConvertTimeWithValidTime() throws Exception {
		String time = "O\r\nRROO\r\nRRRO\r\nYYROOOOOOOO\r\nYYOO";
		BerlinClock mockedBerlinClock = mock(BerlinClock.class);

		whenNew(BerlinClock.class).withArguments(13, 17, 01).thenReturn(mockedBerlinClock);
		when(mockedBerlinClock.getTime()).thenReturn(time);

		assertEquals(time, timeConverterImpl.convertTime("13:17:01"));
		verify(mockedBerlinClock).getTime();
		verifyNew(BerlinClock.class).withArguments(13, 17, 01);
	}
}
