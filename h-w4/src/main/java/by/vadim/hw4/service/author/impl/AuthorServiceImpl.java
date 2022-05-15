package by.vadim.hw4.service.author.impl;

import by.vadim.hw4.dao.author.AuthorDao;
import by.vadim.hw4.domain.Author;
import by.vadim.hw4.service.author.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorDao authorDao;

    public AuthorServiceImpl(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public List<Author> getAll() {
        return authorDao.getAll();
    }

    @Override
    public Author searchAuthorById(long id) {
        return authorDao.getById(id);
    }
}
