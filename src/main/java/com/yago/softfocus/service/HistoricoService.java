package com.yago.softfocus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yago.softfocus.dto.DadosPlaylistTemperaturaDTO;
import com.yago.softfocus.repository.Historico;
import com.yago.softfocus.repository.HistoricoRepository;
import com.yago.softfocus.util.CalendarioUtil;

@Service
public class HistoricoService {

	@Autowired
	private HistoricoRepository repository;

	public void salvar(DadosPlaylistTemperaturaDTO retorno) {
		Historico historico = new Historico(null, retorno.getTemperatura(), retorno.getCoordenadas().getLat(),
				retorno.getCoordenadas().getLon(), retorno.getCategoria(), retorno.getNomeCidade(),
				CalendarioUtil.createNewDate());
		repository.save(historico);
	}
}
