package com.stoyanovdmitry.controller;

import com.stoyanovdmitry.util.GameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {

	private GameUtil gameUtil;

	@Autowired
	public MainController(GameUtil gameUtil) {
		this.gameUtil = gameUtil;
	}

	@RequestMapping("/")
	public String startGame() {
		String gameID = gameUtil.addNewGame();

		return "redirect:/?game=" + gameID;
	}

	@RequestMapping(value = "/set",
			method = RequestMethod.GET)
	public @ResponseBody int[] setToPosition(@RequestParam("position") int position,
	                                         @RequestParam("id") int id) {

//		game.step(position, id);

//		return game.getGrid();
		return null;
	}
}
