package by.vadim.hw8.service.author.impl;

import by.vadim.hw8.domain.Author;
import by.vadim.hw8.repositories.author.AuthorRepositories;
import by.vadim.hw8.service.author.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepositories authorRepositories;

    @Transactional
    @Override
    public void saveNewAuthor() {

    }

    @Transactional
    @Override
    public void showAllAuthor() {

    }

    @Transactional
    @Override
    public List<Author> getAllAuthorList() {
        List<Author> authorList =
                StreamSupport.stream(authorRepositories
                        .findAll()
                        .spliterator(),false)
                        .collect(Collectors.toList());
        return authorList;
    }

    private String messageAuthor(Author author) {
        String outStrAuthor = "";
        return outStrAuthor + " " + author.getId() + " " + author.getName();
    }

}
