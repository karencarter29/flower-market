create table if not exists flowers
(
    id          uuid primary key,
    name        text,
    price       double precision
)