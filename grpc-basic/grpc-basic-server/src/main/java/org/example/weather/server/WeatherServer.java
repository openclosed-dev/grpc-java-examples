package org.example.weather.server;

import java.io.IOException;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class WeatherServer {

    private static final Logger LOG = Logger.getLogger(WeatherServer.class.getName());

    private final Server server;

    public WeatherServer(int port) {
        this.server = ServerBuilder.forPort(port)
            .addService(new WeatherServiceImpl())
            .build();
    }

    public void start() throws IOException, InterruptedException {
        server.start();
        LOG.info("Starting server listening on " + server.getPort());
        server.awaitTermination();
    }

    public static void main(String[] args) {
        try {
            new WeatherServer(9090).start();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
