package com.example.demo.champion.controller;

import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.util.Arrays;
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

@RestController
public class ChampionController {

	@Autowired
	private ChampionService service;
	
	@Autowired
	private ResourceLoader resourceLoader;

	@GetMapping("/champion/test")
    public JSONObject readChampionData() throws Exception {
        // JSON 파일 경로 설정
        ClassPathResource resource = new ClassPathResource("static/champion/championFull.json");
        String path = resource.getFile().getAbsolutePath();

        // JSON 파싱
        JSONParser parser = new JSONParser();
        Reader reader = new FileReader(path);
        JSONObject jsonObject = (JSONObject) parser.parse(reader);
        JSONObject dataObject = (JSONObject) jsonObject.get("data");

        // 챔피언 이름 정렬
        Set<String> championName = dataObject.keySet();
        String[] champ = championName.toArray(new String[0]);
        Arrays.sort(champ);
        System.out.println(champ);
        
        // 첫 번째 챔피언 데이터 반환
        JSONObject firstChampion = (JSONObject) dataObject.get(champ[0]);
        
		System.out.println("key: " + firstChampion.get("key"));
		System.out.println("id: " + firstChampion.get("id"));
		System.out.println("name: " + firstChampion.get("name"));
		System.out.println("title: " + firstChampion.get("title"));
		System.out.println("tags: " + firstChampion.get("tags"));
		System.out.println("partype: " + firstChampion.get("partype"));
        
        return firstChampion;
    }
	
//	@GetMapping("/read-json")
//	public JsonNode readJson() throws Exception {
//		
//		String path = "/champion/championFull.json";
//		System.out.println(path);
//		Resource resource = resourceLoader.getResource("classpath:static"+path);
//		InputStream inputStream = resource.getInputStream();
//		
//		ObjectMapper om = new ObjectMapper();
//		
//		JsonNode jn = om.readTree(inputStream);
////		System.out.println(jn);
//		
//		JSONObject jsonObject = (JSONObject);
//		
//		return jn;
//	}
	
	// 챔피언 정보 DB에 추가
//	@RequestMapping("championUpdate")
//	public String championUpdate() {
//		
//		// JSON파일 파싱
//		try {
//
//			
//			JSONParser parser = new JSONParser();
//
//			// 파일에서 JSON 파일 읽기
//			Reader reader = new FileReader(path);
//			Object obj = parser.parse(reader);
//			
//			// 최상위 JSON 객체
//			JSONObject jsonObject = (JSONObject)obj;
//
//			// "data" 객체 접근
//			JSONObject dataObject = (JSONObject)jsonObject.get("data");
//			
//			// 챔피언 목록(오름차순 정렬)
//			Set<String> championName = dataObject.keySet(); 
//			String[] champ = championName.toArray(new String[0]);
//			Arrays.sort(champ);
//
//			System.out.println(champ[0]);
//			
//			// 챔피언 이름으로 접근 (ex : Atrox)
//			JSONObject atroxObject = (JSONObject) dataObject.get(champ[0]);
//			System.out.println("key: " + atroxObject.get("key"));
//			System.out.println("id: " + atroxObject.get("id"));
//			System.out.println("name: " + atroxObject.get("name"));
//			System.out.println("title: " + atroxObject.get("title"));
//			System.out.println("tags: " + atroxObject.get("tags"));
//			System.out.println("partype: " + atroxObject.get("partype"));
//
//			//	System.out.println(atroxObject);
//			// "skins" 배열 가져오기
//			JSONArray skinsArray = (JSONArray) atroxObject.get("skins");
//			
//			// 스킨 목록 출력
//			System.out.println("Atrox Skins:");
//			// 배열 순회
//			for(Object skinObj : skinsArray) {
//				JSONObject skin = (JSONObject)skinObj;
//				
//				String name = (String)skin.get("name");
//				
//				System.out.println("- " + name);
//			}
//			
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return "";
//	}
	
	
	
	
}
