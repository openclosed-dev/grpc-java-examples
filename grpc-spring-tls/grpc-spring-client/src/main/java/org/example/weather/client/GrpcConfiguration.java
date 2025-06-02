package org.example.weather.client;

import org.example.weather.WeatherServiceGrpc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.grpc.client.GrpcChannelFactory;

@Configuration
public class GrpcConfiguration {

    @Bean
    public WeatherServiceGrpc.WeatherServiceBlockingStub stub(GrpcChannelFactory channels) {
        return WeatherServiceGrpc.newBlockingStub(channels.createChannel("weather"));
    }
}
