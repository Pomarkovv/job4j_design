
create table role(
    id serial primary key,
    title varchar(255)
);

create table users(
    id serial primary key,
    username text,
    role_id int references role(id)
);

create table rules(
    id serial primary key,
    title varchar(255)
);

create table role_rules (
    id serial primary key,
    roles_id int references role(id),
    rule_id int references rules(id)
);

create table category(
    id serial primary key,
    title varchar(255)
);

create table state(
    id serial primary key,
    status text
);

create table item(
    id serial primary key,
    title varchar(255),
    user_id int references users(id),
    categor_id int references category(id),
    states_id int references state(id)
);

create table comments(
    id serial primary key,
    comments text,
    items_id int references item(id)
);

create table attachs(
    id serial primary key,
    numbers int,
    items_id int references item(id)
);
