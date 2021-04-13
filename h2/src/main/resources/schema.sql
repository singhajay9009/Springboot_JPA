create table laptop (
    id int NOT NULL,
    brand VARCHAR(50),
    make_year int,
    CONSTRAINT pk_student PRIMARY KEY(id)
);

create table student (
    id int NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    hobby VARCHAR(100),
    age int NOT NULL,
    laptop_id int,
    laptop_issue_date DATE,
    CONSTRAINT pk_laptop PRIMARY KEY(id),
    CONSTRAINT laptop_id_fk FOREIGN KEY(laptop_id) REFERENCES laptop(id)
);