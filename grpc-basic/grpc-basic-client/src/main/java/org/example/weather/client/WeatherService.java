package org.example.weather.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.example.weather.PlaceMessage;
import org.example.weather.WeatherMessage;
import org.example.weather.WeatherServiceGrpc;
import org.example.weather.WeatherServiceGrpc.WeatherServiceBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class WeatherService {

    private static final Logger LOG = Logger.getLogger(WeatherService.class.getName());

    private final ManagedChannel channel;
    private final WeatherServiceBlockingStub blockingStub;

    public WeatherService(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port)
            .usePlaintext()
            .build();
        this.blockingStub = WeatherServiceGrpc.newBlockingStub(channel);
    }

    public String getWeather(String city) {
        PlaceMessage request = PlaceMessage.newBuilder().setCity(city).build();
        LOG.info("Sending a request " + request);
        WeatherMessage response = blockingStub.getWeather(request);
        LOG.info("Received a response " + response);
        return response.getWeather();
    }

    public static void main(String[] args) {
        try {
            var service = new WeatherService("localhost", 9090);
            var weather = service.getWeather("Tokyo");
            LOG.info("Weather: " + weather);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
