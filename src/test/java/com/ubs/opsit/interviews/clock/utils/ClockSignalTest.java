package com.ubs.opsit.interviews.clock.utils;

import static com.ubs.opsit.interviews.clock.utils.ClockSignal.OFF;
import static com.ubs.opsit.interviews.clock.utils.ClockSignal.RED;
import static com.ubs.opsit.interviews.clock.utils.ClockSignal.YELLOW;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ClockSignalTest {

	@Test
	public void testGetRedSignal() {
		assertEquals("R", RED.getSignal());
	}

	@Test
	public void testGetYellowSignal() {
		assertEquals("Y", YELLOW.getSignal());
	}

	@Test
	public void testGetOffSignal() {
		assertEquals("O", OFF.getSignal());
	}
}
