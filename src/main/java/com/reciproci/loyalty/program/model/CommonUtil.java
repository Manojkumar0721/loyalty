package com.reciproci.loyalty.program.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class CommonUtil {
	public static Map<String, Object> getSuccessMessage() {

		Map<String, Object> json = new LinkedHashMap<>();

		try {
			json.put("TimeStamp",  LocalDateTime.now());
			json.put("Message", "success");
		} catch (Exception e) {
		}
		return json;
	}
	
	public static Map<String, Object> getInternalServerError() {

		Map<String, Object> json = new LinkedHashMap<>();

		try {
			json.put("TimeStamp", new Date());
			json.put("Message", "failure");
		} catch (Exception e) {
		}
		return json;
	}
}
