package by.vadim.hw5;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.SQLException;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws SQLException {
        //SpringApplication.run(Main.class, args);

        ApplicationContext context = SpringApplication.run(Main.class);
        Console.main(args);
    }

}