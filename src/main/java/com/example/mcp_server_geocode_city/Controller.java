package com.example.mcp_server_geocode_city;

import com.example.mcp_server_geocode_city.record.Coordinates;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class Controller {

    private final GeocodingService geocodingService;

    @GetMapping("/coordinates")
    public Coordinates getCoordinates(@RequestParam String city) {
        return geocodingService.getCoordinates(city);
    }


}
