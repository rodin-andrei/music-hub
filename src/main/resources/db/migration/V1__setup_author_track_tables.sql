create sequence if not exists hibernate_sequence;

create table if not exists "author"
(
    id int not null constraint pk_author primary key,
    firstname varchar(70),
    lastname varchar(70),
    pseudonym varchar(70)
);

create table if not exists "track"
(
    id int not null constraint pk_track primary key,
    title varchar(70),
    time int,
    genre varchar(70)
);

create table if not exists "track_author"
(
    author_id int not null constraint fk_author_track references author on delete cascade,
    track_id  int not null constraint fk_track_author references track on delete cascade,
    constraint pk_track_author primary key (author_id, track_id)
);