# Employee-Management-
Exploring the world of java programming

# Employee Management System

## Overview
This is a simple **Employee Management System** built using **Java Swing**, **JDBC**, and the **ActionListener interface (actionPerformed method)**. It provides a graphical user interface to manage employee records, including adding, updating, deleting, and viewing employee details stored in a database.

## Features
- Add new employees
- insert employee
- Update existing employee details
- Delete employee records
- Search employees by ID

## Technologies Used
- **Java Swing** (for GUI development)
- **JDBC** (for database connectivity)
- **MySQL / Any JDBC-compatible database** (for data storage)

## Setup Instructions

(a) Create a table in your database(name od database is mydb you can change according to your database name if you change the database name then customize the in DBService.java file which is located in src folder) with this scema
![image](https://github.com/user-attachments/assets/adf396ea-5403-42f1-ac29-3bf8f2500a65)


(b) download mysql connector form    this url  https://www.mysql.com/products/connector/
extract this file and look for mysql-connector-j-8.0.31.jar  file and save it to your local disk




1. Clone this repository:
   ```bash
   git clone <repository-url>
   ```
2. Open the project in your preferred Java IDE (Eclipse, IntelliJ, NetBeans, etc.).
3. In Intelij click on menu button ->project structure ->libraries->+->java->select priviously stored jar file ->Apply->apply and close-> ok->ok;
4. In eclipse click on project folder->build path->configure build path->libraries->classpath->select jar file->apply->apply and close. 
5. Configure the **database connection** in the JDBC code (update database URL, username, and password as needed).
6. Run the Java application to start the Employee Management System.

## Screenshots
![image](https://github.com/user-attachments/assets/6eaa1fee-e871-48f7-b4d8-bc59d0a4eb22)


## Contributions
Feel free to contribute to improve the functionality of this project. Fork the repo, make improvements, and submit a pull request.

## License
This project is open-source and available under the MIT License.


