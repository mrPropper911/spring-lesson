package by.vadim.librarysystems.dto;

import by.vadim.librarysystems.domain.Author;
import by.vadim.librarysystems.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private long id;
    private String title;
    private Author author;

    public static Book toDomainObject(BookDto bookDto){
        return new Book(bookDto.getId(), bookDto.getTitle(), bookDto.getAuthor());
    }

    public static BookDto toDto(Book book){
        return new BookDto(book.getId(), book.getTitle(), book.getAuthor());
    }
}
