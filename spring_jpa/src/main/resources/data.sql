-- database: mywp_1  ( postgres )

--create table product (
-- id int Primary Key,
-- name varchar(50) not null,
-- description varchar(250) not null,
-- price numeric (8,3)
-- );

Select * from product;

-- Create this table to demonstrate id generation strategy : IDENTITY
--create table employee_id (
--    id SERIAL PRIMARY KEY,
--    name VARCHAR (10) NOT NULL
--);

-- drop table employee_id;

-- this table to demonstrate id generation strategy : TABLE  ( does not work for postgres )
--create table employee_id (
--    id int PRIMARY KEY,
--    name VARCHAR (10)
--);
--
--create table id_gen (
--    gen_name VARCHAR(50) PRIMARY KEY,
--    next_val int   // this column name must be chosen for postgres
--);

-- ===========================
-- Insert into product values (2, 'dell', 'laptop', 400.000);
-- Insert into product values (3, 'nikon', 'camera', 600.000);
-- Insert into product values (4, 'sandisk', 'hard disk', 100.000);

-- ============================
--create table student (
--    id SERIAL PRIMARY KEY,
--    lname VARCHAR (20),
--    fname VARCHAR (20),
--    score int
--);

--create table payment (
--  id int PRIMARY KEY,
--  pmode VARCHAR(2),
--  amount NUMERIC (8,3),
--  cardnumber VARCHAR(20),
--  checknumber VARCHAR(20)
-- );
-- ///////////////////  Table_PER_Class ///////////////////////////////
--create table bank (
--    id int PRIMARY KEY,
--    customer_type VARCHAR (10)
--);
--
--drop table regular_customer;
--drop table privileged_customer;
--
--create table regular_customer(
--    id int PRIMARY KEY,
--    account_number int,
--    customer_type VARCHAR(10),
--    name VARCHAR(20)
--);
--
--create table privileged_customer (
--    id int PRIMARY KEY,
--    account_number int,
--    customer_type VARCHAR(10),
--    name VARCHAR(20)
--);
--
-- ======================== Join Table strategy ======================
--
--create table shop (
--    id int PRIMARY KEY,
--    type VARCHAR (10)
--);
--
--create table employee_shop (
--    id int PRIMARY KEY,
--    name VARCHAR(20),
--    age int,
--    foreign key (id) REFERENCES shop(id)
--);
--
--create table customer_shop (
--    id int PRIMARY KEY,
--    name VARCHAR(20),
--    age int,
--    foreign key (id) REFERENCES shop(id)
--);

-- ========================= Hibernate Embeddable ================================
--create table user_table (
--  id int PRIMARY KEY,
--  name VARCHAR(20),
--  street VARCHAR(10),
--  city VARCHAR(10),
--  zip VARCHAR(10),
--  country VARCHAR(10)
--);

-- ========================= Entity Relationship ===========================
--create table candidate (
--    id SERIAL PRIMARY KEY,
--    name VARCHAR(20)
--);

--create table phone_number(
--    id SERIAL PRIMARY KEY,
--    candidate_id int,
--    ph_number int,
--    type VARCHAR (10),
--    FOREIGN KEY (candidate_id) REFERENCES candidate(id)
--);