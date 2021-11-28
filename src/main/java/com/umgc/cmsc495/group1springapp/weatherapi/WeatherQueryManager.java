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
 * Author: Brandon Shaffer
 * Date: 11/18/2021
 */
public class WeatherQueryManager {

	private LatLong latLong;

	public WeatherQueryManager(String zip) {
		setLatLongFromZip(zip);
	}

	public void setLatLongFromZip(String zip) {
		LatLong latLong = new LatLong(zip);
		if(latLong == null || latLong.getLatitude() == null || latLong.getLongitude() == null){
			this.latLong = null;
		}
		this.latLong = latLong;
	}

	public WeatherResult queryWeather() throws JsonProcessingException {
		String latitude = latLong.getLatitude();
		String longitude = latLong.getLongitude();

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

		List<Map<String, Object>> allPeriods = new ArrayList<Map<String, Object>>();
		for (Object period : listPeriods) {
			Map<String, Object> periodMap = objectMapper.convertValue(period, Map.class);
			allPeriods.add(periodMap);
		}

		return new WeatherResult(allPeriods);
	}
}
