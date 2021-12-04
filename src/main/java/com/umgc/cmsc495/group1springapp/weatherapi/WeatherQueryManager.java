package com.umgc.cmsc495.group1springapp.weatherapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.umgc.cmsc495.group1springapp.weatherapi.pojos.InitialQueryPojo;
import com.umgc.cmsc495.group1springapp.weatherapi.pojos.SecondQueryPojo;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Manager for handling weather query operations.
 * Author: Brandon Shaffer
 * Date: 11/18/2021
 */
public class WeatherQueryManager {

	private LatLong latLong;
	private int numDays;

	public WeatherQueryManager(String zip, int numDays) {
		setLatLongFromZip(zip);
		this.numDays = numDays;
	}

	public void setLatLongFromZip(String zip) {
		LatLong latLong = new LatLong(zip);
		if(latLong == null || latLong.getLatitude() == null || latLong.getLongitude() == null){
			this.latLong = null;
		}
		this.latLong = latLong;
	}

	public WeatherResult queryWeather() {
		String latitude = latLong.getLatitude();
		String longitude = latLong.getLongitude();

		try {
			return getWeatherResult(latitude, longitude);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return null;
	}

	private WeatherResult getWeatherResult(String latitude, String longitude) throws JsonProcessingException {
		Response response = ClientBuilder.newClient()
				.target("https://api.weather.gov")
				.path("points/" + latitude + "," + longitude)
				.request(MediaType.APPLICATION_JSON)
				.get();

		String string = response.readEntity(String.class);
		ObjectMapper objectMapper = new ObjectMapper();
		InitialQueryPojo initialQueryPojo = objectMapper.readValue(string, InitialQueryPojo.class);

		Map<String, Object> additionalProperties = initialQueryPojo.getAdditionalProperties();
		Object properties = additionalProperties.get("properties");
		Map<String, Object> initialQueryMap = objectMapper.convertValue(properties, Map.class);

		Object forecast = initialQueryMap.get("forecast");

		Response secondResponse = ClientBuilder.newClient()
				.target(forecast.toString())
				.request(MediaType.APPLICATION_JSON)
				.get();

		String secondString = secondResponse.readEntity(String.class);
		SecondQueryPojo secondQueryPojo = objectMapper.readValue(secondString, SecondQueryPojo.class);

		Map<String, Object> secondQueryAdditionalProperties = secondQueryPojo.getAdditionalProperties();

		Object secondProperties = secondQueryAdditionalProperties.get("properties");

		Map<String, Object> secondQueryMap = objectMapper.convertValue(secondProperties, Map.class);

		Object periods = secondQueryMap.get("periods");

		List<Object> listPeriods = objectMapper.convertValue(periods, List.class);

		List<Map<String, Object>> allPeriods = new ArrayList<>();
		int periodsToReturn = numDays * 2;
		int count = 0;
		for (Object period : listPeriods) {
			if(count == periodsToReturn){
				break;
			}

			if (count % 2 == 0) {
				Map<String, Object> periodMap = objectMapper.convertValue(period, Map.class);
				allPeriods.add(periodMap);
			}

			count ++;
		}

		return new WeatherResult(allPeriods);
	}
}
