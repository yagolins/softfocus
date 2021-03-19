package com.yago.softfocus.service;

import java.io.IOException;
import java.util.ArrayList;

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

@Service
public class SpotifyService {

	private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
			.setAccessToken(CredenciaisSpotify.clientCredentials()).build();

	public ArrayList<String> getPlaylistPorCategoria(String categoria) throws Exception {
		try {
			String idPlaylist = buscaIdPlaylist(categoria);
			return buscaMusicasPlaylist(idPlaylist);			
		} catch (IOException | SpotifyWebApiException | ParseException e) {
			System.out.println("Error: " + e.getMessage());
			throw new Exception();
		}
		
	}
	
	private String buscaIdPlaylist(String categoria) throws ParseException, SpotifyWebApiException, IOException {
		final GetCategorysPlaylistsRequest getCategoryRequest = spotifyApi.getCategorysPlaylists(categoria)
				.country(CountryCode.BR).limit(1).build();

		final Paging<PlaylistSimplified> playlistSimplifiedPaging = getCategoryRequest.execute();
		return playlistSimplifiedPaging.getItems()[0].getId();
	}
	
	private ArrayList<String> buscaMusicasPlaylist(String idPlaylist) throws ParseException, SpotifyWebApiException, IOException {
		ArrayList<String> musicas = new ArrayList<String>();
		final GetPlaylistRequest getPlaylistRequest = spotifyApi
				.getPlaylist(idPlaylist).build();
		final Playlist playlist = getPlaylistRequest.execute();
		for (var i = 0; i < 10; i++) {
			musicas.add(playlist.getTracks().getItems()[i].getTrack().getName());
		}
		return musicas;
	}
	
	
}
