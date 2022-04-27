package by.vadim.hw3.controller.impl;

import by.vadim.hw3.configs.AppProps;
import by.vadim.hw3.controller.Test;
import by.vadim.hw3.entity.Question;
import by.vadim.hw3.entity.Student;
import by.vadim.hw3.service.ApplianceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

@Service
public class HistoryTest implements Test {
    private final ApplianceService applianceService;

    private final AppProps props;

    public HistoryTest(ApplianceService applianceService, AppProps props) {
        this.applianceService = applianceService;
        this.props = props;
    }

    @Override
    public void startTest() throws InterruptedException {
        int scoreRightAnswer = 0;
        Student student = Student.getInstance();
       // student.setStudentInformation();
        //timerForStart(props.getTimeDelay());
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
        //todo timer 60 sec for answer (need to know how delete line from console)
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your answer is : ");
        String answer = scanner.nextLine();
        return answer;
    }

    private int checkAnswer(Question checkQuestion, String writeAnswer) {
        if (checkQuestion.getTrueAnswerQuestion().charAt(0) == writeAnswer.charAt(0)) {
            System.out.println("Correct answer!");
            return 1;
        } else {
            System.out.println("Wrong answer!");
            return 0;
        }
    }

    private void checkAchieve(int scoreRightAnswer) {
        if (scoreRightAnswer < props.getTimeDelay()) {
            System.out.println("\nBad news, you didn't pass test(");
        } else {
            System.out.println("\nCongratulation!!! You passed test)");
        }
    }

    private void timerForStart(int timeDelay) throws InterruptedException {
        System.out.println("The test will start in . . .");
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
