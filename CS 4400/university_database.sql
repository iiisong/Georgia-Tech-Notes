-- CS4400: Introduction to Database Systems
-- University Database (Clean WITH Primary Keys and WITHOUT Foreign Keys)
-- Sunday, December 20, 2020

-- This version of the database is intended to work with legacy versions of MySQL
-- It does include the tables and data, which are needed to practice the queries

-- This version also does include primary keys but NOT foreign keys by design

DROP DATABASE IF EXISTS university;
CREATE DATABASE IF NOT EXISTS university;
USE university;

--
-- table structure for table course
--

DROP TABLE IF EXISTS course;
CREATE TABLE course (
  course_name varchar(100) not null,
  course_number varchar(50) not null,
  credit_hours int(11) default null,
  department varchar(20) not null,
  PRIMARY KEY (course_number)
) ENGINE=innodb;

--
-- table data for table course
--

INSERT INTO course VALUES
('Intro To Computer Science','CS1310',4,'CS'),
('Data Structures','CS3320',4,'CS'),
('Database','CS3380',3,'CS'),
('Discrete Mathematics','MATH2410',3,'MATH');

--
-- table structure for table grade_report
--

DROP TABLE IF EXISTS grade_report;
CREATE TABLE grade_report (
  student_number int(11) not null,
  section_identifier int(11) not null,
  grade varchar(2) default null,
  PRIMARY KEY (student_number,section_identifier)
) ENGINE=innodb;

--
-- table data for table grade_report
--

INSERT INTO grade_report VALUES
(8,85,'A'),
(8,92,'A'),
(8,102,'B'),
(8,135,'A'),
(17,112,'B'),
(17,119,'C');

--
-- table structure for table prerequisite
--

DROP TABLE IF EXISTS prerequisite;
CREATE TABLE prerequisite (
  course_number varchar(50) not null,
  prerequisite_number varchar(50) not null,
  PRIMARY KEY (course_number,prerequisite_number)
) ENGINE=innodb;

--
-- table data for table prerequisite
--

INSERT INTO prerequisite VALUES
('CS3320','CS1310'),
('CS3380','CS3320'),
('CS3380','MATH2410');

--
-- table structure for table section
--

DROP TABLE IF EXISTS section;
CREATE TABLE section (
  section_identifier int(11) not null,
  course_number varchar(50) not null,
  semester varchar(20) default null,
  `year` varchar(2) default null,
  instructor varchar(100) default null,
  PRIMARY KEY (section_identifier)
) ENGINE=innodb;

--
-- table data for table section
--

INSERT INTO section VALUES
(85,'MATH2410','Fall','04','King'),
(92,'CS1310','Fall','04','Anderson'),
(102,'CS3320','Spring','05','Knuth'),
(112,'MATH2410','Fall','05','Chang'),
(119,'CS1310','Fall','05','Anderson'),
(135,'CS3380','Fall','05','Stone');

--
-- temporary view structure for view special_sections
--

DROP VIEW IF EXISTS special_sections;
CREATE VIEW special_sections as
SELECT section_identifier, course_number, semester, `year`, instructor
FROM section
WHERE (`year` = '04') or (instructor = 'Anderson');
