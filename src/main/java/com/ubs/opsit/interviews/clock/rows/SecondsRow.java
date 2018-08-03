package com.ubs.opsit.interviews.clock.rows;

import static com.ubs.opsit.interviews.clock.utils.ClockSignal.OFF;
import static com.ubs.opsit.interviews.clock.utils.ClockSignal.YELLOW;

public class SecondsRow extends ClockRow {
	private int seconds;

	public SecondsRow(int seconds, int rowSize) {
		super(rowSize);
		this.seconds = seconds;
	}

	public String getLamps() {
		if (seconds == 0)
			return YELLOW.getSignal();
		else
			return OFF.getSignal();
	}
}
