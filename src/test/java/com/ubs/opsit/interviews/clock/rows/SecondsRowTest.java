package com.ubs.opsit.interviews.clock.rows;

import static com.ubs.opsit.interviews.clock.utils.CommonConstants.SECONDS_ROW_SIZE;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SecondsRowTest {

	@Test
	public void testGetLampsForOffSignal() {
		assertEquals("Y", new SecondsRow(0, SECONDS_ROW_SIZE).getLamps());
	}

	@Test
	public void testGetLampsForOnSignal() {
		assertEquals("O", new SecondsRow(1, SECONDS_ROW_SIZE).getLamps());
	}

	@Test
	public void testToString() {
		assertEquals("O", new SecondsRow(1, SECONDS_ROW_SIZE).toString());
	}
}
