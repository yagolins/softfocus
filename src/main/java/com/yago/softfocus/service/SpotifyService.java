package com.yago.softfocus.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.apache.hc.core5.http.ParseException;
import org.springframework.stereotype.Service;

import com.neovisionaries.i18n.CountryCode;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.Playlist;
import com.wrapper.spotify.model_objects.specification.PlaylistSimplified;
import com.wrapper.spotify.requests.data.browse.GetCategorysPlaylistsRequest;
import com.wrapper.spotify.requests.data.playlists.GetPlaylistRequest;
import com.yago.softfocus.autenticacao.CredenciaisSpotify;
import com.yago.softfocus.enums.CategoriaEnum;

@Service
public class SpotifyService {

	private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
			.setAccessToken(CredenciaisSpotify.clientCredentials()).build();

	public ArrayList<String> getPlaylistPorCategoria(CategoriaEnum categoria) throws Exception {
		try {
			String idPlaylist = buscaIdPlaylist(categoria);
			return buscaMusicasPlaylist(idPlaylist);
		} catch (IOException | SpotifyWebApiException | ParseException e) {
			System.out.println("Error: " + e.getMessage());
			throw new Exception();
		}

	}

	private String buscaIdPlaylist(CategoriaEnum categoria) throws ParseException, SpotifyWebApiException, IOException {
		final GetCategorysPlaylistsRequest getCategoryRequest = spotifyApi
				.getCategorysPlaylists(categoria.getDescricao()).build();

		final Paging<PlaylistSimplified> playlistSimplifiedPaging = getCategoryRequest.execute();
		return playlistSimplifiedPaging.getItems()[sorteiaPlaylist(playlistSimplifiedPaging.getItems().length)].getId();
	}

	private ArrayList<String> buscaMusicasPlaylist(String idPlaylist)
			throws ParseException, SpotifyWebApiException, IOException {
		ArrayList<String> musicas = new ArrayList<String>();
		final GetPlaylistRequest getPlaylistRequest = spotifyApi.getPlaylist(idPlaylist).build();
		final Playlist playlist = getPlaylistRequest.execute();
		for (var i = 0; i < playlist.getTracks().getItems().length; i++) {
			musicas.add(playlist.getTracks().getItems()[i].getTrack().getName());
		}
		return musicas;
	}

	public Integer sorteiaPlaylist(Integer length) {
		return new Random().nextInt(length);
	}

}
