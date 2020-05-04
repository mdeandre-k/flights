package com.mytravels.flights.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
public class SkyScannerWebConfig {

    @Value("${skyscanner.api.host}")
    private String skyScannerApiHost;

    @Value("${skyscanner.api.key}")
    private String  skyScannerApiKey;

    @Bean
    public RestTemplate skyScannerRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Collections.singletonList((httpRequest, bytes, clientHttpRequestExecution) -> {
            HttpHeaders headers = httpRequest.getHeaders();
            headers.put("X-RapidAPI-Host", Collections.singletonList(skyScannerApiHost));
            headers.put("X-RapidAPI-Key", Collections.singletonList(skyScannerApiKey));
            return clientHttpRequestExecution.execute(httpRequest, bytes);
        }));
        return restTemplate;
    }
}
