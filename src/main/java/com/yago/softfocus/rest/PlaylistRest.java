package com.yago.softfocus.rest;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.yago.softfocus.dto.DadosPlaylistTemperaturaDTO;
import com.yago.softfocus.service.PlaylistService;

import lombok.NonNull;

@RestController
@CrossOrigin
@RequestMapping(path = "api/playlist")
public class PlaylistRest {

	@Autowired
	private PlaylistService service;

	@GetMapping("/listByNomeCidade/{nomeCidade}")
	public ResponseEntity<DadosPlaylistTemperaturaDTO> listarPlaylistPorNomeCidade(
			@PathVariable(name = "nomeCidade") @NotNull String nomeCidade) {
		DadosPlaylistTemperaturaDTO dto = service.buscaPorCidade(nomeCidade);
		return ResponseEntity.ok(dto);
	}

	@GetMapping("/listByCoordenadas/{latitude}/{longitude}")
	public ResponseEntity<DadosPlaylistTemperaturaDTO> listarPlaylistPorCoordenadas(
			@NonNull @PathVariable(name = "latitude") String latitude,
			@NotNull @PathVariable(name = "longitude") String longitude) throws RestClientException, Exception {
		DadosPlaylistTemperaturaDTO dto = service.buscaPorCoordenadas(latitude, longitude);
		return ResponseEntity.ok(dto);
	}
}
