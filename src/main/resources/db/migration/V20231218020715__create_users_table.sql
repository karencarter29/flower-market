create table if not exists users(
    id              uuid primary key,
    first_name      text,
    last_name       text,
    phone_number    text
)