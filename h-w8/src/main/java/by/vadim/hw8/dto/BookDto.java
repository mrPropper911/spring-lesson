package by.vadim.hw8.dto;

import by.vadim.hw8.domain.Author;
import by.vadim.hw8.domain.Book;
import by.vadim.hw8.domain.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private long id;
    private String title;
    private double price;
    private Author author;
    private Genre genre;

    public static Book toDomainObject(BookDto bookDto){
        return new Book(bookDto.getId(),bookDto.getTitle(), bookDto.getPrice(),
                bookDto.getAuthor(), bookDto.getGenre(), null);
    }

    public static BookDto toDto(Book book){
        return new BookDto(book.getId(), book.getTitle(), book.getPrice(),
                book.getAuthor(), book.getGenre());
    }
}
