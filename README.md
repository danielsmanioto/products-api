This project have as goal exporse uma api where one type of backend can 
mantain them products and expose for others API.

Example 
1. one Bar can list all producsts using this api
2 one employ can mantain the produduct list (insert, update , delete)
3. main features:  list products existents and mantain products

# Startup application 
1. Up mongodb container: 
   `docker-compose -f devops/docker-compose.yml up --build -d`
2. Start springboot application with gradle and generate jar
    `./gradlew clean build bootRun`
or
  Start with jar
  `java -jar build/libs/products-api-0.0.1-SNAPSHOT.jar` 

3. Create a new user ( dont neeed permition)

PUT 
http://localhost:8080/user-application/mannager/new-user

{
  "name": "Administration",
  "username": "root",
  "password": "root",
  "admin" : true
}

4. Swagger - API Documentation
`http://localhost:8080/swagger-ui.html`

use one user and password created


5. For HTTP Requisitions use follow credentials  ( if executed the postman new-user)

`user: root`
`password:  root`

6. You can use  postman collection attached for examples.

import in your postman -> http://localhost:8080/v2/api-docs

# Accessing mongodb (IDE Web) 
   `http://localhost:8081/` 

# Stop and remove container 
   `docker-compose -f devops/docker-compose.yml down`
   
# Importing code in your IDE 

1. Import gradle project in your intellij for exemple
2. You will need lombok plugin
 
 # URL Patterns for follow in this project
  
 1. protected - for users with role user
 2. admin  - for users with role admin

