package by.vadim.hw8.controller;

import by.vadim.hw8.domain.Author;
import by.vadim.hw8.service.author.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public String listPage(Model model) {
        List<Author> listAutors = new ArrayList<>(authorService.getAllAuthorList());
        model.addAttribute("authors", listAutors);
        return "list_authors";
    }

    @GetMapping("/authorsedit")
    public String editPage(@RequestParam("id") long id, Model model) {
        Author author = authorService.findAuthorById(id).orElseThrow(NotFoundException::new);
        model.addAttribute("author", author);
        return "saved_authors";
    }

    @PostMapping("/authorsedit")
    public String updateAuthor(Author author, Model model) {
        Author authorSaved = authorService.updateAuthor(author);
        model.addAttribute(authorSaved);
        return "saved_authors";
    }

    @PostMapping("/deleteAuthor/{id}")
    public String deleteAuthor(Author author) {
        long idDelete = author.getId();
        authorService.deleteAuthorById(idDelete);
        return "redirect:/authors";
    }

    @GetMapping("/authorsSave")
    public String addNewAuthor(Model model) {
        Author authorForAddinDb = new Author();
        model.addAttribute("author", authorForAddinDb);
        return "saved_new_author";
    }

    @PostMapping("/authorsSave")
    public String addNewAuthorInBd(@ModelAttribute Author author) {
        authorService.saveNewAuthor(author);
        return "redirect:/authors";
    }
}
