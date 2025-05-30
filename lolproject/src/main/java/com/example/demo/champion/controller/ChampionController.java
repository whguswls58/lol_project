package com.example.demo.champion.controller;

import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.champion.service.ChampionService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class ChampionController {

	@Autowired
	private ChampionService service;

	// 챔피언 정보 DB에 추가
	@RequestMapping("championUpdate")
	public String championUpdate() {

		// JSON파일 파싱
		try {

			// JSON 파일 경로 설정
			ClassPathResource resource = new ClassPathResource("static/champion/championFull.json");
			String path = resource.getFile().getAbsolutePath();

			// JSON 파싱
			JSONParser parser = new JSONParser();
			Reader reader = new FileReader(path);
			JSONObject jsonObject = (JSONObject) parser.parse(reader);
			JSONObject dataObject = (JSONObject) jsonObject.get("data");

			// JSON파일에서 챔피언 이름 추출
			Set<String> championName = new HashSet<String>();
			for (Object key : dataObject.keySet()) {
				if(key instanceof String) {
					championName.add((String)key);			// 안전한 캐스팅
				}
			}
			
			// 추출된 이름 배열에 저장 및 정렬(오름차순)
			String[] champ = championName.toArray(new String[0]);
			Arrays.sort(champ);
			System.out.println(champ[0]);

			// 첫 번째 챔피언 데이터 반환
			JSONObject firstChampion = (JSONObject) dataObject.get(champ[0]);

			System.out.println("key: " + firstChampion.get("key"));
			System.out.println("id: " + firstChampion.get("id"));
			System.out.println("name: " + firstChampion.get("name"));
			System.out.println("title: " + firstChampion.get("title"));
			System.out.println("tags: " + firstChampion.get("tags"));
			System.out.println("partype: " + firstChampion.get("partype"));

			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "champion/test";
	}

}
