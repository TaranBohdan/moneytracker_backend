create table entries
(
    id       serial      not null,
    note     varchar(255),
    value    decimal     not null,
    category varchar(50) not null,
    type     varchar(50) not null,
    date     date        not null,
    wallet_id   integer     not null
        references wallets (id)
);