package com.yago.softfocus.model;

import lombok.Data;

@Data
public class Weather {

	private Long id;
	private String main;
	private String description;
	private String icon;
}
