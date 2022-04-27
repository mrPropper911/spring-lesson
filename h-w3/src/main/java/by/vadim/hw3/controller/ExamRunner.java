package by.vadim.hw3.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class ExamRunner implements CommandLineRunner {
    private Test test;

    public ExamRunner(@Qualifier("historyTest") Test test) {
        this.test = test;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Welcome to EXM!!!");
        test.startTest();
    }
}
