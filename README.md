This folder is a local git repository. 

# Startup application 
1. Up mongodb container: 
   `docker-compose -f devops/docker-compose.yml up --build -d`
2. Start springboot application with gradle and generate jar
    `./gradlew clean build bootRun`

# Swagger - API Documentation
`http://localhost:8080/swagger-ui.html#/`

`user: daniel`
`password:  daniel`

# Accessing mongodb  
   `http://localhost:8081/` 

# Stop and remove container 
   `docker-compose -f devops/docker-compose.yml down`

# Importing code in your IDE 
1. Import gradle project in your intellij for exemple
2. You will need lombok plugin
 
