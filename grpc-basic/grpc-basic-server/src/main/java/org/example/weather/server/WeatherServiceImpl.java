package org.example.weather.server;

import org.example.weather.PlaceMessage;
import org.example.weather.WeatherMessage;
import org.example.weather.WeatherServiceGrpc;

import io.grpc.stub.StreamObserver;

public class WeatherServiceImpl extends WeatherServiceGrpc.WeatherServiceImplBase {

    @Override
    public void getWeather(PlaceMessage request, StreamObserver<WeatherMessage> responseObserver) {
        WeatherMessage response = WeatherMessage.newBuilder()
            .setCity(request.getCity())
            .setWeather("sunny")
            .setTemperature(300)
            .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
