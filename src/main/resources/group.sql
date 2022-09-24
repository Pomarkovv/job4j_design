create table devices(
    id serial primary key,
    name varchar(255),
    price int
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price) values ('iphone 5', 13000);
insert into devices(name, price) values ('iphone 6', 16000);
insert into devices(name, price) values ('iphone 7', 23000);
insert into devices(name, price) values ('iphone 8', 27000);
insert into devices(name, price) values ('iphone 11', 30000);

insert into people(name) values ('Kirill')
insert into people(name) values ('Vlad')


insert into devices_people(device_id, people_id) values (1,1);
insert into devices_people(device_id, people_id) values (2,2);
insert into devices_people(device_id, people_id) values (3,2);
insert into devices_people(device_id, people_id) values (4,1);
insert into devices_people(device_id, people_id) values (5,2);

select avg(price) from devices;

select p.name, avg(d.price) from people p join devices_people dp on dp.people_id = p.id join devices d on dp.device_id = d.id group by p.name;

select p.name, avg(d.price) from people p join devices_people dp on dp.people_id = p.id join devices d on dp.device_id = d.id group by p.name having avg(d.price) > 20000;