create table if not exists bouquets
(
    id              uuid primary key,
    price           double precision,
    order_id        uuid references orders (id),
    packaging_id    uuid references packaging (id) not null
)