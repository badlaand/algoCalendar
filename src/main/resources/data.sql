DROP TABLE IF EXISTS employees;
 
CREATE TABLE employees (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  mail VARCHAR(250) NOT NULL,
  pasword VARCHAR(250) NOT NULL
);
 
INSERT INTO employees (first_name, last_name, mail, pasword) VALUES
  ('Laurent', 'GINA', 'laurentgina@mail.com', 'laurent'),
  ('Sophie', 'FONCEK', 'sophiefoncek@mail.com', 'sophie'),
  ('Agathe', 'FEELING', 'agathefeeling@mail.com', 'agathe');
  
  DROP TABLE IF EXISTS jours;
 
CREATE TABLE jours (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nomjour VARCHAR(250) NOT NULL,
  date DATE NOT NULL,
  isWorked BOOLEAN NOT NULL
 );