package by.vadim.hw2;

import by.vadim.hw2.controller.Test;
import by.vadim.hw2.controller.impl.HistoryTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class Main {

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);
        Test service = context.getBean(HistoryTest.class);
        service.startTest();
    }

}
