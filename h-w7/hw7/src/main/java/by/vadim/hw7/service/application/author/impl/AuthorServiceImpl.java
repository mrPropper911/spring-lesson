package by.vadim.hw7.service.application.author.impl;

import by.vadim.hw7.models.Author;
import by.vadim.hw7.repositories.author.AuthorRepository;
import by.vadim.hw7.service.api.IOService;
import by.vadim.hw7.service.application.author.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final IOService ioService;

    @Override
    public void saveNewAuthorInBd() {
        Author author = new Author();

        ioService.out("Enter new author name");
        String authorNameIn = ioService.readString();
        List<Author> listAuthor = (List<Author>) authorRepository.findAll();

        for (Author index : listAuthor) {
            if (index.getName().equals(authorNameIn)) {
                ioService.out("This author exists");
                return;
            }
        }

        author.setName(authorNameIn);
        authorRepository.save(author);
    }

    @Override
    public void showAllAuthorFromBd() {
        List<Author> listAuthor = authorRepository.findAll();
        for (Author index : listAuthor) {
            ioService.out(messageAuthor(index));
        }
    }

    @Override
    public void deleteAuthorFromBd() {
        ioService.out("Enter id author for delete");
        showAllAuthorFromBd();
        String idAuthorForDelete = ioService.readString();
        Optional<Author> author = authorRepository.findById(idAuthorForDelete);
        authorRepository.deleteById(author.orElseThrow().getId());
    }

    private String messageAuthor(Author author) {
        String outStrAuthor = "";
        return outStrAuthor + " " + author.getId() + " " + author.getName();
    }
}
