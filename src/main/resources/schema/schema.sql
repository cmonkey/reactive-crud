drop table if exists catalogue_items;
create table catalogue_items(
    id int primary key auto_increment not null,
    sku_number varchar(16) not null,
    item_name varchar(255) not null,
    inventory int not null,
    created_on timestamp not null default now(),
    updated_on timestamp not null default now()
);