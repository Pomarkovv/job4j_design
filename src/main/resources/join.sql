create table people(
    id serial primary key,
    name text,
    age int
);

create table inn(
    id serial primary key,
    number int,
    people_id int references people(id)
);

insert into people(name) values ('Ivan');
insert into people(name) values ('Alex');
insert into people(name) values ('Yulia');

insert into inn(number, people_id) values (12345, 1);
insert into inn(number, people_id) values (54321, 2);

select pp.name, i.number from people as pp join inn as i on i.people_id = pp.id;
select pp.name as "Human number", i.number as "individual nalog number" from people as pp join inn as i on i.people_id = pp.id;





