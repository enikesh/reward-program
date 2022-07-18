From openjdk:8
copy ./target/calculate-rewards-0.0.1-SNAPSHOT.jar calculate-rewards-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","calculate-rewards-0.0.1-SNAPSHOT.jar"]