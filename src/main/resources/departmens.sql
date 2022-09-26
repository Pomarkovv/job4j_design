
create table departments (
    id serial primary key,
    name varchar(225)
);

create table employees(
    id serial primary key,
    name varchar(255),
    dep_id int references departments(id)
);

create table teens(
    id serial primary key,
    name varchar(255),
    gender varchar(255)
);

insert into departments(name) values ('Juniors'), ('Middles'), ('Seniors'), ('Testers');


insert into employees(name, dep_id) values ('Ivan', 1);
insert into employees(name, dep_id) values ('Petr', 1);
insert into employees(name, dep_id) values ('Evgeniy', 2);
insert into employees(name, dep_id) values ('Nikolay', 2);
insert into employees(name, dep_id) values ('Yulia', 2);
insert into employees(name, dep_id) values ('Nina', 3);
insert into employees(name, dep_id) values ('Svetlana', 3);
insert into employees(name, dep_id) values ('Oleg', 4);
insert into employees(name, dep_id) values ('Viktor', 2);

insert into teens(name, gender) values ('Nina', 'female'), ('Ivan', 'Male'), ('Sveta', 'female'), ('Alex', 'Male'), ('Irina', 'female');

select e.name, d.name from employees e right join departments d on e.dep_id = d.id;
select e.name, d.name from employees e left join departments d on e.dep_id = d.id;
select e.name, d.name from employees e full join departments d on e.dep_id = d.id;

select * from employees e cross join departments d;

select * from departments d left join employees e
on e.dep_id = d.id
where e.id is null;

select e.name, d.name from employees e left join departments d
on e.dep_id = d.id;

select e.name, d.name from departments d right join employees e
on e.dep_id = d.id;

select n1.name as male,
n2.name as female, (
n1.name, n2.name) as "couple"
from teens n1
cross join teens n2
where n1.gender='Male' and n2.gender='female';
