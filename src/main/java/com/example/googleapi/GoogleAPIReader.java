package com.example.googleapi;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.*;

@Component
public class GoogleAPIReader {

	private static final String ENCODING = "UTF-8";
	private static final String QUERY_BASE_URL = "https://www.googleapis.com/books/v1/volumes?q=";

	private ObjectMapper jsonMapper;

	public GoogleAPIReader() {
		this.jsonMapper = new ObjectMapper();
	}


	public GoogleApiResponse getGoogleApiResponse(String query) {
		GoogleApiResponse response = null;
			try {
				response = convertToResponseObject(executeQuery(query));
			} catch (GoogleApiException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			System.out.println("resp.getItems.size: " + response.getItems().size());
//			System.out.println("resp.getItemsFirst: " + response.getItems().get(0).getVolumeInfo().getDescription());
		
		return response;
	}

	/**
	 * Send a query to the GoogleApi.
	 * 
	 * @param query
	 * 
	 */
	private String executeQuery(String query) throws GoogleApiException {
		String json = null;

		try {
			query = URLEncoder.encode(query, ENCODING);
			json = IOUtils.toString(new URL(QUERY_BASE_URL + query).openStream(), ENCODING);
		} catch (MalformedURLException e) {
			System.out.println("Could not get URL " + QUERY_BASE_URL + query);
			throw new GoogleApiException(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			throw new GoogleApiException(e.getMessage());
		} catch (IOException e) {
			System.out.println("Could not execute " + query + " on GoogleApi : ");
			throw new GoogleApiException(e.getMessage());
		}
//		System.out.println("json from exec: " + json);

		return json;
	}

	private GoogleApiResponse convertToResponseObject(String responseFromServer) throws GoogleApiException {
		GoogleApiResponse response;
		try {
			response = this.jsonMapper.readValue(responseFromServer, new TypeReference<GoogleApiResponse>() {
			});
		} catch (Exception e) {
			throw new GoogleApiException(e.getMessage());
		}
		return response;
	}

}
