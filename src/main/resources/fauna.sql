create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna (name, avg_age, discovery_date) values ('Tiger', 11000, date '2016-09-01');
insert into fauna (name, avg_age, discovery_date) values ('Fish', 23000, date '2017-03-05');
insert into fauna (name, avg_age, discovery_date) values ('Mouse', 5000, date '1943-04-02');
insert into fauna (name, avg_age, discovery_date) values ('Dyno', 16000, null);

select * from  fauna where name like '%Fish%';
select * from fauna where avg_age >= 10000 and avg_age <= 21000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < '1950-01-01';
