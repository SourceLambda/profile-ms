FROM openjdk:17-alpine
ADD target/*.jar profile.jar
ENTRYPOINT ["java","-jar","profile.jar"]
