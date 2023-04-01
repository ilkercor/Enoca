# Enoca-Backend-Challenge

#### Spring Boot project for Enoca Backend Challenge
-------------------------------------------------

##### 1 - Project Creation
-----------------------
Created a Spring app with Spring Web, Spring Data JPA, MySQL Driver and Lombok dependencies via [Spring Initializr](https://start.spring.io/).
The following properties have been added to the "application.properties" file.

```
spring.datasource.url = jdbc:mysql://localhost:3306/enocadb
spring.datasource.username = root
spring.datasource.password = 12345
```

##### 2 - Database Creation
-----------------------------------
A MySQL database named enocadb was created and two tables named "companies" and "employees" were created.
```
CREATE TABLE `enocadb`.`companies` (
  `company_id` INT NOT NULL AUTO_INCREMENT,
  `company_name` VARCHAR(45) NULL,
  PRIMARY KEY (`company_id`));
```
and
```
CREATE TABLE `enocadb`.`employees` (
  `employee_id` INT NOT NULL AUTO_INCREMENT,
  `company_id` INT NOT NULL,
  `employee_name` VARCHAR(45) NULL,
  `employee_lastname` VARCHAR(45) NULL,
  PRIMARY KEY (`employee_id`));

```

##### 3 - Running the Project
--------------------------------
Now the project is ready to be built and run.
We can use commands to run the project.
```
mvn clean install
mvn spring-boot:run
```
or run it via IDE.

Project will start running on "http://localhost:8080"


##### 4 - API Designs for Management
--------------------------------
```
/company/list
/company/add
/company/update
/company/delete
/company/id={id}
```
```
/employee/list
/employee/add
/employee/update
/employee/delete
/employee/id={id}
```

API designs are basically same for both company table and employee table.
We can list all records from database with following URL it will return Object List in JSON format:
```
/company/list
```
We can add new records to database with following url:
```
/company/add
```
We need to give object to URL with RequestBody. Postman can be used for this.

Then we can update an existing record with this URL:
```
/company/update
```
It also works same with "add endpoint". Update gets Request Body and if records exist in database updates it.
Then delete works with Request Body. We need to give record id to delete.
```
/company/delete
```
Finally "find by id endpoint". It needs Path Variable to find records by id.. 
```
/company/id={id}
Example: "/company/id=4"
```

##### 5 - How do we access data
--------------------------------
In the project we have 4 main packages named Entitites, DataAccess, Service, Controller. We have a multi-layered design.
###### Entities
In the Entities package there are 2 classes named "companies" and "employees". We use these classes when we pass the object.
###### DataAccess (Repository)
There are 2 main packages in the DataAccess package, "Company" and "Employee" for entities. It is the layer where we directly access the database.
For each data access layer, first the necessary interfaces were written, and then database codes were written in the classes that implement these interfaces.
Company Interface:
```
    List<companies> getAll();
    String add(companies companies);
    String update(companies companies);
    String delete(companies companies);
    companies getById(int id);
```
###### Service
It is an additional layer that mediates the communication between the controller and the repository layer.

###### Controller
The controller layer is the layer where the system is managed. 
Incoming requests to the system are received from here and transmitted to the Service and then DataAccess layers, respectively, to be processed through the functions it contains.
```
/company/list
/company/add
/company/update
/company/delete
/company/id={id}
```
```
/employee/list
/employee/add
/employee/update
/employee/delete
/employee/id={id}
```
/list takes all the results from the database and returns it as a List. <br/>
/add saves new records to the database. <br/>
/update updates an existing record in the database. <br/>
/delete deletes a record from the database. <br/>
/id={id} retrieves the record based on the given id.
