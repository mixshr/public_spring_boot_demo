create table nomenclature (
    id uuid not null primary key,
    name text not null,
    number text not null
);

create table warehouse (
    id uuid not null primary key,
    name text not null,
    number text not null
);

create table quantity_in_warehouse (
    id bigint primary key not null generated always as IDENTITY,
    nomenclature uuid REFERENCES nomenclature not null,
    warehouse uuid REFERENCES warehouse not null,
    quantity numeric(15, 4) not null,
    unique (nomenclature, warehouse)
);

drop table quantity_in_warehouse;
drop table warehouse;
drop table nomenclature