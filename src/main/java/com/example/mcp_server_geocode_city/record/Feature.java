package com.example.mcp_server_geocode_city.record;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Feature(
        @JsonProperty("type") String type,
        @JsonProperty("properties") Properties properties
) {
}
