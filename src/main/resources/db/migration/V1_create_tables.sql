CREATE TABLE product (
    id serial not null primary key,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price NUMERIC(10, 2) NOT NULL,
    ingredient JSONB NOT NULL,
    slug VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);

create table ingredient (
    id serial PRIMARY KEY AUTO_INCREMENT,
    name varchar(255) not null,
    quantity_in_stock numeric(10, 2) not null,
    unity varchar(255) not null,
    slug varchar(255) not null,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);