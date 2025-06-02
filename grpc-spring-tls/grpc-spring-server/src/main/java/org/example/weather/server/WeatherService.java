package org.example.weather.server;

import org.example.weather.PlaceMessage;
import org.example.weather.WeatherMessage;
import org.example.weather.WeatherServiceGrpc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import io.grpc.stub.StreamObserver;

@Service
public class WeatherService extends WeatherServiceGrpc.WeatherServiceImplBase {

    private static final Logger LOG = LoggerFactory.getLogger(WeatherService.class);

    @Override
    public void getWeather(PlaceMessage request, StreamObserver<WeatherMessage> responseObserver) {
        LOG.info("Received a request");
        WeatherMessage response = WeatherMessage.newBuilder()
            .setCity(request.getCity())
            .setWeather("sunny")
            .setTemperature(300)
            .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
        LOG.info("Completed a request");
    }
}
