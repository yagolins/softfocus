package com.yago.softfocus.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.yago.softfocus.model.WeatherData;

@Service
public class PlaylistService {
	
	//https://api.openweathermap.org/data/2.5/weather?lat=-12.3857&lon=-46.5711&appid=6801fe9e74c3fd9d5a5b0ea6b668d7af&units=metric
	//https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}&units=metric
	//https://api.openweathermap.org/data/2.5/weather?q=Taguatinga&appid=6801fe9e74c3fd9d5a5b0ea6b668d7af&units=metric
	//https://api.openweathermap.org/data/2.5/weather?q={cityname}&appid={API key}&units=metric
	//6801fe9e74c3fd9d5a5b0ea6b668d7af
	//
	
//	Se a temperatura (em graus Celsius) estiver acima de 30 graus, sugira faixas para
//	festa (party)
//	 Caso a temperatura esteja entre 15 e 30 graus, sugira faixas de música pop (pop)
//	 Se estiver um pouco frio (entre 10 e 14 graus), sugira faixas de rock (rock)
//	 Caso contrário, sugira faixas de música clássica (classical)
//	 As chamadas devem ser salvas no banco de dados para histórico

	public void buscaPorCidade(String nomeCidade) {
		RestTemplate restTemplate = new RestTemplate();
		WeatherData response = restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q="+nomeCidade+"&appid=6801fe9e74c3fd9d5a5b0ea6b668d7af&units=metric", WeatherData.class);
		System.out.println(response.getMain().getTemp());
	}

	public String buscaPorCoordenadas(String latitude, String longitude) {
		return null;
	}
}
