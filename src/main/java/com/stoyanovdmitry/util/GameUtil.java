package com.stoyanovdmitry.util;

import com.stoyanovdmitry.game.Game;
import org.apache.commons.lang3.RandomStringUtils;

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

	public int addPlayerToGame(String gameID) {
		return getGameById(gameID).addPlayer();
	}

	public int[] stepGameById(String gameID, int pos, int playerID) {
		return getGameById(gameID).step(pos, playerID);
	}

	public Game getGameById(String gameID) {
		return games.get(gameID);
	}
}
