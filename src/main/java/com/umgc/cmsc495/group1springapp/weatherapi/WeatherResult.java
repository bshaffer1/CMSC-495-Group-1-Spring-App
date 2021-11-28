package com.umgc.cmsc495.group1springapp.weatherapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Author: Brandon Shaffer
 * Date: 11/28/2021
 */
public class WeatherResult {

	private List<Result> results;

	public WeatherResult(List<Map<String, Object>> queryMap){
		results = new ArrayList<>();
		for (Map<String, Object> map : queryMap) {
			Object temperature = map.get("temperature");
			Object short_forecast = map.get("short forecast");

			ShortForecast parsedForecast = parseShortForecast(short_forecast);
			results.add(new Result(temperature, parsedForecast));
		}
	}

	private ShortForecast parseShortForecast(Object short_forecast) {
		return ShortForecast.getShortForecast((String) short_forecast);
	}

	private class Result{
		private Object temperature;
		private ShortForecast shortForecast;

		public Result(Object temperature, ShortForecast shortForecast) {
			this.temperature = temperature;
			this.shortForecast = shortForecast;
		}
	}
}
