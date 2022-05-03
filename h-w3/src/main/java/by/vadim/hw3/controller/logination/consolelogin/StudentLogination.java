package by.vadim.hw3.controller.logination.consolelogin;

import by.vadim.hw3.controller.ExamRunner;
import by.vadim.hw3.controller.logination.Login;
import by.vadim.hw3.entity.Student;
import by.vadim.hw3.service.api.IOService;
import org.springframework.stereotype.Service;

@Service
public class StudentLogination implements Login {
    private final IOService ioService;


    public StudentLogination(IOService ioService) {
        this.ioService = ioService;
    }

    @Override
    public void addLoginInformation(Student student) throws Exception {
        try {
            ioService.out("Hello, what is your name?");
            student.setName(ioService.readString());
            ioService.out("Nice!\nWhat is your surname?");
            student.setSurname(ioService.readString());
            ioService.out("It's a great!\nCan I get information about your student group?");
            student.setNumberOfGroup(Integer.parseInt(ioService.readString()));
            ioService.out("It's cute!\nAnd In the end say your age?");
            student.setAge(Integer.parseInt(ioService.readString()));
            ioService.out("Awesome!!! You personal information will be save!\n");
        } catch (NumberFormatException e) {
            ioService.out("Data entry error . . .\nFor you set default average!");
            student.setName("Ivan");
            student.setSurname("Ivanov");
            student.setAge(0);
            student.setNumberOfGroup(0);
        }
    }
}

