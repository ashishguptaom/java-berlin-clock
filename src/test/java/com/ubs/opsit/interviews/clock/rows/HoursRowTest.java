package com.ubs.opsit.interviews.clock.rows;

import static com.ubs.opsit.interviews.clock.utils.CommonConstants.HOURS_FIRST_ROW_SIZE;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HoursRowTest {

	@Test
	public void testGetLampsForAllLampsOff() {
		assertEquals("OOOO", new HoursRow(0, HOURS_FIRST_ROW_SIZE).getLamps());
	}

	@Test
	public void testGetLampsForAllLampsOn() {
		assertEquals("RRRR", new HoursRow(4, HOURS_FIRST_ROW_SIZE).getLamps());
	}

	@Test
	public void testGetLamps() {
		assertEquals("RROO", new HoursRow(2, HOURS_FIRST_ROW_SIZE).getLamps());
	}

	@Test
	public void testToString() {
		assertEquals("RROO", new HoursRow(2, HOURS_FIRST_ROW_SIZE).toString());
	}
}
