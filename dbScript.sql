CREATE DATABASE moneylover_db;

USE moneylover_db;

create table accounts
(
    id        int auto_increment
        primary key,
    user_name varchar(100) not null,
    password  varchar(50)  not null,
    constraint user_name
        unique (user_name)
)
    auto_increment = 2;

create table purposes
(
    id      int auto_increment
        primary key,
    user_id int          not null,
    purpose varchar(200) not null,
    constraint purposes_ibfk_1
        foreign key (user_id) references accounts (id)
);

create index user_id
    on purposes (user_id);

create table users
(
    user_id   int                              not null,
    full_name varchar(100) default 'anonymous' not null,
    avatar    text                             not null,
    constraint user_id
        unique (user_id),
    constraint users_ibfk_1
        foreign key (user_id) references accounts (id)
);

create table wallets
(
    id          int auto_increment
        primary key,
    user_id     int          not null,
    wallet_name varchar(100) not null,
    constraint wallets_ibfk_1
        foreign key (user_id) references accounts (id)
);

create table transaction
(
    id               int auto_increment
        primary key,
    wallet_id        int            not null,
    transacted_money decimal(10, 2) not null,
    purpose_id       int            not null,
    detail           text           null,
    transacted_at    datetime       not null,
    constraint transaction_ibfk_1
        foreign key (wallet_id) references wallets (id),
    constraint transaction_ibfk_2
        foreign key (purpose_id) references purposes (id)
);

create index purpose_id
    on transaction (purpose_id);

create index wallet_id
    on transaction (wallet_id);

create index user_id
    on wallets (user_id);

