package by.vadim.librarysystems.controller;

import by.vadim.librarysystems.domain.Author;
import by.vadim.librarysystems.service.author.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/authors")
@CrossOrigin
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAuthors(){
        return authorService.getAll();
    }

    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable long id){
        return authorService.getById(id);
    }

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) throws URISyntaxException {
        Author authorSaved = authorService.addNew(author);
        return ResponseEntity.created(new URI("/authors/" + authorSaved.getId())).body(authorSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable long id, @RequestBody Author author){
        Author currentAuthor = authorService.getById(id);
        currentAuthor.setName(author.getName());
        currentAuthor.setLocation(author.getLocation());
        currentAuthor = authorService.addNew(currentAuthor);
        return ResponseEntity.ok(currentAuthor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Author> deleteAuthor(@PathVariable long id){
        authorService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
