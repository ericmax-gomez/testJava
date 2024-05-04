DROP SCHEMA IF EXISTS testJava;
CREATE SCHEMA testJava;
USE testJava;

CREATE TABLE vehiculo (
  id int NOT NULL AUTO_INCREMENT primary key,
  marca VARCHAR(100) NOT NULL,
  modelo varchar(100) NOT NULL,
  matricula varchar(20) not null,
  color varchar(50) not null,
  anio int not null
);

