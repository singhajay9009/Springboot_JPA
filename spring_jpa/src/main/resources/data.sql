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