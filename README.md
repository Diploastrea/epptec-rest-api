# Solution for homework from eppTec (bonus task) 

## How to start
- Git clone repository
- `cd` into `epptec-rest-api` folder and run `java -jar epptec-rest-api-0.0.1-SNAPSHOT.jar` in command line

## General information
All data will be stored in a `epptec.people` table in MySQL database. The database schema and table will be created automatically if they don't exist already.

## Endpoints
- ### POST /api/person
Provide `firstName`, `lastName` and `idNumber` of the person you'd like to add. If any of the input is invalid or `idNumber` already exists in the database, an error message will be returned.  
```
{
    "firstName": "John",
    "lastName": "Doe",
    "idNumber": "901010/1234"
}
```
- ### DELETE /api/person/{id}
Provide `idNumber` of the person you'd like to remove. If provided `idNumber` does not exist in the database, an error message will be returned.
#### DELETE /api/person/9010101234
```
{
    "message": "Removed person successfully."
}
```
- ### GET /api/person/{id}
Provide `idNumber` of the person you'd like to find. If the person exists, their details will be returned, else an error message will be returned instead.
#### GET /api/person/9010101234
```
{
    "firstName": "John",
    "lastName": "Doe",
    "age": 32,
    "idNumber": "901010/1234"
}
```
