drop table BOOKINGS if exists;
create table BOOKINGS(ID serial, FIRST_NAME varchar(5) NOT NULL);

drop table CUSTOMERS if exists;
create table CUSTOMERS(id serial, first_name varchar(255), last_name varchar(255));

insert into CUSTOMERS(first_name, last_name) values ('John', 'Woo');
insert into CUSTOMERS(first_name, last_name) values ('Jeff', 'Dean');
insert into CUSTOMERS(first_name, last_name) values ('Josh', 'Bloch');
insert into CUSTOMERS(first_name, last_name) values ('Josh', 'Long');
