package com.example.demo.champion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.champion.dao.ChampionDAO;

@Service
public class ChampionService {
	
	@Autowired
	private ChampionDAO dao;
	
}
