FROM openjdk:12
ARG JAR_FILE=pet-clinic-web/target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]