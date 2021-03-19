package com.yago.softfocus.model;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class WeatherData implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private Long id;
	private Main main;
	private Coordenadas coord;
	
	@Override
	public String toString() {
		return this.name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public Coordenadas getCoord() {
		return coord;
	}

	public void setCoord(Coordenadas coord) {
		this.coord = coord;
	}

}
