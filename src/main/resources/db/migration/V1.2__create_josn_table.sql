create table JSON_EXAMPLE
(
    ID int auto_increment primary key,
    JSON_DATA JSON
);

create table JSON_JOIN_EXAMPLE
(
    ID int auto_increment primary key,
    JSON_EXAMPLE_ID int,
    DESCRIPTION varchar(128)
);