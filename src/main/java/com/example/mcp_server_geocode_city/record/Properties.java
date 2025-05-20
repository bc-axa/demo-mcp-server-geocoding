package com.example.mcp_server_geocode_city.record;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Properties(
        @JsonProperty("country") String country,
        @JsonProperty("country_code") String countryCode,
        @JsonProperty("region") String region,
        @JsonProperty("city") String city,
        @JsonProperty("municipality") String municipality,
        @JsonProperty("lon") double lon,
        @JsonProperty("lat") double lat
) {
}

