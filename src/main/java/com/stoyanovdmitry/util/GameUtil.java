package com.stoyanovdmitry.util;

import com.stoyanovdmitry.game.Game;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.util.Map;

public class GameUtil {

	@Resource
	private Map<String, Game> games;

	@SuppressWarnings("deprecation")
	public String addNewGame() {

		String gameID = RandomStringUtils.randomAlphanumeric(5);

		games.put(gameID, new Game());

		return gameID;
	}

	public String findGame() {

		for (Map.Entry<String, Game> entry : games.entrySet()) {
			if (entry.getValue().isEmpty())
				return entry.getKey();
		}
		return null;
	}

	public void addPlayerLeft(String gameID) {

		getGameById(gameID).incrementPlayersLeft();
	}

	//every minute
	@Scheduled(fixedDelay = 60000L)
	public void clearClosedGames() {

		for (Map.Entry<String, Game> entry : games.entrySet()) {
			if (entry.getValue().getPlayersLeft() == 2)
				games.remove(entry.getKey());
		}
	}

	public int addPlayerToGame(String gameID) {
		return getGameById(gameID).addPlayer();
	}

	public int[] stepGameById(String gameID, int pos, int playerID) {
		return getGameById(gameID).step(pos, playerID);
	}

	public Game getGameById(String gameID) {
		return games.get(gameID);
	}

	public Map<String, Game> getGames() {
		return games;
	}

	public void setGames(Map<String, Game> games) {
		this.games = games;
	}
}
