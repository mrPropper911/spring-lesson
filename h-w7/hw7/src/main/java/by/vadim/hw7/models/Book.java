package by.vadim.hw7.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Book {
    @Id
    private String id;
    private String title;
    private String price;

    @DBRef
    private Author author;

    @DBRef
    private Genre genre;

    private List<Comment> listReview;

    public Book(String title, String price, Author author, Genre genre, Comment... listReview) {
        this.title = title;
        this.price = price;
        this.author = author;
        this.genre = genre;
        this.listReview = Arrays.asList(listReview);
    }
}
