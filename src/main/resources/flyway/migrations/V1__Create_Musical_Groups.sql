-- Drop the database and tables if they exist
DROP DATABASE IF EXISTS musical_groups;

-- Create the musical_groups database
CREATE DATABASE musical_groups;

-- Switch to the musical_groups database
USE musical_groups;

-- Create the instruments table
CREATE TABLE instruments (
  instrument_id INT PRIMARY KEY AUTO_INCREMENT,
  name ENUM('viola', 'violin', 'cello')
);

-- Create the musical_groups table
CREATE TABLE musical_groups (
  group_id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50)
);

-- Create the students table
CREATE TABLE students (
  student_id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50),
  email VARCHAR(50),
  grade ENUM('beginner', 'intermediate', 'advanced'),
  instrument_id INT,
  group_id INT,
  FOREIGN KEY (instrument_id) REFERENCES instruments (instrument_id),
  FOREIGN KEY (group_id) REFERENCES musical_groups (group_id)
);


