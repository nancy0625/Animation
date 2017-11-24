package com.example.json.code;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonTools {

	public JsonTools() {

	}

	public static List<String> paraseList(String jsonString) {
		List<String> list = new ArrayList<String>();
		try {
			JSONObject jsonObject = new JSONObject(jsonString);
			String result_type = jsonObject.getString("serverinfo");
			jsonObject = new JSONObject(result_type);
			Iterator<String> iterator = jsonObject.keys();
			while (iterator.hasNext()) {
				String key = iterator.next();
				String value = jsonObject.getString(key);
				list.add(value); // List<String> banzuData
				// banzuDataTypeHashMap.put(value,key);
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return list;

	}

}
