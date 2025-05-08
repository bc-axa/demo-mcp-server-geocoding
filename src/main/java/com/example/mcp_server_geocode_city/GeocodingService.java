package com.example.mcp_server_geocode_city;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class GeocodingService {

    private static final String API_URL = "https://api.geoapify.com/v1/geocode/search";
    private static final String API_REQUEST_PARAMS = "?city=%s&country=%s&apiKey=%s";

    @Value("${api.geocoding.api-key}")
    private String API_KEY;

    private final RestTemplate restTemplate;

    public GeocodingResponse geocode(String location) {
        var url = String.format(API_URL + API_REQUEST_PARAMS, location, "FRANCE", API_KEY);
        log.info(url);
        return restTemplate.getForObject(url, GeocodingResponse.class);
    }
}
