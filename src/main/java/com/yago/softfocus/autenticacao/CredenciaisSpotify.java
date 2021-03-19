package com.yago.softfocus.autenticacao;

import java.io.IOException;

import org.apache.hc.core5.http.ParseException;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;

public class CredenciaisSpotify {

	 private static final String clientId = "4fda7f4932bf4c068141a1e526502f7e";
	 private static final String clientSecret = "8c5b88ea1fed465badebafbfa4dfc5de";

	 private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
	    .setClientId(clientId)
	    .setClientSecret(clientSecret)
	    .build();
	  
	  private static final ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials()
	    .build();

	  public static String clientCredentials() {
	    try {
	      final ClientCredentials clientCredentials = clientCredentialsRequest.execute();
	      
	      return clientCredentials.getAccessToken();

	    } catch (IOException | SpotifyWebApiException | ParseException e) {
	      System.out.println("Error: " + e.getMessage());
	    }
		return null;
	  }
}
