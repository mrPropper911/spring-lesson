package by.vadim.hw3.service.impl;

import by.vadim.hw3.dao.ApplianceDAO;
import by.vadim.hw3.entity.Question;
import by.vadim.hw3.service.ApplianceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ApplianceServiceImpl implements ApplianceService {
    private ApplianceDAO dao;


    private ArrayList<Question> arrayQuestion = new ArrayList<>();

    public ApplianceServiceImpl(ApplianceDAO dao) {
        this.dao = dao;
    }

    @Override
    public ArrayList<Question> getQuestion() {
        StringBuilder stringBuilder = dao.findQuestion();
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

    @Override
    public void printQuestion(ArrayList<Question> arrayQuestion, int numberOfQuestion) {
        System.out.println(arrayQuestion.get(numberOfQuestion));
    }
}
