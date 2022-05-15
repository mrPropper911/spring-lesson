DROP TABLE IF EXISTS AUTHORS;
CREATE TABLE AUTHORS(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name_authors VARCHAR(255)
);

DROP TABLE IF EXISTS GENRES;
CREATE TABLE GENRES(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name_genres VARCHAR(255)
);

DROP TABLE IF EXISTS BOOKS;
CREATE TABLE BOOKS(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(50) not null,
    price DECIMAL(8,2) not null,
    author_id BIGINT,
    genre_id BIGINT,
    foreign key (author_id) references AUTHORS(id),
    foreign key (genre_id) references GENRES(id)
);
