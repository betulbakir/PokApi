## Pokemon API Project

Hello and welcome to Pokemon API project!
This API allows you to retrieve information about Pokemon, including the heaviest Pokemon, highest Pokemon, and Pokemon with the most base experience.
## Getting Started

## Base URL

The base URL for accessing the Pokémon API is: https://pokeapi.co/api/v2/

## Endpoints
### Retrieve the 5 heaviest Pokémons
Endpoint: /pokemon/heaviest

Method: GET

### Retrieve the 5 highest Pokémons
Endpoint: /pokemon/highest

Method: GET

### Retrieve the 5 Pokémons with more base experience
Endpoint: /pokemon/base_experience

Method: GET

## Required Tools

Java 17
Spring framework

## Running the Application Locally

To run the application locally (on the project root), you can use the Spring Boot Maven plugin as follows:

```
$  ./mvnw spring-boot:run
```
This command will start the application on your local machine.

## Running Tests

To run the tests for the application, you can use the following command (on the project root):

```
$  ./mvnw test
```
This command will build the tests and execute them, providing you with feedback on the success or failure of each test.





