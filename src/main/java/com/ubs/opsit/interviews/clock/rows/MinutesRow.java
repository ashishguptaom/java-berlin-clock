package com.ubs.opsit.interviews.clock.rows;

import static com.ubs.opsit.interviews.clock.utils.ClockSignal.OFF;
import static com.ubs.opsit.interviews.clock.utils.ClockSignal.RED;
import static com.ubs.opsit.interviews.clock.utils.ClockSignal.YELLOW;
import static java.lang.String.join;
import static org.apache.commons.lang.StringUtils.EMPTY;

import java.util.ArrayList;
import java.util.List;

public class MinutesRow extends ClockRow {
	private int minutes;

	public MinutesRow(int minutes, int rowSize) {
		super(rowSize);
		this.minutes = minutes;
	}

	public String getLamps() {
		List<String> lamps = new ArrayList<>();

		for (int i = 1; i <= this.rowSize; i++) {
			if (this.minutes >= i) {
				if (i % 3 == 0 && this.rowSize == 11)
					lamps.add(RED.getSignal());
				else
					lamps.add(YELLOW.getSignal());
			} else
				lamps.add(OFF.getSignal());
		}

		return join(EMPTY, lamps);
	}
}
