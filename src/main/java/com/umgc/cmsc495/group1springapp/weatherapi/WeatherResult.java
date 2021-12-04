package com.umgc.cmsc495.group1springapp.weatherapi;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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

			int indexOfLastDash = StringUtils.lastIndexOf(date.toString(), "-");
			String substring = StringUtils.substring(date.toString(), 0, indexOfLastDash);

			DateTimeFormatter formatter =
					DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
			LocalDateTime localDateTime = LocalDateTime.parse(substring, formatter);

			SimpleDateFormat format = new SimpleDateFormat("EEEE, MMMM d");
			long epochS = localDateTime.toEpochSecond(ZoneOffset.UTC) * 1000;
			String dateFormatted = format.format(epochS);

			ShortForecast parsedForecast = parseShortForecast(short_forecast);
			results.add(new Weather(temperature, parsedForecast, dateFormatted));
		}
	}

	public List<Weather> getResults() {
		return results;
	}

	private ShortForecast parseShortForecast(Object short_forecast) {
		return ShortForecast.getShortForecast((String) short_forecast);
	}

}
