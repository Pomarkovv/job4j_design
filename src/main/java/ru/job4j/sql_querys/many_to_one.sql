CREATE table cooker(
	id serial primary key,
	name varchar(255)
);

CREATE table orders(
	id serial primary key,
	name varchar(255),
	cooker_id int REFERENCES cooker(id)
);
insert into cooker(name) values('shief');
insert into orders(name, cooker_id) VALUES('lazanya', 1);
select * from orders;

