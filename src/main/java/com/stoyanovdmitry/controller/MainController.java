package com.stoyanovdmitry.controller;

import com.stoyanovdmitry.game.Game;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	private Game game;

	@RequestMapping("/")
	public String startGame() {
		game = new Game();

		return "game";
	}

	@RequestMapping(value = "/set",
			method = RequestMethod.GET)
	public @ResponseBody int[] setToPosition(@RequestParam("position") int position,
	                                         @RequestParam("id") int id) {

		game.step(position, id);

		return game.getGrid();
	}
}
