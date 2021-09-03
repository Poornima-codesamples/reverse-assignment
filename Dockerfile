FROM openjdk:15
ADD target/assignment.jar assignment.jar
EXPOSE 8086
ENTRYPOINT ["java","-jar","assignment.jar"]