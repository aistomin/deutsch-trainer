create table dt_user
(
    id       bigserial
        constraint dt_user_pk
            primary key,
    username varchar(255) not null,
    password varchar(255)
);

create unique index dt_user_id_uindex
    on dt_user (id);

create unique index dt_user_username_uindex
    on dt_user (username);
