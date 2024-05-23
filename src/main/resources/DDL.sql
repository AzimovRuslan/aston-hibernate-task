create table if not exists employee_roles
(
    id   bigint primary key generated always as identity,
    role varchar(50) not null
);

create table if not exists employees_personal_info
(
    id    int primary key generated always as identity,
    email varchar(50) not null unique,
    phone varchar(20) not null unique
);