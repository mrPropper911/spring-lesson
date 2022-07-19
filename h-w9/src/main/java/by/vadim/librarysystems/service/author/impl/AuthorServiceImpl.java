package by.vadim.librarysystems.service.author.impl;

import by.vadim.librarysystems.domain.Author;
import by.vadim.librarysystems.repository.author.AuthorRepositoryJpa;
import by.vadim.librarysystems.service.author.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepositoryJpa authorRepositoryJpa;

    @Transactional
    @Override
    public Author addNew(Author author) {
        return authorRepositoryJpa.save(author);
    }

    @Transactional
    @Override
    public Author getById(long id) {
        return authorRepositoryJpa.findById(id).orElseThrow(RuntimeException::new);
    }

    @Transactional
    @Override
    public List<Author> getAll() {
        return StreamSupport.stream(authorRepositoryJpa.findAll()
                .spliterator(),false)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        authorRepositoryJpa.deleteById(id);
    }
}