package com.stoyanovdmitry.game;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private List<Integer> players;
	private int[] grid;

	private int nextPlayer = 1; //todo change that

	public Game() {
		grid = new int[9];
		players = new ArrayList<>();
	}

	public int[] step(int position, int player) {

		if (grid[position] == 0)
			grid[position] = player;

		if(player == 1)
			nextPlayer = 2;
		else if(player == 2)
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
