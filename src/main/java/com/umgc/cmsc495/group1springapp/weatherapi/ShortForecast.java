package com.umgc.cmsc495.group1springapp.weatherapi;

import org.apache.commons.lang3.StringUtils;

/**
 * Author: Brandon Shaffer
 * Date: 11/28/2021
 */
public enum ShortForecast {

	SUNNY("Sunny", ""),
	CLOUDY("Cloudy", ""),
	RAINY("Rainy", ""),
	STORMY("Stormy", ""),
	UNDEFINED("Undefined", "");

	private String title;
	private String picturePath;

	ShortForecast(String title, String picturePath){
		this.title = title;
		this.picturePath = picturePath;
	}

	public String getTitle() {
		return title;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public static ShortForecast getShortForecast(String input){
		if(StringUtils.containsIgnoreCase(input, "sunny")){
			return SUNNY;
		}

		if(StringUtils.containsIgnoreCase(input, "cloud")){
			return CLOUDY;
		}

		if(StringUtils.containsIgnoreCase(input, "rain")){
			return RAINY;
		}

		if(StringUtils.containsIgnoreCase(input, "storm")){
			return STORMY;
		}

		return UNDEFINED;
	}
}
