DROP TABLE user_roles;
DROP TABLE user;
DROP TABLE roles;

create table roles
(
    id   int auto_increment
        primary key,
    name varchar(255) null
);

create table user
(
    id       int auto_increment
        primary key,
    login    varchar(255) null,
    name     varchar(255) null,
    password varchar(255) null,
    constraint UK_587tdsv8u5cvheyo9i261xhry
        unique (login)
);

create table user_roles
(
    user_id int not null,
    role_id int not null,
    constraint FKh8ciramu9cc9q3qcqiv4ue8a6
        foreign key (role_id) references roles (id),
    constraint FKhlmdr3u7pdi6gfd47cgcb4p6t
        foreign key (user_id) references user (id)
);

INSERT INTO roles (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (id, name) VALUES (2, 'ROLE_USER');

INSERT INTO user (id, login, name, password) VALUES (1, 'admin', 'tigra', '$2a$10$0RgmvfhdWKSUWgRR5lOCc.UoQCBt60hJuM2Wd3I.1hemzUF0NwFXW');
INSERT INTO user (id, login, name, password) VALUES (2, 'user', 'duck', '$2a$10$.Dcuh0WSMJS4tOMNU7YIMe3VDkLxLrAHiYjgEq26hYpW8uNVZcfzi');

INSERT INTO user_roles (user_id, role_id) VALUES (1, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2);