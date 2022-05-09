package by.vadim.hw3.service.shell;

import by.vadim.hw3.controller.impl.SimpleQuiz;
import by.vadim.hw3.controller.logination.consolelogin.StudentLogination;
import by.vadim.hw3.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
@RequiredArgsConstructor
public class ApplicationEventsCommands {

    private final StudentLogination studentLogination;
    private final SimpleQuiz simpleQuiz;
    @ShellMethod(value = "Login command", key = {"l", "login"})
    public String login(@ShellOption(defaultValue = "AnyUser") String userName) throws Exception {
        Student student = Student.getInstance();
        studentLogination.addLoginInformation(student);
        simpleQuiz.startTest(student);
        return String.format("Добро пожаловать: %s", userName);
    }
}
