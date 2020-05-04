drop table if exists country;

create table country (
    code varchar(2) primary key,
    name varchar(64) not null
)