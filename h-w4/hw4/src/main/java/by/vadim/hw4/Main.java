package by.vadim.hw4;

import by.vadim.hw4.dao.book.BookDao;
import by.vadim.hw4.domain.Author;
import by.vadim.hw4.domain.Book;
import by.vadim.hw4.domain.Genre;
import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class Main {

    public ApplicationEventMulticaster applicationEventMulticaster() {
        SimpleApplicationEventMulticaster eventMulticaster = new SimpleApplicationEventMulticaster();
        eventMulticaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
        return eventMulticaster;
    }

    public static void main(String[] args) throws SQLException {
       // SpringApplication.run(Main.class, args);

        ApplicationContext context = SpringApplication.run(Main.class);
        BookDao dao = context.getBean(BookDao.class);
//        Author as = new Author(1,"Dar");
//        Genre ass = new Genre(1, "da");
//        Book a = new Book(8,"awdawa",123,as, ass);
//        System.out.println(a);
//        dao.insert(a);
//        List<Book> list = dao.getAll();
//        for (Book index : list){
//            System.out.println(index.getId());
//            System.out.println(index.getAuthor());
//        }

        Console.main(args);

    }


}
