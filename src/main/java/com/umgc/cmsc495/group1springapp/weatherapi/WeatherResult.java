package com.umgc.cmsc495.group1springapp.weatherapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Weather result object for setting Weather object list and holding its values.
 * Author: Brandon Shaffer
 * Date: 11/28/2021
 */
public class WeatherResult {

	private List<Weather> results;

	public WeatherResult(List<Map<String, Object>> queryMap){
		results = new ArrayList<>();
		for (Map<String, Object> map : queryMap) {
			Object temperature = map.get("temperature");
			Object short_forecast = map.get("shortForecast");
			Object date = map.get("startTime");

			ShortForecast parsedForecast = parseShortForecast(short_forecast);
			results.add(new Weather(temperature, parsedForecast, (String) date));
		}
	}

	public List<Weather> getResults() {
		return results;
	}

	private ShortForecast parseShortForecast(Object short_forecast) {
		return ShortForecast.getShortForecast((String) short_forecast);
	}

}
