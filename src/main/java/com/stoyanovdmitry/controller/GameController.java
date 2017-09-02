package com.stoyanovdmitry.controller;

import com.stoyanovdmitry.game.Game;
import com.stoyanovdmitry.response.CheckGameResponse;
import com.stoyanovdmitry.response.CheckGameOverResponse;
import com.stoyanovdmitry.util.GameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/game/{gameID}")
public class GameController {

	@Autowired
	private GameUtil gameUtil;

	@RequestMapping
	public String gameController(@PathVariable String gameID) {
		if (gameUtil.getGameById(gameID) == null)
			return "redirect:/?gameNotFound";
		return "game";
	}

	@RequestMapping(params = "addPlayer",
			method = RequestMethod.GET)
	public @ResponseBody int registerPlayerInGame(@PathVariable String gameID) {

		return gameUtil.addPlayerToGame(gameID);
	}

	@RequestMapping(params = "playerLeft",
			method = RequestMethod.GET)
	public @ResponseBody void playerLeft(@PathVariable String gameID) {

		gameUtil.addPlayerLeft(gameID);
	}

	@RequestMapping(value = "/set",
			method = RequestMethod.GET)
	public @ResponseBody int[] setToPosition(@PathVariable String gameID,
	                                         @RequestParam int position,
	                                         @RequestParam("id") int playerID) {

		return gameUtil.stepGameById(gameID, position, playerID);
	}

	@RequestMapping(params = "checkGame",
			method = RequestMethod.GET)
	public @ResponseBody CheckGameResponse checkGame(@PathVariable String gameID) {

		Game game = gameUtil.getGameById(gameID);
		int playerStep = game.getNextPlayer();
		int[] grid = game.getGrid();

		return new CheckGameResponse(playerStep, grid);
	}

	@RequestMapping(params = "checkGameOver",
			method = RequestMethod.GET)
	public @ResponseBody CheckGameOverResponse checkGameOver(@PathVariable String gameID) {

		Game game = gameUtil.getGameById(gameID);
		int[] winningRow = game.checkGameOver();

		return new CheckGameOverResponse(winningRow);
	}
}
