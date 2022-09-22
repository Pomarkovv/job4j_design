create table mashines(
	id serial primary key,
	name varchar(255)
);

create table driverss(
	id serial primary key,
	name varchar(255)
);

create table cars_driverss(
	id serial primary key,
	driver_id int references driverss(id),
	cars_id int references mashines(id)
);
insert into driverss(name) values ('Ivan');
insert into driverss(name) values ('Max');
insert into mashines(name) values ('Mercedes');
insert into mashines(name) values ('Hyndai');

insert into cars_driverss(driver_id, cars_id) values (1, 1);
insert into cars_driverss(driver_id, cars_id) values (1, 2);

select from driverss;
