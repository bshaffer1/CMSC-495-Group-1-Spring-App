package com.umgc.cmsc495.group1springapp.weatherapi;

/**
 * A weather object to hold weather data for a day.
 * Author: Brandon Shaffer
 * Date: 11/28/2021
 */
public class Weather {

	private int temperature;
	private String forecast;
	private String date;

	public Weather(Object temperature, ShortForecast shortForecast, String date) {
		this.temperature = (int) temperature;
		this.forecast = shortForecast.getTitle();
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public String getForecast() {
		return forecast;
	}

	public int getTemperature() {
		return temperature;
	}
}
