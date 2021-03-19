package com.yago.softfocus.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.yago.softfocus.constantes.Constantes;
import com.yago.softfocus.dto.DadosPlaylistTemperaturaDTO;
import com.yago.softfocus.model.WeatherData;

@Service
public class PlaylistService {
	
	@Autowired
	private SpotifyService spotifyService;
	
	private static final RestTemplate restTemplate = new RestTemplate();
	
	//https://api.openweathermap.org/data/2.5/weather?lat=-12.3857&lon=-46.5711&appid=6801fe9e74c3fd9d5a5b0ea6b668d7af&units=metric
	//https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}&units=metric
	//https://api.openweathermap.org/data/2.5/weather?q=Taguatinga&appid=6801fe9e74c3fd9d5a5b0ea6b668d7af&units=metric
	//https://api.openweathermap.org/data/2.5/weather?q={cityname}&appid={API key}&units=metric

	public void buscaPorCidade(String nomeCidade) throws RestClientException, Exception {
		buscarPlaylistPorTemperatura(restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q="
				+ nomeCidade + "&appid=6801fe9e74c3fd9d5a5b0ea6b668d7af&units=metric", WeatherData.class));
	}

	public String buscaPorCoordenadas(String latitude, String longitude) throws RestClientException, Exception {
		buscarPlaylistPorTemperatura(restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?lat="
				+latitude+"&lon="+longitude+"&appid=6801fe9e74c3fd9d5a5b0ea6b668d7af&units=metric", WeatherData.class));
		return null;
	}

	private DadosPlaylistTemperaturaDTO buscarPlaylistPorTemperatura(WeatherData dadosTemperatura) throws Exception {
		if (dadosTemperatura.getMain().getTemp()>Constantes.ACIMA_E_FESTA) {
			return montarRetorno(Constantes.FESTA, spotifyService.getPlaylistPorCategoria(Constantes.FESTA), dadosTemperatura);
		} else {
			if (dadosTemperatura.getMain().getTemp()<=Constantes.ACIMA_E_FESTA && dadosTemperatura.getMain().getTemp()>=Constantes.ACIMA_E_POP) {
				return montarRetorno(Constantes.POP, spotifyService.getPlaylistPorCategoria(Constantes.POP), dadosTemperatura);
			} else {
				if (dadosTemperatura.getMain().getTemp()<Constantes.ACIMA_E_POP && dadosTemperatura.getMain().getTemp()>=Constantes.ACIMA_E_ROCK) {
					return montarRetorno(Constantes.ROCK, spotifyService.getPlaylistPorCategoria(Constantes.ROCK), dadosTemperatura);
				} else {
					return montarRetorno(Constantes.CLASSICA, spotifyService.getPlaylistPorCategoria(Constantes.CLASSICA), dadosTemperatura);
				}
			}
		}
	}
	
	private DadosPlaylistTemperaturaDTO montarRetorno(String categoria, ArrayList<String> playlist, WeatherData dadosTemperatura) {
		DadosPlaylistTemperaturaDTO dto = new DadosPlaylistTemperaturaDTO();
		dto.setCoordenadas(dadosTemperatura.getCoord());
		dto.setPlaylist(playlist);
		dto.setNomeCidade(dadosTemperatura.getName());
		dto.setTemperatura(dadosTemperatura.getMain().getTemp());
		return dto;
	}
}
