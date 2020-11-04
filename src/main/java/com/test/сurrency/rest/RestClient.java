package com.test.сurrency.rest;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class RestClient {

    private RestTemplate rest;

    public RestClient() {
        rest = new RestTemplateBuilder()
            .errorHandler(new RestTemplateResponseErrorHandler())
            .build();
    }

    public ResponseEntity<String> get (String uri) throws RestClientException {
        HttpEntity<String> requestEntity = new HttpEntity<String>("");
        ResponseEntity<String> responseEntity = rest.exchange(uri, HttpMethod.GET, requestEntity, String.class);
        return responseEntity;
    }
}
