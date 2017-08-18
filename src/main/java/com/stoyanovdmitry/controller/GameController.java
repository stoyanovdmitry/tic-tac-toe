package com.stoyanovdmitry.controller;

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
	public String gameController() {
		return "game";
	}

	@RequestMapping(params = "addPlayer",
			method = RequestMethod.GET)
	public @ResponseBody int registerPlayerInGame(@PathVariable String gameID) {

		return gameUtil.addPlayerToGame(gameID);
	}

	@RequestMapping(value = "/set",
			method = RequestMethod.GET)
	public @ResponseBody int[] setToPosition(@PathVariable String gameID,
	                                         @RequestParam int position,
	                                         @RequestParam("id") int playerID) {

		return gameUtil.stepGameById(gameID, position, playerID);
	}
}
