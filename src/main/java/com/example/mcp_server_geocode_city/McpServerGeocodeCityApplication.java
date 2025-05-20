package com.example.mcp_server_geocode_city;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class McpServerGeocodeCityApplication {

    public static void main(String[] args) {
        SpringApplication.run(McpServerGeocodeCityApplication.class, args);
    }

    @Bean
    public ToolCallbackProvider weatherTools(GeocodingService geocodingService) {
        return MethodToolCallbackProvider.builder().toolObjects(geocodingService).build();
    }

//    Local testing
//    @Bean
//    CommandLineRunner init(GeocodingService geocodingService) {
//        return args -> {
//            var resp = geocodingService.geocode("Lille");
//            log.info(resp.toString());
//
//            var coordinates = geocodingService.getCoordinates("Lille");
//            log.info(coordinates.toString());
//        };
//    }

}
