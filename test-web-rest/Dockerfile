FROM openjdk:8
EXPOSE 60001
ADD target/test-web-rest-0.0.1-SNAPSHOT.jar /test-web-rest-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "access-control-rest/.jar"]