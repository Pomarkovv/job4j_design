create table phones(
    id serial primary key,
	name varchar(255),
	producer varchar(30)
);

insert into phones(name, producer) values ('iphone', 'Apple');
insert into phones(name, producer) values ('Nokia33-10', 'Nokia');
insert into phones(name, producer) values ('Galaxy 10', 'Samsung');

start TRANSACTION;
insert into phones(name, producer) values ('honorp30', 'Huawey');
SAVEPOINT first_savepoint;
delete from phones where name = 'iphone';
update phones set producer = 'Honor' where producer = 'Huawey';
select * from phones;
rollback to first_savepoint;
select * from phones;
commit TRANSACTION;