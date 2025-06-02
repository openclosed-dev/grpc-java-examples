package org.example.weather.client;

import org.example.weather.PlaceMessage;
import org.example.weather.WeatherMessage;
import org.example.weather.WeatherServiceGrpc.WeatherServiceBlockingStub;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private static final Logger LOG = LoggerFactory.getLogger(WeatherService.class);

    private final WeatherServiceBlockingStub blockingStub;

    public WeatherService(WeatherServiceBlockingStub blockingStub) {
        this.blockingStub = blockingStub;
    }

    public String getWeather(String city) {
        PlaceMessage request = PlaceMessage.newBuilder().setCity(city).build();
        LOG.info("Sending a request " + request);
        WeatherMessage response = blockingStub.getWeather(request);
        LOG.info("Received a response " + response);
        return response.getWeather();
    }
}
