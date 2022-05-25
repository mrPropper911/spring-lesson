package by.vadim.hw8.controller;

import by.vadim.hw8.domain.Author;
import by.vadim.hw8.domain.Book;
import by.vadim.hw8.domain.Genre;
import by.vadim.hw8.dto.BookDto;
import by.vadim.hw8.service.author.AuthorService;
import by.vadim.hw8.service.book.BookService;
import by.vadim.hw8.service.genre.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;
    private final GenreService genreService;

    @Autowired
    public BookController(BookService bookService, AuthorService authorService, GenreService genreService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.genreService = genreService;
    }

    @GetMapping("/")
    public String listPage(Model model) {
        List<BookDto> listBookDto = bookService.getAllBookList().stream()
                .map(BookDto::toDto)
                .collect(Collectors.toList());
        model.addAttribute("books", listBookDto);
        return "list";
    }

    @GetMapping("/edit")
    public String editPage(@RequestParam("id") long id, Model model) {
        Book book = bookService.findBookById(id).orElseThrow(NotFoundException::new);
        List<Author> authorsList = authorService.getAllAuthorList();
        List<Genre> genreList = genreService.getAllGenreList();
        model.addAttribute("book", BookDto.toDto(book));
        model.addAttribute("authors", authorsList);
        model.addAttribute("genres", genreList);
        return "saved";
    }

    @PostMapping("/edit")
    public String updateBook(Book book, Model model) {
        Book savedBook = bookService.updateBook(book);
        model.addAttribute(savedBook);
        return "redirect:/";
    }

    @PostMapping("/deleteBook/{id}")
    public String deleteBook(BookDto bookDto) {
        long idDelete = bookDto.getId();
        bookService.deleteBookById(idDelete);
        return "redirect:/";
    }

    @GetMapping("/save")
    public String addNewBook(Model model) {
        Book bookForAddInDb = new Book();
        List<Author> authorsList = authorService.getAllAuthorList();
        List<Genre> genreList = genreService.getAllGenreList();
        model.addAttribute("book", bookForAddInDb);
        model.addAttribute("authors", authorsList);
        model.addAttribute("genres", genreList);
        return "saved_new";
    }

    @PostMapping("/save")
    public String saveNewBookInDb(@Valid Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "saved_new";
        }
        Book saved = bookService.saveNewBook(book);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchBook(Model model, @RequestParam("search") String searchStr) {
        List<BookDto> listBookDto = bookService.searchBookByName(searchStr).stream()
                .map(BookDto::toDto)
                .collect(Collectors.toList());
        model.addAttribute("books", listBookDto);
        return "list";
    }
}
