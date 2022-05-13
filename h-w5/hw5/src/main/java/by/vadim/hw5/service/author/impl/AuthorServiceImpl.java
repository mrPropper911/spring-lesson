package by.vadim.hw5.service.author.impl;

import by.vadim.hw5.models.Author;
import by.vadim.hw5.repositories.author.AuthorRepositories;
import by.vadim.hw5.service.api.IOService;
import by.vadim.hw5.service.author.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepositories authorRepositories;
    private final IOService ioService;

    @Override
    public void saveNewAuthor() {
        ioService.out("Enter new author name");
        Author author = new Author();
        String authorNameIn = ioService.readString();

        List<Author> listAuthor = authorRepositories.findAll();
        for (Author index: listAuthor){
            if(index.getName().equals(authorNameIn)){
                ioService.out("This author exists");
                return;
            }
        }

        author.setName(authorNameIn);
        authorRepositories.save(author);
    }

    @Override
    public void showAllAuthor() {
        List<Author> listAuthor = authorRepositories.findAll();
        for (Author index: listAuthor){
            ioService.out(messageAuthor(index));
        }
    }

    private String messageAuthor(Author author){
        String outStrAuthor = "";
        return outStrAuthor + " " + author.getId() + " " + author.getName();
    }


}
