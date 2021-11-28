package com.umgc.cmsc495.group1springapp.weatherapi.pojos;
/**
 * Author: Brandon Shaffer
 * Date: 11/18/2021
 */

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"updated",
		"units",
		"forecastGenerator",
		"generatedAt",
		"updateTime",
		"validTimes",
		"elevation",
		"periods"
})
@Generated("jsonschema2pojo")
public class SecondQueryPojo {

	@JsonProperty("updated")
	private Object updated;
	@JsonProperty("units")
	private Object units;
	@JsonProperty("forecastGenerator")
	private Object forecastGenerator;
	@JsonProperty("generatedAt")
	private Object generatedAt;
	@JsonProperty("updateTime")
	private Object updateTime;
	@JsonProperty("validTimes")
	private Object validTimes;
	@JsonProperty("elevation")
	private Object elevation;
	@JsonProperty("periods")
	private Object periods;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("updated")
	public Object getUpdated() {
		return updated;
	}

	@JsonProperty("updated")
	public void setUpdated(Object updated) {
		this.updated = updated;
	}

	@JsonProperty("units")
	public Object getUnits() {
		return units;
	}

	@JsonProperty("units")
	public void setUnits(Object units) {
		this.units = units;
	}

	@JsonProperty("forecastGenerator")
	public Object getForecastGenerator() {
		return forecastGenerator;
	}

	@JsonProperty("forecastGenerator")
	public void setForecastGenerator(Object forecastGenerator) {
		this.forecastGenerator = forecastGenerator;
	}

	@JsonProperty("generatedAt")
	public Object getGeneratedAt() {
		return generatedAt;
	}

	@JsonProperty("generatedAt")
	public void setGeneratedAt(Object generatedAt) {
		this.generatedAt = generatedAt;
	}

	@JsonProperty("updateTime")
	public Object getUpdateTime() {
		return updateTime;
	}

	@JsonProperty("updateTime")
	public void setUpdateTime(Object updateTime) {
		this.updateTime = updateTime;
	}

	@JsonProperty("validTimes")
	public Object getValidTimes() {
		return validTimes;
	}

	@JsonProperty("validTimes")
	public void setValidTimes(Object validTimes) {
		this.validTimes = validTimes;
	}

	@JsonProperty("elevation")
	public Object getElevation() {
		return elevation;
	}

	@JsonProperty("elevation")
	public void setElevation(Object elevation) {
		this.elevation = elevation;
	}

	@JsonProperty("periods")
	public Object getPeriods() {
		return periods;
	}

	@JsonProperty("periods")
	public void setPeriods(Object periods) {
		this.periods = periods;
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
