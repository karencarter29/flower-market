create table if not exists purchase_flowers
(
    id              uuid primary key,
    bouquet_id      uuid references bouquets (id) not null,
    flower_id       uuid references flowers (id) not null,
    number          bigint
)