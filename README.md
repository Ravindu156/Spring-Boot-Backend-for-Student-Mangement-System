# Spring Boot Backend for Student Management System

This is a simple Spring Boot backend application for managing student data. It provides RESTful API endpoints to perform CRUD (Create, Read, Update, Delete) operations on student records, as well as some additional functionalities like finding students by age and sorting students by GPA.

## Technologies Used

* Java
* Spring Boot
* Maven (or Gradle, depending on your project setup)

## API Endpoints

The application exposes the following API endpoints under the base path `/app`:

**GET Requests:**

* `/app/student`: Returns a predefined student object (Bob Marely).
* `/app/all-students`: Returns a list of all student objects currently stored in memory.
* `/app/student/{regno}`: Returns a specific student based on their registration number (`regno`) provided in the path.
* `/app/student/by-age`: Returns a list of students whose age is strictly between 20 and 23.
* `/app/order/all-students`: Returns a list of all students, sorted in descending order based on their GPA.
* `/app/msg`: Returns a simple message "Hello SpringBoot".
* `/app/name`: Returns a simple message "My name is SpringBoot".
* `/app/age/{ag}`: Returns a message indicating the age provided in the path variable (`ag`).
* `/app/course/{uni}/{crs}`: Returns a message indicating the university (`uni`) and course (`crs`) provided in the path variables.

**POST Request:**

* `/app/student/add`: Adds a new student to the list. The student data should be provided in the request body as a JSON object.

**PUT Request:**

* `/app/student/update/{regno}`: Updates the information of an existing student with the given registration number (`regno`). The updated student data should be provided in the request body as a JSON object.

**DELETE Request:**

* `/app/student/delete/{regno}`: Deletes a student from the list based on their registration number (`regno`) provided in the path. Returns a success or not found message.

## Models

The application uses a `Student` model with the following attributes:

* `regNo` (String): Registration Number (Unique identifier)
* `name` (String): Student's Name
* `age` (int): Student's Age
* `course` (String): Student's Course
* `gpa` (double): Student's Grade Point Average

## How to Run the Application

1.  **Prerequisites:**
    * Java Development Kit (JDK) installed.
    * Maven or Gradle installed (depending on your project setup).

2.  **Clone the Repository (if applicable):**
    ```bash
    git clone <repository_url>
    cd <project_directory>
    ```

3.  **Build the Application:**
    * **Using Maven:**
        ```bash
        mvn clean install
        ```
    * **Using Gradle:**
        ```bash
        gradle clean build
        ```

4.  **Run the Application:**
    * **Using Maven:**
        ```bash
        mvn spring-boot:run
        ```
    * **Using Gradle:**
        ```bash
        gradle bootRun
        ```
    * **Using the JAR file (after building):**
        Navigate to the `target` (for Maven) or `build/libs` (for Gradle) directory and run:
        ```bash
        java -jar <your-application-name>.jar
        ```

5.  **Access the API:** Once the application is running, you can access the API endpoints using a tool like your web browser, Postman, `curl`, etc. The application will be running on `http://localhost:8081` (as configured in the `application.properties`).

    **Example Requests:**

    * **Get all students:** `http://localhost:8081/app/all-students`
    * **Get student by registration number:** `http://localhost:8081/app/student/2020ICT02`
    * **Add a new student (POST request with JSON body):** `http://localhost:8081/app/student/add`
        ```json
        {
            "regNo": "2023ICT04",
            "name": "Saman Kumara",
            "age": 21,
            "course": "Engineering",
            "gpa": 3.55
        }
        ```
    * **Update a student (PUT request with JSON body):** `http://localhost:8081/app/student/update/2021ICT01`
        ```json
        {
            "name": "Bob Marley Updated",
            "age": 24,
            "course": "Information Technology",
            "gpa": 3.30
        }
        ```
    * **Delete a student:** `http://localhost:8081/app/student/delete/2022ICT03`

## Important Notes

* The student data is currently stored in an in-memory `ArrayList`. This means that the data will be lost when the application restarts. For persistent storage, you would typically integrate with a database (e.g., MySQL, PostgreSQL, MongoDB).
* The application does not include any form of authentication or authorization.
* This is a basic example and can be further enhanced with features like input validation, error handling, pagination, and more robust data management.

## Further Development

Possible future enhancements include:

* Integrating with a database for persistent storage.
* Implementing proper error handling and validation.
* Adding pagination to the `/all-students` endpoint.
* Implementing authentication and authorization for API access.
* Adding more sophisticated search and filtering capabilities.
