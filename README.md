# Developing Microservices using Netflix Zuul and Spring Cloud (Sample Application) 
This source code is part of the meetup session "Developing Microservices using Netflix Zuul and Spring Cloud". 

## Running the project
Open the project in your preferred IDE and create 4 run configurations for the different Spring Boot applications:
1. Running the GatewayApplication (zuul-gateway) class main method with the following parameters: -Dserver.port=8080
2. Running the MovieServiceApplication (movie-service) class main method with the following parameters: -Dserver.port=8001
3. Running the MovieServiceApplication (movie-service) class main method with the following parameters: -Dserver.port=8002
4. Running the UserServiceApplication (user-service) class main method with the following parameters: -Dserver.port=8003

If you start all the four applications then you can use any Rest client to make API calls to the zuul-gateway and underlying services.

## Available API calls
**http://localhost:8080/users/1** <br/>
Retrieve a single user. You need authentication for this (see the AuthenticationPreFilter for more details).<br/>
**http://localhost:8080/movies/**<br/>
Retrieve a list of movies from the loadbalanced movie-services using Ribbon and Hysterix (see the application.yml for more details).<br/>
**http://localhost:8080/movies/1**<br/>
Retrieve a single movie from the loadbalanced movie-services.<br/>
**http://localhost:8080/metric**<br/>
Retrieve the metrics collected for the above calls (number of calls per request URI)<br/>
<br/>
**Spring Cloud Internal Endpoints:<br/>**
http://localhost:8080/metrics<br/>
http://localhost:8080/routes<br/>
http://localhost:8080/configprops<br/>
