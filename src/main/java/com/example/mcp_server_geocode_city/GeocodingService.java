package com.example.mcp_server_geocode_city;

import com.example.mcp_server_geocode_city.record.Coordinates;
import com.example.mcp_server_geocode_city.record.GeocodingResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
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

    public Coordinates getCoordinates(String city) {
        log.info("getCoordinates for name: >{}<", city);

        if (StringUtils.isEmpty(city)) {
            return null;
        }
        var geocodeResp = geocode(city);
        if (geocodeResp == null) {
            throw new RuntimeException("Geocode not found");
        }
        var feature = geocodeResp.features().getFirst();

        log.info("city {} latitude {} loongitude {} ", city, feature.properties().lat(), feature.properties().lon());
        return new Coordinates(feature.properties().lat(), feature.properties().lon());
    }

    public GeocodingResponse geocode(String location) {
        var url = String.format(API_URL + API_REQUEST_PARAMS, location, "FRANCE", API_KEY);
        log.info(url);
        return restTemplate.getForObject(url, GeocodingResponse.class);
    }
}
