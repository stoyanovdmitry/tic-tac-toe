package com.stoyanovdmitry.response;

public class CheckGameOverResponse implements Response {

	private int[] winningRow;

	public CheckGameOverResponse(int[] winningRow) {
		this.winningRow = winningRow;
	}

	public int[] getWinningRow() {
		return winningRow;
	}

	public void setWinningRow(int[] winningRow) {
		this.winningRow = winningRow;
	}
}
