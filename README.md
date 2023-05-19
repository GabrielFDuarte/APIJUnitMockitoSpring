# API JUnit Mockito Spring
This is a Java API for user management, developed using the following technologies: JUnit 5, Mockito, and Spring Boot. The API provides 5 endpoints to perform various operations related to users.

## Endpoints

The following are the available endpoints in this API:

### 1. GET /user/{id}

Returns a specific user based on the provided ID.

**Example Request:**

```
GET /user/1
```

**Example Response:**

```
{
  "id": 1,
  "name": "Gabriel",
  "email": "gabriel@email.com"
}
```

### 2. GET /user

Returns all users present in the database.

**Example Request:**

```
GET /user
```

**Example Response:**

```
[
  {
    "id": 1,
    "name": "Gabriel",
    "email": "gabriel@email.com"
  },
  {
    "id": 2,
    "name": "Aline",
    "email": "aline@email.com"
  },
  ...
]
```

### 3. POST /user

Creates a new user in the database based on the data provided in a JSON in the request body.

**Example Request:**

```
POST /user

Body:
{
  "name": "Alice Brown",
  "email": "alice@email.com",
  "password": "123"
}
```

**Example Response:**

```
Status: 201 Created
```

### 4. PUT /user/{id}

Updates the information of an existing user based on the provided ID. The data to be updated should be sent in a JSON in the request body.

**Example Request:**

```
PUT /user/1

Body:
{
  "name": "Gabriel Update",
  "email": "gabriel@email.com"
  "password": "123"
}
```

**Example Response:**

```
{
  "id": 1,
  "name": "Gabriel Update",
  "email": "gabriel@email.com"
}
```

### 5. DELETE /user/{id}

Removes a user from the database based on the provided ID.

**Example Request:**

```
DELETE /user/1
```

**Example Response:**

```
Status: 204 No Content
```

## Running the Project

To run the project locally, follow the instructions below:

1. Make sure you have the Java Development Kit (JDK) installed on your machine.
2. Clone this GitHub repository: `git clone https://github.com/GabrielFDuarte/APIJUnitMockitoSpring.git`
3. Navigate to the project directory: `cd APIJUnitMockitoSpring`
4. Open the `application.properties` file and locate the property `server.port`. By default, it is set to `8090`.
5. If you want to run the project on a different port, modify the value of `server.port` in the `application.properties` file.
6. Execute the command to compile the project: `./mvnw clean package`
7. After a successful compilation, run the command to start the application: `./mvnw spring-boot:run`
8. The API will be available at `http://localhost:8090`. If you changed the port in step 5, replace `8090` with the chosen port.
9. Test the API using your preferred HTTP client, such as cURL or Postman.

Remember to ensure that the chosen port is not already in use by another application on your machine.

## Testing

The project includes automated tests implemented with JUnit 5 and Mockito. These tests ensure the integrity and proper functioning of the API. To execute the tests, you can use the following command:

```
./mvnw test
```

This will run all the automated tests in the project and provide information about the test results.

## Contribution

If you wish to contribute to this project, follow the steps below:

1. Fork this repository.
2. Create a new branch for your contribution: `git checkout -b my-contribution`.
3. Make the desired changes and stage them: `git add .`.
4. Commit your changes: `git commit -m "My contribution"`.
5. Push to the remote repository: `git push origin my-contribution`.
6. Open a pull request in the original repository, describing your changes.
