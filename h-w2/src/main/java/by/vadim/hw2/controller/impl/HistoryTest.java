package by.vadim.hw2.controller.impl;

import by.vadim.hw2.controller.Test;
import by.vadim.hw2.entity.Question;
import by.vadim.hw2.entity.Student;
import by.vadim.hw2.service.ApplianceService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

//todo need check exception

@PropertySource("classpath:application.properties")
@Service
public class HistoryTest implements Test {
    private final ApplianceService applianceService;

    @Value("${achieve.score}")
    private int rightAnswer;

    public HistoryTest(ApplianceService applianceService) {
        this.applianceService = applianceService;
    }

    @Override
    public void startTest() {
        int scoreRightAnswer = 0;
        Student student = getStartInformation(new Student());
        ArrayList<Question> questionArrayList = applianceService.getQuestion();
        for (int i = 0; i < questionArrayList.size(); i++){
            applianceService.printQuestion(questionArrayList, i);
            String answer = getAnswerInformation();
            scoreRightAnswer += checkAnswer(questionArrayList.get(i), answer);
        }
        checkAchieve(scoreRightAnswer);
    }

    private void checkAchieve(int scoreRightAnswer){
        if(scoreRightAnswer < rightAnswer){
            System.out.println("Bad news, you didn't pass test(");
        } else {
            System.out.println("Congratulation!!! You passed test)");
        }
    }

    private Student getStartInformation(Student student){
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Hello, what is your name?");
            student.setName(bufferedReader.readLine());
            System.out.println("Nice!\nWhat is your surname?");
            student.setSurname(bufferedReader.readLine());
            System.out.println("It's a great!\nCan I get information about your student group?");
            student.setNumberOfGroup(Integer.parseInt(bufferedReader.readLine()));
            System.out.println("It's cute!\nAnd In the end say your age?");
            student.setNumberOfGroup(Integer.parseInt(bufferedReader.readLine()));
            System.out.println("Congratulation!!!\nThe test will start in ");
            timerForStart(3);
            //bufferedReader.close();

        }catch (IOException | InterruptedException e){
            System.out.println("Error #bufferReader1" + Arrays.toString(e.getStackTrace()));
        }
        return student;
    }

    private String getAnswerInformation(){
        String answer = "";
        try {
            //todo !!Scaner have bug
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            //todo timer 60 sec for answer (need to know how delete line from console)
            System.out.println("Your answer is : ");
            answer = bufferedReader.readLine();
            bufferedReader.close();
        } catch (IOException e){
            System.out.println("Error #bufferReader2" + Arrays.toString(e.getStackTrace()));
        }
        return answer;
    }

    private int checkAnswer(Question checkQuestion, String writeAnswer){
        return checkQuestion.getTrueAnswerQuestion().equals(writeAnswer)? 1 : 0;
    }

    private void timerForStart(int timeDelay) throws InterruptedException {
        for (int i = timeDelay; i > 0; i--){
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
