package com.ubs.opsit.interviews.clock.rows;

import static com.ubs.opsit.interviews.clock.utils.CommonConstants.MINUTES_FIRST_ROW_SIZE;
import static com.ubs.opsit.interviews.clock.utils.CommonConstants.MINUTES_SECOND_ROW_SIZE;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinutesRowTest {

	@Test
	public void testGetLampsForFirstMinuteRowWithAllLampsOn() {
		assertEquals("YYRYYRYYRYY", new MinutesRow(11, MINUTES_FIRST_ROW_SIZE).getLamps());
	}

	@Test
	public void testGetLampsForFirstMinuteRowWithAllLampsOff() {
		assertEquals("OOOOOOOOOOO", new MinutesRow(0, MINUTES_FIRST_ROW_SIZE).getLamps());
	}

	@Test
	public void testGetLampsForFirstMinuteRow() {
		assertEquals("YYRYYRYOOOO", new MinutesRow(7, MINUTES_FIRST_ROW_SIZE).getLamps());
	}

	@Test
	public void testGetLampsForSecondMinuteRow() {
		assertEquals("YYOO", new MinutesRow(2, MINUTES_SECOND_ROW_SIZE).getLamps());
	}

	@Test
	public void testGetLampsForSecondMinuteRowWithAllLampsOff() {
		assertEquals("OOOO", new MinutesRow(0, MINUTES_SECOND_ROW_SIZE).getLamps());
	}

	@Test
	public void testGetLampsForSecondMinuteRowWithAllLampsOn() {
		assertEquals("YYYY", new MinutesRow(4, MINUTES_SECOND_ROW_SIZE).getLamps());
	}

	@Test
	public void testToString() {
		assertEquals("YYYY", new MinutesRow(4, MINUTES_SECOND_ROW_SIZE).toString());
	}
}
