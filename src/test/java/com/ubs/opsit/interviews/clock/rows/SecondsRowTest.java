package com.ubs.opsit.interviews.clock.rows;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SecondsRowTest {

	@Test
	public void testGetLampsForOffSignal() {
		assertEquals("Y", new SecondsRow(0, 1).getLamps());
	}

	@Test
	public void testGetLampsForOnSignal() {
		assertEquals("O", new SecondsRow(1, 1).getLamps());
	}
	
	@Test
	public void testToString() {
		assertEquals("O", new SecondsRow(1, 1).toString());
	}
}
