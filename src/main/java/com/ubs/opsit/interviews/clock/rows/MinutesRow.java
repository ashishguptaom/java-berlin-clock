package com.ubs.opsit.interviews.clock.rows;

import static com.ubs.opsit.interviews.clock.utils.ClockSignal.OFF;
import static com.ubs.opsit.interviews.clock.utils.ClockSignal.RED;
import static com.ubs.opsit.interviews.clock.utils.ClockSignal.YELLOW;
import static com.ubs.opsit.interviews.clock.utils.CommonConstants.MINUTES_FIRST_ROW_SIZE;
import static java.lang.String.join;
import static org.apache.commons.lang.StringUtils.EMPTY;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinutesRow extends ClockRow {
	private static final Logger LOG = LoggerFactory.getLogger(MinutesRow.class);
	private int minutes;

	public MinutesRow(int minutes, int rowSize) {
		super(rowSize);
		this.minutes = minutes;
	}

	public String getLamps() {
		List<String> lamps = new ArrayList<>();

		for (int i = 1; i <= this.rowSize; i++) {
			if (this.minutes >= i) {
				if (i % 3 == 0 && this.rowSize == MINUTES_FIRST_ROW_SIZE)
					lamps.add(RED.getSignal());
				else
					lamps.add(YELLOW.getSignal());
			} else {
				lamps.add(OFF.getSignal());
			}
		}
		LOG.debug("Minutes Row- Row size:{}, Lamps:{}", rowSize, lamps);
		return join(EMPTY, lamps);
	}
}
