package com.stoyanovdmitry.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Game {

	private List<Integer> players;
	private int[] grid;

	private int nextPlayer = 1; //todo change that

	public static final int[][] WIN_SETS = {
			{0, 1, 2},
			{3, 4, 5},
			{6, 7, 8},

			{0, 3, 6},
			{1, 4, 7},
			{2, 5, 8},

			{0, 4, 8},
			{2, 4, 6}
	};

	public Game() {
		grid = new int[9];
		players = new ArrayList<>();
	}

	public int[] step(int position, int player) {

		if (grid[position] == 0)
			grid[position] = player;

		checkGameOver();

		if (nextPlayer == 1 || nextPlayer == 2)
			if (player == 1)
				nextPlayer = 2;
			else if (player == 2)
				nextPlayer = 1;

		return grid;
	}

	/**
	 * If game is busy, method will return 0
	 */
	public int addPlayer() {

		int playerID = 0;

		if (players.size() < 2) {
			playerID = players.size() + 1;
			players.add(playerID);
		}

		return playerID;
	}

	public int[] checkGameOver() {

		for (int[] WIN_SET : WIN_SETS) {

			if (grid[WIN_SET[0]] == grid[WIN_SET[1]]
					&& grid[WIN_SET[1]] == grid[WIN_SET[2]]) {

				for (int WIN_ROW : WIN_SET) { //return if winning rows is empty (0)
					if (grid[WIN_ROW] == 0)
						return null;
				}

				nextPlayer = grid[WIN_SET[0]] + 2;  //if winner is player 1, than nextPlayer == 3
				return WIN_SET;
			}
		}

		return null;
	}

	public int[] getGrid() {
		return grid;
	}

	public void setGrid(int[] grid) {
		this.grid = grid;
	}

	public List<Integer> getPlayers() {
		return players;
	}

	public void setPlayers(List<Integer> players) {
		this.players = players;
	}

	public int getNextPlayer() {
		return nextPlayer;
	}

	public void setNextPlayer(int nextPlayer) {
		this.nextPlayer = nextPlayer;
	}
}
