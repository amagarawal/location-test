# location-test
location-test

The Repository consists of two modules, 
- Back-end : Spring boot Rest Application. 
- Front - end : Angular 8 Module front-end.


# Pre-Requsites
 - MongoDB 3+
 - Java 8 or Higher
 - Maven 3.xx or higher
 
### Setting up the Database

Install Mongo Db and create a Mongo Database, the applicaiton is defaulted to "operr_location" and the name of the collection is location. 


## Running the application

### - Backend Spring Boot Application

- To run the applicaiton as a maven task, 
  - ./mvnw spring-boot:run

- To run as a Standalone jar file 
   1. ./mvnw clean install
   2. java -jar target/places-backend-0.0.1-SNAPSHOT.jar
   
  since the applicaiton has some default mongo configuration, to override custom properties, pass spring.data.mongodb configuration as a commanline argument
  For eg. ./mvnw spring-boot:run -Dspring.data.mongodb.uri=mongodb://user:secret@mongo1.example.com:12345
  
  # - Front-End Application

To run the applicaiton, 
 1. Go the front-end code root folder, where you find the package.json file.
 2. 'npm install' - for the first time to download all the project dependencies
 3. 'npm start' - to run the local developement server
 4. 'npm build' - to build the output complie distribution bundle.
 
 Once you start the development server, open your browser and browse through http://localhost:4200
 
 


