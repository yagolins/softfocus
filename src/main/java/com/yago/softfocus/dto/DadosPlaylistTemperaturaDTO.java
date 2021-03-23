package com.yago.softfocus.dto;

import java.util.ArrayList;

import com.yago.softfocus.enums.CategoriaEnum;
import com.yago.softfocus.model.Coordenadas;

import lombok.Data;

@Data
public class DadosPlaylistTemperaturaDTO {

	private Double temperatura;
	private ArrayList<String> playlist;
	private Coordenadas coordenadas;
	private String nomeCidade;
	private CategoriaEnum categoria;
}
