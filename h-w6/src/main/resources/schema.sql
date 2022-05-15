create table authors (
    id bigserial,
    name_authors varchar(255) not null unique,
    primary key (id)
);

create table genres (
    id bigserial,
    name_genres varchar(255) not null unique,
    primary key (id)
);

create table books (
    id bigserial ,
    title varchar(255) not null unique,
    price double not null,
    author_id bigint references authors(id),
    genre_id bigint references genres(id),
    primary key (id)
);

create table comments (
    id bigserial,
    name_comment varchar(255),
    book_id bigint references books(id) on delete cascade,
    primary key (id)
);