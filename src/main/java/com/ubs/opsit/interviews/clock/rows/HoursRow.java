package com.ubs.opsit.interviews.clock.rows;

import static com.ubs.opsit.interviews.clock.utils.ClockSignal.OFF;
import static com.ubs.opsit.interviews.clock.utils.ClockSignal.RED;
import static java.lang.String.join;
import static org.apache.commons.lang.StringUtils.EMPTY;

import java.util.ArrayList;
import java.util.List;

public class HoursRow extends ClockRow {
	private int hours;

	public HoursRow(int hours, int rowSize) {
		super(rowSize);
		this.hours = hours;
	}

	public String getLamps() {
		List<String> lamps = new ArrayList<>();

		for (int i = 0; i < this.rowSize; i++) {
			if (this.hours > i)
				lamps.add(RED.getSignal());
			else
				lamps.add(OFF.getSignal());
		}

		return join(EMPTY, lamps);
	}
}
