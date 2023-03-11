FROM openjdk:17-alpine

ENV MYSQL_HOST=sourcelambda_profile_db
ENV MYSQL_USER=root
ENV MYSQL_PASSWORD=root
ENV MYSQL_PORT=3306

ADD target/*.jar profile.jar
ENTRYPOINT ["java","-jar","profile.jar"]
