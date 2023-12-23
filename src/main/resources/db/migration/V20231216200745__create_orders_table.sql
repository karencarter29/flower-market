create table if not exists orders(
    id              uuid primary key,
    first_name      text not null,
    last_name       text not null,
    phone_number    text not null,
    address         text not null,
    date            date not null,
    total_price     double precision,
    notes           text
)