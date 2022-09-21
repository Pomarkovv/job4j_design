create table films (
	name varchar(250),
	year INTEGER,
	hasOskar BOOLEAN

);

insert into films(name, year, hasoskar) values ('Titanik', 2000, true);

update films set year = 2001;

delete from films;

select * from films;
