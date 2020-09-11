This folder is a local git repository. 

# Startup application 
1. Up mongodb container: 
   `docker-compose -f devops/docker-compose.yml up --build -d`
2. Start springboot application with gradle and generate jar
    `./gradlew clean build bootRun`
or
  Start with jar
  `java -jar build/libs/products-api-0.0.1-SNAPSHOT.jar` 
3. Swagger - API Documentation
`http://localhost:8080/swagger-ui.html#/`

`user: daniel`
`password:  daniel`

4. You can use  postman collection attached for examples.
  `cd /postman`

# Accessing mongodb (IDE Web) 
   `http://localhost:8081/` 

# Stop and remove container 
   `docker-compose -f devops/docker-compose.yml down`
   
# Importing code in your IDE 

1. Import gradle project in your intellij for exemple
2. You will need lombok plugin
 
