package by.vadim.hw2.service.impl;

import by.vadim.hw2.dao.ApplianceDAO;
import by.vadim.hw2.entity.Question;
import by.vadim.hw2.service.ApplianceService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@PropertySource("classpath:application.properties")
@Service
public class ApplianceServiceImpl implements ApplianceService {
    private ApplianceDAO dao;

    @Value("${scv.url}")
    private String pathTest;

    private ArrayList<Question> arrayQuestion = new ArrayList<>();

    public ApplianceServiceImpl(ApplianceDAO dao) {
        this.dao = dao;
    }

    public ArrayList<Question> getQuestion() {
        StringBuilder stringBuilder = dao.findQuestion(this.pathTest);
        return splitToArrayQuestion(stringBuilder);
    }

    private ArrayList<Question> splitToArrayQuestion(StringBuilder strBuilderQuestion) {
        String strQuestion = strBuilderQuestion.toString();
        String[] arrayStrQuestion = strQuestion.split("\n");

        for (String index : arrayStrQuestion) {
            String[] oneQuestion = index.split(",");
            Question question = new Question(Integer.parseInt(oneQuestion[0]),
                    oneQuestion[1],
                    oneQuestion[2] + " " + oneQuestion[3] + "\n" + oneQuestion[4] + " " + oneQuestion[5],
                    oneQuestion[6]);
            arrayQuestion.add(question);
        }
        return arrayQuestion;
    }

    public void printQuestion(ArrayList<Question> arrayQuestion, int numberOfQuestion) {
        System.out.println(arrayQuestion.get(numberOfQuestion));
    }


// mvn package spring-boot:repackage (to create jar)
}
