package com.ubs.opsit.interviews.clock;

import static org.apache.commons.lang.StringUtils.countMatches;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.powermock.api.mockito.PowerMockito.whenNew;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.ubs.opsit.interviews.clock.rows.HoursRow;
import com.ubs.opsit.interviews.clock.rows.MinutesRow;
import com.ubs.opsit.interviews.clock.rows.SecondsRow;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ BerlinClockTest.class, SecondsRow.class, HoursRow.class, MinutesRow.class })
public class BerlinClockTest {

	@Test
	public void testGetTime() throws Exception {
		BerlinClock berlinClock = new BerlinClock(13, 17, 01);

		SecondsRow mockedSecondsRow = mock(SecondsRow.class);
		HoursRow mockedFirstHourRow = mock(HoursRow.class);
		HoursRow mockedSecondHourRow = mock(HoursRow.class);
		MinutesRow mockedFirstMinutesRow = mock(MinutesRow.class);
		MinutesRow mockedSecondMinutesRow = mock(MinutesRow.class);

		whenNew(SecondsRow.class).withArguments(1, 1).thenReturn(mockedSecondsRow);
		whenNew(HoursRow.class).withArguments(2, 4).thenReturn(mockedFirstHourRow);
		whenNew(HoursRow.class).withArguments(3, 4).thenReturn(mockedSecondHourRow);
		whenNew(MinutesRow.class).withArguments(3, 11).thenReturn(mockedFirstMinutesRow);
		whenNew(MinutesRow.class).withArguments(2, 4).thenReturn(mockedSecondMinutesRow);

		String time = berlinClock.getTime();
		assertEquals(4, countMatches(time, "\r\n"));
	}

}
