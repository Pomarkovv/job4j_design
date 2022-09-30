create table products (
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);

insert into products(name, producer, count, price) values ('iphone 7', 'Apple', 0, 25000);
insert into products(name, producer, count, price) values ('iphone 10', 'Apple', 3, 40000);
insert into products(name, producer, count, price) values ('iphone 11', 'Apple', 2, 50000);
insert into products(name, producer, count, price) values ('iphone 14', 'Apple', 10, 100000);

create or replace procedure delete_data(i_id integer)
language 'plpgsql'
as $$
    BEGIN
    delete from products where i_id = id and count = 0;
    END
$$;

call delete_data(1);
select * from products;

create or replace function delete_data1(i_id integer)
returns void
language 'plpgsql'
as $$
    BEGIN
    delete from products where i_id = id and count = 0;
    END;
$$;

select * from products;
select delete_data1(5);