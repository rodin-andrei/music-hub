create table if not exists "point_of_sale"
(
    id int not null constraint pk_pointOfSale primary key,
    title varchar(70),
    latitude float,
    longitude float,
    offsetGMT int
);