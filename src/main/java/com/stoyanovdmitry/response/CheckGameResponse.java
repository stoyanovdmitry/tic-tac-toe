package com.stoyanovdmitry.response;

public class CheckGameResponse implements Response {

	private int playerStep;
	private int[] grid;

	public CheckGameResponse(int playerStep, int[] grid) {
		this.playerStep = playerStep;
		this.grid = grid;
	}

	public int getPlayerStep() {
		return playerStep;
	}

	public void setPlayerStep(int playerStep) {
		this.playerStep = playerStep;
	}

	public int[] getGrid() {
		return grid;
	}

	public void setGrid(int[] grid) {
		this.grid = grid;
	}
}
