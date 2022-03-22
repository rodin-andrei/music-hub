create table if not exists "client"
(
    id int not null constraint pk_client primary key,
    firstname varchar(70),
    lastname varchar(70),
    mobile_phone varchar(70),
    email varchar(70)

);