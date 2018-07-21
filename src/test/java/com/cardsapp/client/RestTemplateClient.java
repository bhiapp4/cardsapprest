package com.cardsapp.client;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateClient {

	public static void performGet() {
		String uri = "http://localhost:18080/api/roles";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		System.out.println(result.getBody());
	}
	
	public static void performPost(){
		String uri = "http://localhost:18080/api/roles";
		String json = "{\"name\":\"SUB_Admin\"}";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(json, headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
	    System.out.println(result.getBody());	
	}
	
	public static void main(String[] args) {
		performGet();
		//performPost();
	}
	

}
