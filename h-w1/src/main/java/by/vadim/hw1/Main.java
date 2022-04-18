package by.vadim.hw1;

import by.vadim.hw1.domain.Question;
import by.vadim.hw1.service.ApplianceService;
import by.vadim.hw1.service.impl.ApplianceServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("/spring-context.xml");

        ApplianceService service = context.getBean(ApplianceService.class);
        service.printQuestion(service.getQuestion());
//        Question first = service.getQuestion();
//        System.out.println("number " + first.getNumberQuestion() + "ques: "
//            + first.getCurrentQuestion() + " answer" + first.getAnswerQuestion() +
//                " true answer " + first.getTrueAnswerQuestion());


    }

}
