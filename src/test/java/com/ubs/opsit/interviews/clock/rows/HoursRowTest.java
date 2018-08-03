package com.ubs.opsit.interviews.clock.rows;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HoursRowTest {

	@Test
	public void testGetLampsForAllLampsOff() {
		assertEquals("OOOOO", new HoursRow(0, 5).getLamps());
	}

	@Test
	public void testGetLampsForAllLampsOn() {
		assertEquals("RRRRR", new HoursRow(5, 5).getLamps());
	}

	@Test
	public void testGetLamps() {
		assertEquals("RROOO", new HoursRow(2, 5).getLamps());
	}

	@Test
	public void testToString() {
		assertEquals("RROOO", new HoursRow(2, 5).toString());
	}
}
