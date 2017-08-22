package com.stoyanovdmitry.controller;

import com.stoyanovdmitry.util.GameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class MainController {

	@Autowired
	private GameUtil gameUtil;

	@RequestMapping("/")
	public String getHomePage() {
		return "home";
	}

	@RequestMapping("/start")
	public String startGame() {
		String gameID = gameUtil.addNewGame();
		return "redirect:/game/" + gameID;
	}

	@RequestMapping("/find")
	public String findGame() {

		String gameID = gameUtil.findGame();

		if (gameID == null)
			return "redirect:/?gameNotFound";

		return "redirect:/game/" + gameID;
	}
}
