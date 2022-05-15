begin transaction;
insert into authors (`name_authors`)
values ('Булгаков М.А.'),
       ('Достоевский Ф.М.'),
       ('Есенин С.А.'),
       ('Пастернак Б.Л.');

insert into genres (`name_genres`)
values ('Роман'),
       ('Поэма'),
       ('Басня');

insert into books(`title`, `price`, `author_id`, `genre_id`)
values ('Дон Кихот', 1, 1, 1),
       ('Календула', 2, 2, 2);
commit;
