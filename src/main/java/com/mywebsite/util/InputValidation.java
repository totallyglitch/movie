package com.mywebsite.util;

import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import com.mywebsite.exception.InvalidInputException;

public class InputValidation {
	public static float getFloatValue(String paramName, HttpServletRequest request) throws InvalidInputException{
		String paramValue = getString(paramName,request);
		
		if(!paramValue.matches("^([+-]?\\d*\\.?\\d*)$"))
			throw new InvalidInputException("Inavlid input value of parameter "+paramName.toUpperCase()+": "+paramValue);
		
		return Float.parseFloat(paramValue);
	}
	
	public static float getFloatValue(String value) throws InvalidInputException{
		String paramValue = value;
		
		if(!paramValue.matches("^([+-]?\\d*\\.?\\d*)$"))
			throw new InvalidInputException("Inavlid input value of parameter "+value.toUpperCase()+": "+paramValue);
		
		return Float.parseFloat(paramValue);
	}
	
	public static int getIntValue(String paramName, HttpServletRequest request) throws InvalidInputException{
		String paramValue = getString(paramName,request);
		
		if(paramValue==null || !paramValue.matches("^\\d+$"))
			throw new InvalidInputException("Inavlid input value of parameter "+paramName.toUpperCase()+": "+paramValue);
		
		return Integer.parseInt(paramValue);
	}
	
	
	public static String getEmail(String paramName, HttpServletRequest request) throws InvalidInputException{
		String paramValue = getString(paramName,request);
		
		if(!Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$").matcher(paramValue).matches())
			throw new InvalidInputException("Inavlid Email format: "+paramValue);
		
		return paramValue;
	}
	public static String getEmail(String paramValue) throws InvalidInputException{
		
		if(!Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$").matcher(paramValue).matches())
			throw new InvalidInputException("Inavlid Email format: "+paramValue);
		
		return paramValue;
	}
	
	public static String getDigitString(String paramName, int length, HttpServletRequest request) throws InvalidInputException{
		String paramValue = getString(paramName,request);
		
		if(!paramValue.matches("^\\d{"+length+"}$"))
			throw new InvalidInputException("Inavlid input value of parameter "+paramName.toUpperCase()+": "+paramValue);
		
		return paramValue;
	}
	public static String getDigitString(String paramValue, int length) throws InvalidInputException{
		
		if(!paramValue.matches("^\\d{"+length+"}$"))
			throw new InvalidInputException("Inavlid input value of parameter "+paramValue.toUpperCase()+": "+paramValue);
		
		return paramValue;
	}
	
	public static String getMobilePhoneNumber(String paramName, HttpServletRequest request) throws InvalidInputException{
		String paramValue = getString(paramName,request);
		
		if(!paramValue.matches("^\\d{10}$"))
			throw new InvalidInputException("Inavlid Phone Number format: "+paramValue);
		
		return paramValue;
	}
	
	public static String getMobilePhoneNumber(String paramValue) throws InvalidInputException{
		
		if(!paramValue.matches("^\\d{10}$"))
			throw new InvalidInputException("Inavlid Phone Number format: "+paramValue);
		
		return paramValue;
	}
	
	public static String getMobilePhoneNumberOrEmail(String paramName, HttpServletRequest request) throws InvalidInputException{
		String paramValue = getString(paramName,request);
		if(paramValue.matches("^\\d{10}$")){
			paramValue = "Phone:"+paramValue;
		}else if(Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$").matcher(paramValue).matches()){
			paramValue = "Email:"+paramValue;
		}else{
			throw new InvalidInputException("Inavlid Phone Number OR Email Format: "+paramValue);
		}
		return paramValue;
	}
	
	public static String getMobilePhoneNumberOrEmail(String paramValue) throws InvalidInputException{
		if(paramValue.matches("^\\d{10}$")){
			paramValue = "Phone:"+paramValue;
		}else if(Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$").matcher(paramValue).matches()){
			paramValue = "Email:"+paramValue;
		}else{
			throw new InvalidInputException("Inavlid Phone Number OR Email Format: "+paramValue);
		}
		return paramValue;
	}
	
	
	public static String getOTPCode(String paramName, HttpServletRequest request) throws InvalidInputException{
		String paramValue = getString(paramName,request);
		
		if(!paramValue.matches("^\\d{6}$"))
			throw new InvalidInputException("Inavlid Phone Number format: "+paramValue);
		
		return paramValue;
	}
	
	public static String getString(String paramName, HttpServletRequest request) throws InvalidInputException{
    	if(request.getParameter(paramName)==null || request.getParameter(paramName).trim().equals("")){
    		throw new InvalidInputException("Empty parameter: "+paramName.toUpperCase());
    	}else{
    		return request.getParameter(paramName);
    	}
    }
	
	public static String getString(String value) throws InvalidInputException{
    	if(value==null ){
    		throw new InvalidInputException("Empty parameter: null");
    	}
    	else if(value.trim().equals("")){
    		return "";
    	} 
    	else{
    		return value;
    	}
    }
	
	public static String getString(String paramName, UriInfo info) throws InvalidInputException{
    	if(info.getQueryParameters().getFirst(paramName)==null || info.getQueryParameters().getFirst(paramName).trim().equals("")){
    		throw new InvalidInputException("Empty parameter: "+paramName.toUpperCase());
    	}else{
    		return info.getQueryParameters().getFirst(paramName);
    	}
    }
	
	public static String getString(String paramName, MultivaluedMap<String, String> map) throws InvalidInputException{
    	if(map.getFirst(paramName)==null || map.getFirst(paramName).trim().equals("")){
    		throw new InvalidInputException("Empty parameter: "+paramName.toUpperCase());
    	}else{
    		return map.getFirst(paramName);
    	}
    }
	
	public static int getIntValue(String paramName, UriInfo info) throws InvalidInputException{
		String paramValue = info.getQueryParameters().getFirst(paramName);
		
		if(paramValue==null || !paramValue.matches("^\\d+$"))
			throw new InvalidInputException("Inavlid input value of parameter "+paramName.toUpperCase()+": "+paramValue);
		
		return Integer.parseInt(paramValue);
    }
	
	public static int getIntValue(String paramValue) throws InvalidInputException{
			if(paramValue==null || !paramValue.matches("^\\d+$"))
			throw new InvalidInputException("Inavlid input value of parameter "+paramValue.toUpperCase()+": "+paramValue);
		
		return Integer.parseInt(paramValue);
    }
	
	public static int getIntValue(String paramName, MultivaluedMap<String, String> map) throws InvalidInputException{
		String paramValue = map.getFirst(paramName);
		
		if(paramValue==null || !paramValue.matches("^\\d+$"))
			throw new InvalidInputException("Inavlid input value of parameter "+paramName.toUpperCase()+": "+paramValue);
		
		return Integer.parseInt(paramValue);
    }
	
	
	
	public static double getDoubleValue(String paramName, MultivaluedMap<String, String> map) throws InvalidInputException{
		String paramValue = map.getFirst(paramName);
		String regexDouble = "^-?\\d*\\.\\d+$|^-?\\d+$";
		if(paramValue==null || !paramValue.matches(regexDouble))
			throw new InvalidInputException("Inavlid input value of parameter "+paramName.toUpperCase()+": "+paramValue);
		
		return Double.parseDouble(paramValue);
    }
	
	public static String getPassword(String paramName, HttpServletRequest request) throws InvalidInputException{
		String paramValue = getString(paramName,request).trim();
		if(paramValue==null || paramValue.equals("")){
    		throw new InvalidInputException("Empty password");
    	}else if(!paramValue.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,30}$")){
    		throw new InvalidInputException("Invalid password");
    	}
		return paramValue;
    }
	
	public static String getPassword(String paramValue) throws InvalidInputException{
		paramValue = paramValue.trim();
		if(paramValue==null || paramValue.equals("")){
    		throw new InvalidInputException("Empty password");
    	}else if(!paramValue.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,30}$")){
    		throw new InvalidInputException("Invalid password");
    	}
		return paramValue;
    }
}
