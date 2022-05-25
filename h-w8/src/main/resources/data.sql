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
       ('Лолита', 122, 2, 3),
       ('Литография', 12, 3, 3),
       ('Cваты', 212, 2, 1);

insert into comments (`name_comment`,`book_id`)
values ('Это шедевр искусства!',1),
       ('Зря потраченное время', 2),
       ('Класс но при частом употребление вызывает рвоту',1);