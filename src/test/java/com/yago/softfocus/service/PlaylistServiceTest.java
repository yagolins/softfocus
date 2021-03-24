package com.yago.softfocus.service;

import java.util.Objects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yago.softfocus.dto.DadosPlaylistTemperaturaDTO;

@SpringBootTest
class PlaylistServiceTest {
	
	@Autowired
	private PlaylistService service;

	@Test
    @DisplayName("Teste busca cidade sucesso")
    void testBuscaCidade() {
        String nomeCidade = "Brasilia";
        DadosPlaylistTemperaturaDTO returned = service.buscaPorCidade(nomeCidade);
        Assertions.assertEquals(Objects.isNull(returned), false);
    }

    @Test
    @DisplayName("Test busca coordenadas sucesso")
    void testeBuscaCoordenadas() {
        DadosPlaylistTemperaturaDTO returned = service.buscaPorCoordenadas("-15.7797", "-47.9297");
        Assertions.assertEquals(Objects.isNull(returned), false);
    }
}
