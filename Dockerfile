FROM openjdk:8
ADD target/questions-service.jar questions-service.jar
EXPOSE 8181
ENTRYPOINT ["java","-jar","questions-service.jar"]