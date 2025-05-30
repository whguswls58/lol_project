package com.example.demo.champion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.champion.service.ChampionService;

@Controller
public class ChampionController {

	@Autowired
	private ChampionService service; 
	
}
