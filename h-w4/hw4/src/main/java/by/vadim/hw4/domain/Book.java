package by.vadim.hw4.domain;

import lombok.Data;

@Data
public class Book {
    private final long id;
    private final String title;
    private final double price;
    private final Author author;
    private final Genre genre;
}
