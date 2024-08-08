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
    value DECIMAL(10 , 2 ) NOT NULL,
    payment_date DATE NOT NULL,
    employee_id INT(11) NOT NULL,
    PRIMARY KEY (id),
    KEY employee_id (employee_id),
    CONSTRAINT salary_ibfk_1 FOREIGN KEY (employee_id)
        REFERENCES employee (id)
);

-- Inserindo dados fictícios na tabela employee
INSERT INTO employee (name, email) VALUES
('Alice', 'alice@example.com'),
('Bob', 'bob@example.com'),
('Charlie', 'charlie@example.com'),
('David', 'david@example.com'),
('Eve', 'eve@example.com');

-- Inserindo dados fictícios na tabela salary
INSERT INTO salary (value, payment_date, employee_id) VALUES
(5000, '2024-05-15', 1),  -- Alice
(5200, '2024-06-15', 1),
(5100, '2024-07-15', 1),

(4000, '2024-05-15', 2),  -- Bob
(4100, '2024-06-15', 2),
(4200, '2024-07-15', 2),

(3000, '2024-05-15', 3),  -- Charlie
(3100, '2024-06-15', 3),
(3200, '2024-07-15', 3),

(6000, '2024-05-15', 4),  -- David
(6200, '2024-06-15', 4),
(6300, '2024-07-15', 4),

(3500, '2024-05-15', 5),  -- Eve
(3600, '2024-06-15', 5),
(3700, '2024-07-15', 5);


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

DROP DATABASE db_company;