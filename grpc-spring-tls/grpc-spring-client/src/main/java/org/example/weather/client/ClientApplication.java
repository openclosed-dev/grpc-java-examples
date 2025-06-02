package org.example.weather.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientApplication {

    private static final Logger LOG = LoggerFactory.getLogger(ClientApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(WeatherService service) {
        return (String[] args) -> {
            try {
                var weather = service.getWeather("Tokyo");
                LOG.info("Weather: " + weather);
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
            }
        };
    }
}
