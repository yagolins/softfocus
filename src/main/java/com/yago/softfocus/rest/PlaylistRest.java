package com.yago.softfocus.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yago.softfocus.service.PlaylistService;

@RestController
@CrossOrigin
@RequestMapping(path = "api/playlist")
public class PlaylistRest {
	
	@Autowired
	private PlaylistService service;

	@GetMapping("/listByNomeCidade/{nomeCidade}")
    public void listarPlaylistPorNomeCidade(@PathVariable(name = "nomeCidade") String nomeCidade) {
		service.buscaPorCidade(nomeCidade);
    }
	
	@GetMapping("/listByCoordenadas")
    public String listarPlaylistPorCoordenadas(@PathVariable(name = "latitude") String latitude,
    		@PathVariable(name = "longitude") String longitude) throws JsonProcessingException {
		return service.buscaPorCoordenadas(latitude, longitude);
    }
}
