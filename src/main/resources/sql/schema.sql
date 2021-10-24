CREATE TABLE users(
                      id SERIAL,
                      first_name varchar(50) not null,
                      last_name varchar(50) not null,
                      phone_number varchar(50) unique not null,
                      password varchar(100) not null)