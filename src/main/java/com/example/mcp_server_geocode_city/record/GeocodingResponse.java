package com.example.mcp_server_geocode_city.record;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public record GeocodingResponse(
        @JsonProperty("type") String type,
        ArrayList<Feature> features) {
}



