package com.stoyanovdmitry.game;

import java.util.Arrays;

public class Game {

	private int[] grid;

	public Game() {
		grid = new int[9];
	}

	public int[] step(int position, int player) {

		if (grid[position] == 0)
			grid[position] = player;

		return grid;
	}

	public int[] getGrid() {
		return grid;
	}

	public void setGrid(int[] grid) {
		this.grid = grid;
	}
}
