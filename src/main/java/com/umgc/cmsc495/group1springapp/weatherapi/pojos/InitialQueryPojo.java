package com.umgc.cmsc495.group1springapp.weatherapi.pojos;
/**
 * Author: Brandon Shaffer
 * Date: 11/15/2021
 */

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"@id",
		"@type",
		"cwa",
		"forecastOffice",
		"gridId",
		"gridX",
		"gridY",
		"forecast",
		"forecastHourly",
		"forecastGridData",
		"observationStations",
		"relativeLocation",
		"forecastZone",
		"county",
		"fireWeatherZone",
		"timeZone",
		"radarStation"
})
@Generated("jsonschema2pojo")
public class InitialQueryPojo {

	@JsonProperty("@id")
	private Object id;
	@JsonProperty("@type")
	private Object type;
	@JsonProperty("cwa")
	private Object cwa;
	@JsonProperty("forecastOffice")
	private Object forecastOffice;
	@JsonProperty("gridId")
	private Object gridId;
	@JsonProperty("gridX")
	private Object gridX;
	@JsonProperty("gridY")
	private Object gridY;
	@JsonProperty("forecast")
	private Object forecast;
	@JsonProperty("forecastHourly")
	private Object forecastHourly;
	@JsonProperty("forecastGridData")
	private Object forecastGridData;
	@JsonProperty("observationStations")
	private Object observationStations;
	@JsonProperty("relativeLocation")
	private RelativeLocation relativeLocation;
	@JsonProperty("forecastZone")
	private Object forecastZone;
	@JsonProperty("county")
	private Object county;
	@JsonProperty("fireWeatherZone")
	private Object fireWeatherZone;
	@JsonProperty("timeZone")
	private Object timeZone;
	@JsonProperty("radarStation")
	private Object radarStation;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("@id")
	public Object getId() {
		return id;
	}

	@JsonProperty("@id")
	public void setId(Object id) {
		this.id = id;
	}

	@JsonProperty("@type")
	public Object getType() {
		return type;
	}

	@JsonProperty("@type")
	public void setType(Object type) {
		this.type = type;
	}

	@JsonProperty("cwa")
	public Object getCwa() {
		return cwa;
	}

	@JsonProperty("cwa")
	public void setCwa(Object cwa) {
		this.cwa = cwa;
	}

	@JsonProperty("forecastOffice")
	public Object getForecastOffice() {
		return forecastOffice;
	}

	@JsonProperty("forecastOffice")
	public void setForecastOffice(Object forecastOffice) {
		this.forecastOffice = forecastOffice;
	}

	@JsonProperty("gridId")
	public Object getGridId() {
		return gridId;
	}

	@JsonProperty("gridId")
	public void setGridId(Object gridId) {
		this.gridId = gridId;
	}

	@JsonProperty("gridX")
	public Object getGridX() {
		return gridX;
	}

	@JsonProperty("gridX")
	public void setGridX(Object gridX) {
		this.gridX = gridX;
	}

	@JsonProperty("gridY")
	public Object getGridY() {
		return gridY;
	}

	@JsonProperty("gridY")
	public void setGridY(Object gridY) {
		this.gridY = gridY;
	}

	@JsonProperty("forecast")
	public Object getForecast() {
		return forecast;
	}

	@JsonProperty("forecast")
	public void setForecast(Object forecast) {
		this.forecast = forecast;
	}

	@JsonProperty("forecastHourly")
	public Object getForecastHourly() {
		return forecastHourly;
	}

	@JsonProperty("forecastHourly")
	public void setForecastHourly(Object forecastHourly) {
		this.forecastHourly = forecastHourly;
	}

	@JsonProperty("forecastGridData")
	public Object getForecastGridData() {
		return forecastGridData;
	}

	@JsonProperty("forecastGridData")
	public void setForecastGridData(Object forecastGridData) {
		this.forecastGridData = forecastGridData;
	}

	@JsonProperty("observationStations")
	public Object getObservationStations() {
		return observationStations;
	}

	@JsonProperty("observationStations")
	public void setObservationStations(Object observationStations) {
		this.observationStations = observationStations;
	}

	@JsonProperty("relativeLocation")
	public RelativeLocation getRelativeLocation() {
		return relativeLocation;
	}

	@JsonProperty("relativeLocation")
	public void setRelativeLocation(RelativeLocation relativeLocation) {
		this.relativeLocation = relativeLocation;
	}

	@JsonProperty("forecastZone")
	public Object getForecastZone() {
		return forecastZone;
	}

	@JsonProperty("forecastZone")
	public void setForecastZone(Object forecastZone) {
		this.forecastZone = forecastZone;
	}

	@JsonProperty("county")
	public Object getCounty() {
		return county;
	}

	@JsonProperty("county")
	public void setCounty(Object county) {
		this.county = county;
	}

	@JsonProperty("fireWeatherZone")
	public Object getFireWeatherZone() {
		return fireWeatherZone;
	}

	@JsonProperty("fireWeatherZone")
	public void setFireWeatherZone(Object fireWeatherZone) {
		this.fireWeatherZone = fireWeatherZone;
	}

	@JsonProperty("timeZone")
	public Object getTimeZone() {
		return timeZone;
	}

	@JsonProperty("timeZone")
	public void setTimeZone(Object timeZone) {
		this.timeZone = timeZone;
	}

	@JsonProperty("radarStation")
	public Object getRadarStation() {
		return radarStation;
	}

	@JsonProperty("radarStation")
	public void setRadarStation(Object radarStation) {
		this.radarStation = radarStation;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}