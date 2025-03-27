FROM amazoncorretto:21

ARG JAR_FILE=monitor-sensors/target/monitor-sensors-1.0.0-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]