FROM eclipse-temurin:21-jre-noble

RUN mkdir -p /opt/app
COPY build/libs/grpc-spring-server.jar /opt/app/

CMD ["java", "-jar", "/opt/app/grpc-spring-server.jar"]
