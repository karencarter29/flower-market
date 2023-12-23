create table if not exists packaging
(
    id          uuid primary key,
    name        text,
    price       double precision
)