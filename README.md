# Solution for homework from eppTec (bonus task) 

## How to start
- Git clone repository
- Change DB credentials in `application.properties` file if necessary (default `username` = `root`, `password` = `password`)
- `cd` into `epptec-rest-api` folder and run `java -jar epptec-rest-api-0.0.1-SNAPSHOT.jar` in command line
- 

## App features
All data will be stored in a `epptec.people` table in MySQL database. The database schema and table will be created automatically if they don't exist already.
- ### Adding new person  
Provide first name, last name and ID number (must be unique). If first or last name is empty or ID is in incorrect format, an error message will be displayed.
- ### Remove person
Provide ID of the person to remove, if given person is not found, an error message will be displayed.
- ### Find person by ID
Provide ID of the person to print their details (full name, age, ID). If given person is not found, an error message will be displayed.
- ### List people in database
Implemented for testing purposes. Prints details of each person in the database, if the database is empty, a simple message will be displayed instead.
