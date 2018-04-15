FROM openjdk:8
ADD target/shared-board.jar shared-board.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "shared-board.jar"]
