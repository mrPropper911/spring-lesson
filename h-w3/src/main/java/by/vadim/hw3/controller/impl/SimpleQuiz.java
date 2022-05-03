package by.vadim.hw3.controller.impl;

import by.vadim.hw3.configs.AppProps;
import by.vadim.hw3.controller.Quiz;
import by.vadim.hw3.entity.Question;
import by.vadim.hw3.entity.Student;
import by.vadim.hw3.service.ApplianceService;
import by.vadim.hw3.service.api.IOService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

@Service
public class SimpleQuiz implements Quiz {
    private final ApplianceService applianceService;

    private final AppProps props;

    private final IOService ioService;

    public SimpleQuiz(ApplianceService applianceService, AppProps props, IOService ioService) {
        this.applianceService = applianceService;
        this.props = props;
        this.ioService = ioService;
    }

    @Override
    public void startTest(Student student) throws InterruptedException {
        int scoreRightAnswer = 0;
        timerForStart(props.getTimeDelay());
        ArrayList<Question> questionArrayList = applianceService.getQuestion();
        for (int i = 0; i < questionArrayList.size(); i++) {
            applianceService.printQuestion(questionArrayList, i);
            String answer = getAnswerInformation();
            scoreRightAnswer += checkAnswer(questionArrayList.get(i), answer);
        }
        System.out.println(student);
        checkAchieve(scoreRightAnswer);
    }

    private String getAnswerInformation() {
        ioService.out("Your answer is : ");
        return ioService.readString();
    }

    private int checkAnswer(Question checkQuestion, String writeAnswer) {
        return checkQuestion.getTrueAnswerQuestion().charAt(0) == writeAnswer.charAt(0) ? 1 : 0;
    }

    private void checkAchieve(int scoreRightAnswer) {
        if (scoreRightAnswer < props.getTimeDelay()) {
            ioService.out("\nBad news, you didn't pass test(");
        } else {
            ioService.out("\nCongratulation!!! You passed test)");
        }
    }

    private void timerForStart(int timeDelay) throws InterruptedException {
        ioService.out("The test will start in . . .");
        for (int i = timeDelay; i > 0; i--) {
            TimeUnit.SECONDS.sleep(1);
            System.out.print(i + " .");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(" .");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(" .\n");
        }
        System.out.println(System.lineSeparator().repeat(50));//todo bad clear console
        System.out.println("START!!!");
    }


}
