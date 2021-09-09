DROP TABLE IF EXISTS product;
create table product (id integer not null, name varchar(255), upc varchar(255) not null, inventory_count integer not null, price float not null, primary key (id));
