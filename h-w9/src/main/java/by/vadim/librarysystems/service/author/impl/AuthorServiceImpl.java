package by.vadim.librarysystems.service.author.impl;

import by.vadim.librarysystems.repository.author.AuthorRepositoryJpa;
import by.vadim.librarysystems.service.author.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepositoryJpa authorRepositoryJpa;



}
