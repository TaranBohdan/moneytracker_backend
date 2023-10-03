create table users
(
    id       bigserial
        primary key,
    username varchar(30) not null unique,
    password varchar(80)
);

create table roles
(
    id   serial      not null
        primary key,
    name varchar(50) not null
);

create table users_roles
(
    user_id bigint not null
        references users (id),
    role_id int    not null
        references roles (id),
    primary key (user_id, role_id)
);

create table wallets
(
    id       serial       not null
        primary key,
    name     varchar(100) not null,
    balance  decimal      not null,
    currency varchar(10)
);

create table users_wallets
(
    user_id bigint not null
        references users (id),
    wallet_id int    not null
        references wallets (id),
    primary key (user_id, wallet_id)
);