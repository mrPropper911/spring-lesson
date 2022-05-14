package by.vadim.hw6.service.application.author.impl;

import by.vadim.hw6.models.Author;
import by.vadim.hw6.repositories.AuthorRepositories;
import by.vadim.hw6.service.api.IOService;
import by.vadim.hw6.service.application.author.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepositories authorRepositories;
    private final IOService ioService;

    @Override
    public void saveNewAuthorInBd() {
        Author author = new Author();

        ioService.out("Enter new author name");
        String authorNameIn = ioService.readString();
        List<Author> listAuthor = (List<Author>) authorRepositories.findAll();

        for (Author index : listAuthor) {
            if (index.getName().equals(authorNameIn)) {
                ioService.out("This author exists");
                return;
            }
        }

        author.setName(authorNameIn);
        authorRepositories.save(author);
    }

    @Override
    public void showAllAuthorFromBd() {
        List<Author> listAuthor = (List<Author>) authorRepositories.findAll();
        for (Author index : listAuthor) {
            ioService.out(messageAuthor(index));
        }
    }

    @Override
    public void deleteAuthorFromBd() {
        ioService.out("Enter id author for delete");
        showAllAuthorFromBd();

        long idAuthorForDelete = Long.parseLong(ioService.readString());
        Optional<Author> author = authorRepositories.findById(idAuthorForDelete);
        authorRepositories.deleteById(author.orElseThrow().getId());
    }

    private String messageAuthor(Author author) {
        String outStrAuthor = "";
        return outStrAuthor + " " + author.getId() + " " + author.getName();
    }

}
