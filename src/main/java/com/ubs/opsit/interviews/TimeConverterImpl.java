package com.ubs.opsit.interviews;

import static java.lang.Integer.parseInt;
import static org.apache.commons.lang.StringUtils.isEmpty;

import com.ubs.opsit.interviews.clock.BerlinClock;
import com.ubs.opsit.interviews.clock.exception.InvalidTimeException;

public class TimeConverterImpl implements TimeConverter {

	public String convertTime(String aTime) {
		if (isEmpty(aTime))
			throw new InvalidTimeException("Invalid Input: Blank or null values not allowed");

		String[] timeElements = aTime.split(":");

		if (timeElements.length != 3)
			throw new InvalidTimeException("Invalid Input: Provide input in form of HH:MM:SS");

		BerlinClock berlinClock = null;
		Integer hour, minutes, seconds = null;
		try {
			hour = parseInt(timeElements[0]);
			minutes = parseInt(timeElements[1]);
			seconds = parseInt(timeElements[2]);

			if (hour > 24 || hour < 0 || minutes > 59 || minutes < 0 || seconds > 59 || seconds < 0)
				throw new InvalidTimeException("Invalid Input: Provide valid hour/minutes/seconds");

			berlinClock = new BerlinClock(hour, minutes, seconds);
		} catch (NumberFormatException e) {
			throw new InvalidTimeException("Invalid Input: Only Numeric values allowed");
		}
		return berlinClock.getTime();
	}

}
