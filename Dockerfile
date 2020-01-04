From openjdk:8
copy ./target/feedbackValidationService-0.0.1-SNAPSHOT.jar feedbackValidationService-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","feedbackValidationService-0.0.1-SNAPSHOT.jar"]