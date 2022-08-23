package by.vadim.hw8.service.author.impl;

import by.vadim.hw8.domain.Author;
import by.vadim.hw8.repositories.author.AuthorRepositories;
import by.vadim.hw8.repositories.author.AuthorRepositoriesJpa;
import by.vadim.hw8.service.author.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepositories authorRepositories;
    private final AuthorRepositoriesJpa authorRepositoriesJpa;

    @Transactional
    @Override
    public Author saveNewAuthor(Author author) {
        Author savedAuthor = authorRepositories.save(author);
        return savedAuthor;
    }

    @Transactional
    @Override
    public List<Author> getAllAuthorList() {
        List<Author> authorList =
                StreamSupport.stream(authorRepositories
                                .findAll()
                                .spliterator(), false)
                        .collect(Collectors.toList());
        return authorList;
    }

    @Transactional
    @Override
    public Author updateAuthor(Author author) {
        authorRepositoriesJpa.updateAuthor(author.getId(),
                author.getName());
        return author;
    }

    @Transactional
    @Override
    public Optional<Author> findAuthorById(long id) {
        return authorRepositories.findById(id);
    }

    @Transactional
    @Override
    public void deleteAuthorById(long id) {
        authorRepositories.deleteById(id);
    }


    private String messageAuthor(Author author) {
        String outStrAuthor = "";
        return outStrAuthor + " " + author.getId() + " " + author.getName();
    }

}
