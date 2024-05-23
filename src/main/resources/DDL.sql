create table if not exists employee_roles
(
    id   bigint primary key generated always as identity,
    role varchar(50) not null
);