FROM adoptopenjdk/openjdk11

COPY ./build/libs/products-api-0.0.1-SNAPSHOT.jar /usr/app/products.jar

WORKDIR /usr/app

ENTRYPOINT ["java","-jar","/usr/app/products.jar"]
