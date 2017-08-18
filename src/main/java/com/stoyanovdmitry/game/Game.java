package com.stoyanovdmitry.game;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private List<Integer> players;
	private int[] grid;

	private int lastPlayer;

	public Game() {
		grid = new int[9];
		players = new ArrayList<>();
	}

	public int[] step(int position, int player) {

		if (grid[position] == 0)
			grid[position] = player;

		lastPlayer = player;
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

	public int getLastPlayer() {
		return lastPlayer;
	}

	public void setLastPlayer(int lastPlayer) {
		this.lastPlayer = lastPlayer;
	}
}
