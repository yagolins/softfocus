package com.yago.softfocus.model;

import lombok.Data;

@Data
public class Main {

	private Double temp;
	
	public Double getTemp() {
		return temp;
	}
	public void setTemp(Double temp) {
		this.temp = temp;
	}
}
