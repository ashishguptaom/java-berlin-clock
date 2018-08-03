package com.ubs.opsit.interviews.clock;

import static com.ubs.opsit.interviews.clock.utils.CommonConstants.HOURS_FIRST_ROW_SIZE;
import static com.ubs.opsit.interviews.clock.utils.CommonConstants.HOURS_SECOND_ROW_SIZE;
import static com.ubs.opsit.interviews.clock.utils.CommonConstants.MINUTES_FIRST_ROW_SIZE;
import static com.ubs.opsit.interviews.clock.utils.CommonConstants.MINUTES_SECOND_ROW_SIZE;
import static com.ubs.opsit.interviews.clock.utils.CommonConstants.SECONDS_ROW_SIZE;
import static org.apache.commons.lang.StringUtils.join;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ubs.opsit.interviews.clock.rows.ClockRow;
import com.ubs.opsit.interviews.clock.rows.HoursRow;
import com.ubs.opsit.interviews.clock.rows.MinutesRow;
import com.ubs.opsit.interviews.clock.rows.SecondsRow;

public class BerlinClock {
	private static final Logger LOG = LoggerFactory.getLogger(BerlinClock.class);
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
		clockRows.add(new SecondsRow(seconds % 2, SECONDS_ROW_SIZE));
		clockRows.add(new HoursRow(hour / 5, HOURS_FIRST_ROW_SIZE));
		clockRows.add(new HoursRow(hour % 5, HOURS_SECOND_ROW_SIZE));
		clockRows.add(new MinutesRow(minutes / 5, MINUTES_FIRST_ROW_SIZE));
		clockRows.add(new MinutesRow(minutes % 5, MINUTES_SECOND_ROW_SIZE));

		LOG.debug("Burning clock rows: {}", clockRows);
		return join(clockRows, "\r\n");
	}

}
