package com.umgc.cmsc495.group1springapp.weatherapi.pojos;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Pojo used to resolve an inner object of the first query.
 * Author: Brandon Shaffer
 * Date: 11/18/2021
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"city",
		"state",
		"distance",
		"bearing"
})
@Generated("jsonschema2pojo")
public class RelativeLocation {

	@JsonProperty("city")
	private Object city;
	@JsonProperty("state")
	private Object state;
	@JsonProperty("distance")
	private Object distance;
	@JsonProperty("bearing")
	private Object bearing;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("city")
	public Object getCity() {
		return city;
	}

	@JsonProperty("city")
	public void setCity(Object city) {
		this.city = city;
	}

	@JsonProperty("state")
	public Object getState() {
		return state;
	}

	@JsonProperty("state")
	public void setState(Object state) {
		this.state = state;
	}

	@JsonProperty("distance")
	public Object getDistance() {
		return distance;
	}

	@JsonProperty("distance")
	public void setDistance(Object distance) {
		this.distance = distance;
	}

	@JsonProperty("bearing")
	public Object getBearing() {
		return bearing;
	}

	@JsonProperty("bearing")
	public void setBearing(Object bearing) {
		this.bearing = bearing;
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
