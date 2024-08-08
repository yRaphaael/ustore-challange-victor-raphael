# Solved Challenge - Polygon Area Calculation and Salary Report

## Overview

This project contains the solution for two challenges:

1. **Challenge 1:** Calculation of Regular Polygon Areas in Java.
2. **Challenge 2:** Salary Average Report for Employees in the Last 3 Months in SQL.

## Challenge 1 - Polygon Area Calculation

### Project Structure

The Java project is organized as follows:

```
src/
│
├── main/
│   └── java/
│       └── org/
│           └── victor/
│               └── raphael/
│                  │   ├── desafio_1/
│                  │   │   ├── manager/
│                  │   │   │   └── PolygonManager.java
│                  │   │   ├── models/
│                  │   │   │   └── PolygonModel.java
│                  │   │   ├── service/
│                  │   │   │   └── PolygonService.java
│                  │   │   └── CalculatePolygonArea.java
│                  │   └── desafio_2/
│                  │       └── HelpingHumanResourcesSector.sql 
└── test/          │                
    └── java/            
        └── org/
            └── victor/
                └── raphael/
                    └── desafio_1_test/
                        └── unit_tests/
                            └── PolygonsTest.java
```

### Description

- **`PolygonModel.java`:** Defines the data model for a polygon, including the number of sides, side value, polygon type, and calculated area.
- **`PolygonService.java`:** Contains the logic to calculate the area of a polygon based on its sides and determine its type.
- **`PolygonManager.java`:** Responsible for managing the execution of the calculation (not provided in this example).
- **`CalculatePolygonArea.java`:** Main class that initiates the calculation using `PolygonManager`.

### Unit Tests

The unit tests are located in `PolygonsTest.java` and cover:

- Calculation of a triangle's area.
- Calculation of a square's area.
- Calculation of the area of a polygon with more than 4 sides.
- Handling of negative values for the sides.

### Execution

To compile and run the project:

```bash
javac -d out -cp . manager/*.java models/*.java service/*.java CalculatePolygonArea.java
java -cp out org.victor.raphael.desafio_1.CalculatePolygonArea
```

## Challenge 2 - Salary Average Report

### Description

This challenge involves creating a database to store employee information and their salaries. The SQL query calculates the average salary of employees over the last three months and returns the top three employees with the highest average salaries.

### Database Structure

- **`employee` table:** Stores basic employee information.
- **`salary` table:** Stores salary payments and payment dates.

### Creating the Tables

```sql
CREATE DATABASE db_company;

USE db_company;

CREATE TABLE employee (
    id INT(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(250) NOT NULL,
    email VARCHAR(250) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE salary (
    id INT(11) NOT NULL AUTO_INCREMENT,
    value DECIMAL(10, 2) NOT NULL,
    payment_date DATE NOT NULL,
    employee_id INT(11) NOT NULL,
    PRIMARY KEY (id),
    KEY employee_id (employee_id),
    CONSTRAINT salary_ibfk_1 FOREIGN KEY (employee_id)
        REFERENCES employee (id)
);
```

### SQL Query

```sql
SELECT 
    e.id, e.name, AVG(s.value) AS media_salarial
FROM
    employee e
        INNER JOIN
    salary s ON e.id = s.employee_id
WHERE
    s.payment_date >= CURDATE() - INTERVAL 3 MONTH
GROUP BY e.id
ORDER BY media_salarial DESC
LIMIT 3;
```

### Inserting Sample Data

```sql
INSERT INTO employee (name, email) VALUES
('Alice', 'alice@example.com'),
('Bob', 'bob@example.com'),
('Charlie', 'charlie@example.com'),
('David', 'david@example.com'),
('Eve', 'eve@example.com');

INSERT INTO salary (value, payment_date, employee_id) VALUES
(5000, '2024-05-15', 1),
(5200, '2024-06-15', 1),
(5100, '2024-07-15', 1),

(4000, '2024-05-15', 2),
(4100, '2024-06-15', 2),
(4200, '2024-07-15', 2),

(3000, '2024-05-15', 3),
(3100, '2024-06-15', 3),
(3200, '2024-07-15', 3),

(6000, '2024-05-15', 4),
(6200, '2024-06-15', 4),
(6300, '2024-07-15', 4),

(3500, '2024-05-15', 5),
(3600, '2024-06-15', 5),
(3700, '2024-07-15', 5);
```

### Running the Report

The report returns the employees with the highest average salaries over the last three months.