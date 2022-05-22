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
import org.springframework.web.bind.annotation.*;

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
    public String listPage(Model model){
        List<BookDto> listBookDto = bookService.getAllBookList().stream()
                .map(BookDto::toDto)
                .collect(Collectors.toList());
        model.addAttribute("books", listBookDto);
        return "list";
    }

    @GetMapping("/edit")
    public String editPage(@RequestParam("id") long id, Model model){
        Book book = bookService.findBookById(id).orElseThrow(NotFoundException::new);
        model.addAttribute("book", BookDto.toDto(book));
        return "saved";
    }

    //todo update only title and price
    @PostMapping("/edit")
    public String updateBook(Book book, Model model){
        Book savedBook = bookService.updateBook(book);
        model.addAttribute(savedBook);
        return "saved";
    }

    @PostMapping("/deleteBook/{id}")
    public String deleteBook(BookDto bookDto){
        long idDelete = bookDto.getId();
        bookService.deleteBookById(idDelete);
        return "redirect:/";
    }

    @GetMapping("/save")
    public String addNewBook(Model model){
        //todo перенести в сервис
        Book bookForAddInDb = new Book();
        Author authorForAddInDb = new Author();
        Genre genreForAddInDb = new Genre();
        List<Author> authorsList = authorService.getAllAuthorList();
        List<Genre> genreList = genreService.getAllGenreList();
        model.addAttribute("authors", authorsList);
        model.addAttribute("genres", genreList);
        model.addAttribute("book" ,bookForAddInDb);
        return "saved_new";
    }

    @PostMapping("/save")
    public String saveNewBookInDb(Book book, Author author, Genre genre, Model model){
        Book saved = bookService.saveNewBook(book);
        model.addAttribute(author);
        model.addAttribute(genre);
        model.addAttribute(saved);
        return "saved_new";
    }







//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<String> handleNotFound(NotFoundException ex) {
//        return ResponseEntity.badRequest().body("Not found");
//    }

}
