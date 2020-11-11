FROM openjdk:10-jre
ADD ./target/help-yourself.web-0.0.1-SNAPSHOT.jar help-yourself-web.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "help-yourself-web.jar"]