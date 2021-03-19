package com.yago.softfocus.dto;

import java.util.ArrayList;

import com.yago.softfocus.model.Coordenadas;

import lombok.Data;

@Data
public class DadosPlaylistTemperaturaDTO {

	private Double temperatura;
	private ArrayList<String> playlist;
	private Coordenadas coordenadas;
	private String nomeCidade;
	
	public Double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}
	public ArrayList<String> getPlaylist() {
		return playlist;
	}
	public void setPlaylist(ArrayList<String> playlist) {
		this.playlist = playlist;
	}
	public Coordenadas getCoordenadas() {
		return coordenadas;
	}
	public void setCoordenadas(Coordenadas coordenadas) {
		this.coordenadas = coordenadas;
	}
	public String getNomeCidade() {
		return nomeCidade;
	}
	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
}
