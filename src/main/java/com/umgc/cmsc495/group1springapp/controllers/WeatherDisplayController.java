package com.umgc.cmsc495.group1springapp.controllers;

import com.umgc.cmsc495.group1springapp.weatherapi.Weather;
import com.umgc.cmsc495.group1springapp.weatherapi.WeatherQueryManager;
import com.umgc.cmsc495.group1springapp.weatherapi.WeatherResult;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Controller for defining what is returned from a weather query.
 * Author: Brandon Shaffer
 * Date: 11/13/2021
 */
@Controller
public class WeatherDisplayController {

	@RequestMapping(value = "/weather-display", method = RequestMethod.POST)
	public String weatherDisplay(HttpServletRequest request, Model model){
		String zip = request.getParameter("zip") == null ? "" : request.getParameter("zip");
		String numDays = request.getParameter("numdays") == null ? "" : request.getParameter("numdays");

		model.addAttribute("zip", zip);
		model.addAttribute("numdays", numDays);

		WeatherQueryManager weatherQueryManager = new WeatherQueryManager(zip, Integer.parseInt(numDays));
		WeatherResult weatherResult = weatherQueryManager.queryWeather();
		List<Weather> weather = weatherResult.getResults();
		model.addAttribute("weather", weather);

		return "weather-display";
	}
}
