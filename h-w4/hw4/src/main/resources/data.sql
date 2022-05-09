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
values ('Дон Кихот', 412, 4, 1),
       ('Календула', 22, 1, 2),
       ('Иерихон', 432, 2, 3),
       ('Эллизиум', 112, 3, 3),
       ('Денискины рассказы', 1112, 1, 2),
       ('Три мушкетера', 92, 1, 1),
       ('Василий Иванович', 612, 2, 1);

