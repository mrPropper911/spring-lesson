drop table if exists books;
drop table if exists authors;
create table authors
(
    id   bigint auto_increment,
    name varchar(255) not null unique,
    location varchar(255) not null,
    primary key (id)
);

create table books
(
    id        bigint auto_increment,
    title     varchar(255) not null unique,
    author_id bigint references authors (id),
    primary key (id)
);