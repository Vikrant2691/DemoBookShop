FROM openjdk:17
MAINTAINER vikrant.sonawane
COPY target/DemoBookShop-0.0.1-SNAPSHOT.jar DemoBookShop-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/DemoBookShop-0.0.1-SNAPSHOT.jar"]