# Claims-Management-System
This is Java Full-stack project built as part of Cognizant Internship.


These are the following services provided:

## Frontend
* MVC Portal(MediClaim)

## Backend:
* Authorization microservice
* Member microservice
* Claim microservice
* Policy microservice

## Requirements
* Java 8
* Angular 8
* NodeJS
* Eclipse
* Maven
* Postman

## Setup

Launch the above mentioned 4 microservices in your IDE. Import the project as `Maven Project` and wait for the dependencies to install. If any port is unavailable in your machine you can change the port for the respective microservice in the `application.properties` in
`Backend/Authorization-Microservice/src/main/resources/application.properties`, and you can modify your login credentials and other data in data.sql file in `Backend/Authorization-Microservice/src/main/resources/data.sql` and you can do the same for other microservice applications.

After the 4 microservices are up and running launch the claimsApp angular application using `ng serve -o`.
The chrome window will load on it's own.

# Special Feature
You can also check the working of the application by running it on Postman or swagger.
The swagger file has already been added. Check your port no. from the application.properties file and also the context path and `swagger-ui.html` to it.
For reference, `localhost:8400/swagger-ui.html`

## Usage

### Initial Launch

On initial launch of application the user is prompted with a home page of the application.
![HomePage_1](https://user-images.githubusercontent.com/51511924/182536394-9ee33160-c965-4d63-a8dd-c5f9300be244.jpg)
