create table type(
    id serial primary key,
    name text
);

create table product(
    id serial primary key,
    name text,
    type_id int references type(id),
    expired_date date,
    price int
);

insert into type(name) values ('chees');
insert into type(name) values ('milk');
insert into type(name) values ('soar cream');

insert into product(name, type_id, expired_date, price) values ('filimonovo', 2, '2022-09-25', 100);
insert into product(name, type_id, expired_date, price) values ('blue chees', 1, '2022-11-15', 500);
insert into product(name, type_id, expired_date, price) values ('prostokvashino', 3, '2022-09-27', 120);
insert into product(name, type_id, expired_date, price) values ('brazhnoe', 2, '2022-09-24', 100);
insert into product(name, type_id, expired_date, price) values ('parmezan', 1, '2023-05-25', 900);
insert into product(name, type_id, expired_date, price) values ('snow', 3, '2022-09-29', 110);

select * from product join type tp on type_id = tp.id where tp.name LIKE 'cheese';

select * from product where name LIKE 'milk';

select max(price) from product;

select tp.name, count(*) from product p join type tp on type_id = tp.id group by tp.name;

select * from product join type tp on type_id = tp.id where tp.name LIKE 'chees' and tp.name LIKE 'milk';

select tp.name from product p join type tp on p.type_id = tp.id group by tp.name having count(*) < 10;

select * from type join product on product.type_id = type.id;