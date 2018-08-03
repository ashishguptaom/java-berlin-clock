package com.ubs.opsit.interviews.clock.rows;

import static com.ubs.opsit.interviews.clock.utils.ClockSignal.OFF;
import static com.ubs.opsit.interviews.clock.utils.ClockSignal.YELLOW;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecondsRow extends ClockRow {
	private static final Logger LOG = LoggerFactory.getLogger(SecondsRow.class);
	private int seconds;

	public SecondsRow(int seconds, int rowSize) {
		super(rowSize);
		this.seconds = seconds;
	}

	public String getLamps() {
		String lamp = null;
		if (seconds == 0)
			lamp = YELLOW.getSignal();
		else
			lamp = OFF.getSignal();

		LOG.debug("Seconds Row Lamp:{}", lamp);
		return lamp;
	}

}
