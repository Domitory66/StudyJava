CREATE TABLE monitor (
                        id serial primary key not null ,
                        model_name varchar(30),
                        diagonal int,
                        resolution varchar(30),
                        time_response int,
);

CREATE TABLE television (
                         id serial primary key not null ,
                         model_name varchar(30),
                         diagonal int,
                         resolution varchar(30),
                         price int,
                         type_led varchar(30)
);