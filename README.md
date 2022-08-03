# Claims-Management-System
This is Java Full-stack project built as part of Cognizant Internship.


These are the following services provided:
## Frontend
* MVC Portal (MediClaim)

## Backend:
* Authorization microservice
* Policy microservice
* Claim microservice
* Member microservice

## Requirements
* Java 8
* Angular 8
* NodeJS
* Eclipse
* Maven
* Postman

## Setup

Launch the above mentioned 4 microservices in your IDE. Import the project as `Maven Project` and wait for the dependencies to install. If any port is unavailable in your machine you can modify the port for the respective microservice in the `application.properties` in
`Backend/Authorization-Microservice/src/main/resources/application.properties`, and you can modify your login credentials in `data.sql` file in `Backend/Authorization-Microservice/src/main/resources/data.sql` and you can do the same for other microservice applications.

After the 4 microservices are up and running launch the claimsApp angular application using `ng serve -o`.
The chrome window will load on it's own.

## Special Feature
You can also check the working of the backend application by running it on `Postman` or `Swagger`.
The swagger file has already been added. Check your port no. and context path from the application.properties file and add `swagger-ui.html` to it.
For reference, `localhost:8400/swagger-ui.html`

## Prototype
The prototype was designed using `Figma`.

## Usage

### Initial Launch

On initial launch of application the user is prompted to the home page of the application.
![HomePage_1](https://user-images.githubusercontent.com/51511924/182536394-9ee33160-c965-4d63-a8dd-c5f9300be244.jpg)

### Login Portal

In the navigation bar user can click the `Login` button for authentication.


The user credentials is provided in the `data.sql` file of Authorization microservice.
`Backend/Authorization-Microservice/src/main/resources/data.sql`
![Login Page](https://user-images.githubusercontent.com/51511924/182536946-9ccf575c-3c7b-456c-a1f1-c155204d0031.jpg)


### Dashboard

You can now access the features as mentioned in the navigation bar.
![Dashboard](https://user-images.githubusercontent.com/51511924/182685054-e8af5a5d-fa8f-4f7b-bcd7-d8e7a409aa48.jpg)

### Bills Portal

Registered users can enter their Member ID to view their bills which includes
* Due Amount
* Last Paid Date
* Premium Amount

You can look for the Member ID from the `data.sql` file in Member Microservice.
![BIlls Portal](https://user-images.githubusercontent.com/51511924/182538224-493f0b6b-4ea1-4047-be69-9d05062c6cd5.jpg)

### Submitting a Claim

If a user wishes to submit a claim, the submit claim form can be used where the user can enter details regarding 
* Policy ID
* Policy Name
* Policy Benefits
* Hospital Name
* Benefits Availed
* Claimed Amount

Based on the details provided the status of the claim is decided to be either `Sanctioned` or `Rejected`.
User will also be alloted a `Claim ID` for future reference.
![Submit Claim](https://user-images.githubusercontent.com/51511924/182685127-0c7aa43b-2c4d-4dd2-978a-3691c3479b36.jpg)

### Claim Status Portal

The user can view the claim status at any time using the `Claim ID` generated in the previous step using the Claim status portal.
![Claims Portal](https://user-images.githubusercontent.com/51511924/182685180-67b88a9f-4916-4204-8e38-e50f86cd4638.jpg)


## Developers
* [Hrithik Raj Prasad](https://github.com/hrithikraj24)
* [Hritick Roy](https://github.com/hr-02)
* [Kanika Sharma](https://github.com/Kanika1012)
* [Manan Kathuria](https://github.com/Mannan05)
