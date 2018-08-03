package com.ubs.opsit.interviews.clock;

import static org.apache.commons.lang.StringUtils.join;

import java.util.ArrayList;
import java.util.List;

import com.ubs.opsit.interviews.clock.rows.ClockRow;
import com.ubs.opsit.interviews.clock.rows.HoursRow;
import com.ubs.opsit.interviews.clock.rows.MinutesRow;
import com.ubs.opsit.interviews.clock.rows.SecondsRow;

public class BerlinClock {
	private Integer hour;
	private Integer minutes;
	private Integer seconds;

	public BerlinClock(Integer hour, Integer minutes, Integer seconds) {
		this.hour = hour;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	public String getTime() {
		List<ClockRow> clockRows = new ArrayList<>();
		clockRows.add(new SecondsRow(seconds % 2, 1));
		clockRows.add(new HoursRow(hour / 5, 4));
		clockRows.add(new HoursRow(hour % 5, 4));
		clockRows.add(new MinutesRow(minutes / 5, 11));
		clockRows.add(new MinutesRow(minutes % 5, 4));

		return join(clockRows, "\r\n");
	}

}
