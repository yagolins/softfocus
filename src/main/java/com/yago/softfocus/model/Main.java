package com.yago.softfocus.model;

import lombok.Data;

@Data
public class Main {

	private Double temp;
	private Double feels_like;
	private Double temp_min;
	private Double temp_max;
	private String pressure;
	private String humidity;
	
	public Double getTemp() {
		return temp;
	}
	public void setTemp(Double temp) {
		this.temp = temp;
	}
	public Double getFeels_like() {
		return feels_like;
	}
	public void setFeels_like(Double feels_like) {
		this.feels_like = feels_like;
	}
	public Double getTemp_min() {
		return temp_min;
	}
	public void setTemp_min(Double temp_min) {
		this.temp_min = temp_min;
	}
	public Double getTemp_max() {
		return temp_max;
	}
	public void setTemp_max(Double temp_max) {
		this.temp_max = temp_max;
	}
	public String getPressure() {
		return pressure;
	}
	public void setPressure(String pressure) {
		this.pressure = pressure;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
}
