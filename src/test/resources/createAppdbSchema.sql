drop table role;
drop table users;
drop table users_roles;


create table  role (
                       id  int8 NOT NULL,
                       name varchar
);


create table users (
                       id int8 NOT NULL,
                       email varchar NOT NULL,
                       username varchar NOT NULL,
                       password varchar NOT NULL,
                       enabled boolean NOT NULL,
                       firstname varchar NOT NULL,
                       lastname varchar NOT NULL,
                       activation_code varchar
);


create table  users_roles (
                              user_id int8 NOT NULL,
                              role_id int8 NOT NULL
);



create sequence public.hibernate_sequence;