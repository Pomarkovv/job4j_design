create table car_bodies(
    id serial primary key,
    name varchar(255)
);

create table car_engines(
    id serial primary key,
    name varchar(255)
);

create table car_transmissions(
    id serial primary key,
    name varchar(255)
);

create table cars (
    id serial primary key,
    name varchar(255),
    body_id int references car_bodies(id),
    eng_id int references car_engines(id),
    trans_id int references car_transmissions(id)
);

insert into car_bodies(name) values ('1X1234'), ('1Y2341'), ('3V2321'), ('2C3421');
insert into car_engines(name) values ('JZX-6.5'), ('V8-7.2'), ('Niss-1.3'), ('UrusEng12');
insert into car_transmissions(name) values ('ertyu'), ('asdfg'), ('putinVor'), ('Uzxcvg');

insert into cars(name, body_id, eng_id, trans_id) values ('Nissan AD', 1, 1, 1), ('LandCruiser200', 2, 2, 2), ('Lambo', 3, 3, 3);
insert into cars(name, body_id, trans_id) values ('Lada', 4, 4);

select c.name car, b.name body, e.name engine, t.name transmission from cars c
left join car_bodies b on c.body_id = b.id
left join car_engines e on c.eng_id = e.id
left join car_transmissions t on c.trans_id = t.id
order by c.name;

select b.name from car_bodies b left join cars c on c.body_id = b.id where c.id is null;
select e.name from car_emgines e left join cars c on c.eng_id = e.id where c.id is null;
select t.name from car_transmissions t left join cars c on c.trans_id = t.id where c.id is null;
