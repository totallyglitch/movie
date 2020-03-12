package com.mywebsite.util;

import org.json.simple.JSONObject;

import com.mywebsite.exception.UnavailableParameterException;

public class InputVerification {
	
	public static String get(String parameter, JSONObject jsonObject) throws UnavailableParameterException{
		if (jsonObject.get(parameter) == null){
			throw new UnavailableParameterException("Parameter not found : "+parameter);
		}else{
			return jsonObject.get(parameter).toString();
		}
	}

}
