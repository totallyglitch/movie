package com.mywebsite.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtil {
	
	public static JSONObject getJsonObject(String jsonString){
		JSONParser parser = new JSONParser();
		JSONObject result = null;
		try{
			result = (JSONObject)parser.parse(jsonString);
		}catch(ParseException e){
			e.printStackTrace();
		}
		return result;
	}
	
	public static JSONArray getJsonArray(String jsonString){
		JSONParser parser = new JSONParser();
		JSONArray result = null;
		try{
			result = (JSONArray)parser.parse(jsonString);
		}catch(ParseException e){
			e.printStackTrace();
		}
		return result;
	}
	
	

}
