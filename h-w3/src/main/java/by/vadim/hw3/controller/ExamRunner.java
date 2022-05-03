package by.vadim.hw3.controller;

import by.vadim.hw3.controller.logination.Login;
import by.vadim.hw3.entity.Student;
import by.vadim.hw3.service.api.IOService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class ExamRunner implements CommandLineRunner {
    private final Quiz test;
    private final IOService ioService;
    private final Login studentLogin;

    public ExamRunner(@Qualifier("simpleQuiz") Quiz test,
                      IOService ioService,
                      Login studentLogin) {
        this.test = test;
        this.ioService = ioService;
        this.studentLogin = studentLogin;
    }

    @Override
    public void run(String... args) throws Exception {
        ioService.out("Welcome to EXM!!!");
        Student student = Student.getInstance();

        studentLogin.addLoginInformation(student);
        test.startTest(student);
    }
}
