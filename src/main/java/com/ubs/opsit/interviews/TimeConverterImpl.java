package com.ubs.opsit.interviews;

import static java.lang.Integer.parseInt;
import static org.apache.commons.lang.StringUtils.isEmpty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ubs.opsit.interviews.clock.BerlinClock;
import com.ubs.opsit.interviews.clock.exception.InvalidTimeException;

public class TimeConverterImpl implements TimeConverter {
	private static final Logger LOG = LoggerFactory.getLogger(TimeConverterImpl.class);

	public String convertTime(String aTime) {
		LOG.info("Received Input time : {}", aTime);
		if (isEmpty(aTime))
			throw new InvalidTimeException("Invalid Input: Blank or null values not allowed");

		String[] timeElements = aTime.split(":");

		if (timeElements.length != 3)
			throw new InvalidTimeException("Invalid Input: Provide input in form of HH:MM:SS");

		BerlinClock berlinClock = null;
		String berlinTime = null;
		try {
			Integer hour = parseInt(timeElements[0]);
			Integer minutes = parseInt(timeElements[1]);
			Integer seconds = parseInt(timeElements[2]);
			LOG.debug("Received Hour: {}, Minutes: {}, Seconds:{}", hour, seconds, minutes);

			if (hour > 24 || hour < 0 || minutes > 59 || minutes < 0 || seconds > 59 || seconds < 0)
				throw new InvalidTimeException("Invalid Input: Provide valid hour/minutes/seconds");

			berlinClock = new BerlinClock(hour, minutes, seconds);
			berlinTime = berlinClock.getTime();
		} catch (NumberFormatException e) {
			throw new InvalidTimeException("Invalid Input: Only Numeric values allowed");
		}

		LOG.info("{} Time converted using Berlin clock successfully : {}", aTime, berlinTime);
		return berlinTime;
	}

}
