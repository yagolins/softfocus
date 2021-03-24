package com.yago.softfocus.repository;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.yago.softfocus.enums.CategoriaEnum;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity(name = "TB_HISTORICO")
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Historico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	Long id;

	@Column(name = "TEMPERATURA", nullable = false)
	Double temperatura;

	@Column(name = "LATITUDE", nullable = false)
	String latitude;

	@Column(name = "LONGITUDE", nullable = false)
	String longitude;

	@Column(name = "CATEGORIA", nullable = false)
	@Enumerated(EnumType.STRING)
	CategoriaEnum categoria;

	@Column(name = "NOME_CIDADE", nullable = false)
	String nomeCidade;

	@Column(name = "DATA_BUSCA", nullable = false)
	Date dataBusca;
}
