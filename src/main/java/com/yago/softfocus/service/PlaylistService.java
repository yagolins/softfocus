package com.yago.softfocus.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.yago.softfocus.constantes.Constantes;
import com.yago.softfocus.dto.DadosPlaylistTemperaturaDTO;
import com.yago.softfocus.enums.CategoriaEnum;
import com.yago.softfocus.model.WeatherData;

@Service
public class PlaylistService {

	@Autowired
	private SpotifyService spotifyService;
	
	@Autowired
	private HistoricoService historicoService;

	private static final RestTemplate restTemplate = new RestTemplate();

	public DadosPlaylistTemperaturaDTO buscaPorCidade(String nomeCidade) throws RestClientException, Exception {
		DadosPlaylistTemperaturaDTO retorno = buscarPlaylistPorTemperatura(
				restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q=" + nomeCidade
						+ "&appid=6801fe9e74c3fd9d5a5b0ea6b668d7af&units=metric", WeatherData.class));
		historicoService.salvar(retorno);
		return retorno;
	}

	public DadosPlaylistTemperaturaDTO buscaPorCoordenadas(String latitude, String longitude)
			throws RestClientException, Exception {
		DadosPlaylistTemperaturaDTO retorno = buscarPlaylistPorTemperatura(
				restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon="
						+ longitude + "&appid=6801fe9e74c3fd9d5a5b0ea6b668d7af&units=metric", WeatherData.class));
		historicoService.salvar(retorno);
		return retorno;
	}

	private DadosPlaylistTemperaturaDTO buscarPlaylistPorTemperatura(WeatherData dadosTemperatura) throws Exception {
		if (dadosTemperatura.getMain().getTemp() > Constantes.ACIMA_E_FESTA) {
			return montarRetorno(CategoriaEnum.FESTA, spotifyService.getPlaylistPorCategoria(CategoriaEnum.FESTA),
					dadosTemperatura);
		} else if (dadosTemperatura.getMain().getTemp() <= Constantes.ACIMA_E_FESTA
				&& dadosTemperatura.getMain().getTemp() >= Constantes.ACIMA_E_POP) {
			return montarRetorno(CategoriaEnum.POP, spotifyService.getPlaylistPorCategoria(CategoriaEnum.POP),
					dadosTemperatura);
		} else if (dadosTemperatura.getMain().getTemp() < Constantes.ACIMA_E_POP
				&& dadosTemperatura.getMain().getTemp() >= Constantes.ACIMA_E_ROCK) {
			return montarRetorno(CategoriaEnum.ROCK, spotifyService.getPlaylistPorCategoria(CategoriaEnum.ROCK),
					dadosTemperatura);
		} else
			return montarRetorno(CategoriaEnum.CLASSICA, spotifyService.getPlaylistPorCategoria(CategoriaEnum.CLASSICA),
					dadosTemperatura);

	}

	private DadosPlaylistTemperaturaDTO montarRetorno(CategoriaEnum categoria, ArrayList<String> playlist,
			WeatherData dadosTemperatura) {
		DadosPlaylistTemperaturaDTO dto = new DadosPlaylistTemperaturaDTO();
		dto.setCategoria(categoria);
		dto.setCoordenadas(dadosTemperatura.getCoord());
		dto.setPlaylist(playlist);
		dto.setNomeCidade(dadosTemperatura.getName());
		dto.setTemperatura(dadosTemperatura.getMain().getTemp());
		return dto;
	}
}
