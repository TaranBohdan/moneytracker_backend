insert into roles (name)
values
    ('ROLE_USER'), ('ROLE_ADMIN');

insert into users (username, password)
values
    ('user', 'user'),
    ('admin', 'admin');

insert into users_roles (user_id, role_id)
values
    (1, 1),
    (2, 2);

insert into wallets (name, balance, currency)
values
    ('Cash', 5000, 'UAH');

insert into users_wallets (user_id, wallet_id)
values
    (1, 1),
    (2, 2);