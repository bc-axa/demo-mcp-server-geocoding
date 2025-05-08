package com.example.mcp_server_geocode_city;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public record GeocodingResponse(
        @JsonProperty("type") String type,
        ArrayList<Feature> features) {
}

record Feature(
        @JsonProperty("type") String type,
        @JsonProperty("properties") Properties properties
) {
}

record Properties(
        @JsonProperty("country") String country,
        @JsonProperty("country_code") String countryCode,
        @JsonProperty("region") String region,
        @JsonProperty("city") String city,
        @JsonProperty("municipality") String municipality,
        @JsonProperty("lon") double lon,
        @JsonProperty("lat") double lat
) {
}

