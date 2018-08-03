package com.ubs.opsit.interviews.clock.rows;

public abstract class ClockRow {
	protected int rowSize;

	public ClockRow(int rowSize) {
		this.rowSize = rowSize;
	}

	public abstract String getLamps();
	
	@Override
	public String toString() {
		return getLamps();
	}
	
	
}
