# Spring CRUD Mobil
Java Spring CRUD Mobil is a web application for managing information about cars. Built using the Spring framework, this application provides functionalities for creating, reading, updating, and deleting car data. It allows users to perform CRUD operations on different types of cars, such as Sedan, SUV, Porsche, and Ford, with a backend database to store and manage the data efficiently.
## Requirements
- Java 11 or newer.
- Maven as the dependency manager.
- MySQL database.
## How to Run

1. **Download the build realease**
- Download and extract the .zip file on the release page.
2. **Configure the database**
- Create a Mysql database
- Import the database schema and seed data from mobil_sirius.sql.
3. **Configure application properties:**
- Open the application-config.properties file.
- Modify the database connection settings (username, password) if needed.
- Optionally, update the server port in the same file.
4. **Run the application:**
- For Unix/Linux
  ````bash
  ./setup.sh
- For Windows
  ````bash
  setup.bat
  
## API Endpoints
- GET /mobil: Get a list of all cars.
- GET /mobil/{id}: Get details of a car by ID.
- POST /mobil: Create a new car.
- PUT /mobil/{id}: Update details of a car.
- DELETE /mobil/{id}: Delete a car by ID.

## Additional Information
- **Front-end Application**: You can also use the front-end application to interact with the back-end. Clone the repository at [fe-mobil-sirius](https://github.com/quenzvezda/fe-mobil-sirius) and follow the instructions in its README to run the front-end application.
- **Database Setup**: Use the provided mobil_sirius.sql file to seed the database with initial data for testing purposes.

   
