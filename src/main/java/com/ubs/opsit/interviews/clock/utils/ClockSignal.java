package com.ubs.opsit.interviews.clock.utils;

public enum ClockSignal {
	RED("R"), YELLOW("Y"), OFF("O");

	private String signal;

	ClockSignal(String signal) {
		this.signal = signal;
	}

	public String getSignal() {
		return signal;
	}
}
