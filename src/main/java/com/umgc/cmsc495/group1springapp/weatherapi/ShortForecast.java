package com.umgc.cmsc495.group1springapp.weatherapi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.graalvm.compiler.hotspot.sparc.SPARCHotSpotBackend;

/**
 * Author: Brandon Shaffer
 * Date: 11/28/2021
 */
@Getter
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
