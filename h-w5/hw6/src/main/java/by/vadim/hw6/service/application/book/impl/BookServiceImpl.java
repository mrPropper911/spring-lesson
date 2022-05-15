package by.vadim.hw6.service.application.book.impl;

import by.vadim.hw6.repositories.BookRepositories;
import by.vadim.hw6.service.api.IOService;
import by.vadim.hw6.service.application.book.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepositories bookRepositories;
    private final IOService ioService;

    @Override
    public void saveNewBook() {

    }

    @Override
    public void showAllBook() {

    }

    @Override
    public void findBookByName() {

    }

    @Override
    public void updateTitleBookById() {

    }

    @Override
    public void deleteBookById() {

    }
}
