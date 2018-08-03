package com.ubs.opsit.interviews.clock.rows;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinutesRowTest {

	@Test
	public void testGetLampsForFirstMinuteRowWithAllLampsOn() {
		assertEquals("YYRYYRYYRYY", new MinutesRow(11, 11).getLamps());
	}

	@Test
	public void testGetLampsForFirstMinuteRowWithAllLampsOff() {
		assertEquals("OOOOOOOOOOO", new MinutesRow(0, 11).getLamps());
	}

	@Test
	public void testGetLampsForFirstMinuteRow() {
		assertEquals("YYRYYRYOOOO", new MinutesRow(7, 11).getLamps());
	}

	@Test
	public void testGetLampsForSecondMinuteRow() {
		assertEquals("YYOOO", new MinutesRow(2, 5).getLamps());
	}

	@Test
	public void testGetLampsForSecondMinuteRowWithAllLampsOff() {
		assertEquals("OOOOO", new MinutesRow(0, 5).getLamps());
	}

	@Test
	public void testGetLampsForSecondMinuteRowWithAllLampsOn() {
		assertEquals("YYYYY", new MinutesRow(5, 5).getLamps());
	}
	
	@Test
	public void testToString() {
		assertEquals("YYYYY", new MinutesRow(5, 5).toString());
	}
}
