package by.vadim.hw1.service.impl;

import by.vadim.hw1.dao.ApplianceDAO;
import by.vadim.hw1.domain.Question;
import by.vadim.hw1.service.ApplianceService;

import java.util.ArrayList;

public class ApplianceServiceImpl implements ApplianceService {
    private ApplianceDAO dao;
    private ArrayList<Question> arrayQuestion = new ArrayList<>();

    public ApplianceServiceImpl(ApplianceDAO dao) {
        this.dao = dao;
    }

    public ArrayList<Question> getQuestion() {
        StringBuilder stringBuilder = dao.findQuestion();
        String strQuestion = stringBuilder.toString();
        String[] arrayStrQuestion = strQuestion.split("\n");

            for (String index : arrayStrQuestion){
                String[] oneQuestion = index.split(",");
                Question question = new Question(Integer.parseInt(oneQuestion[0]),
                        oneQuestion[1],
                        oneQuestion[2] + " " + oneQuestion[3] + "\n" + oneQuestion[4] + " " + oneQuestion[5],
                        oneQuestion[6]);
                arrayQuestion.add(question);
            }

        return arrayQuestion;
    }

    public void printQuestion(ArrayList<Question> arrayQuestion){
        for (Question index: arrayQuestion){
            System.out.println(index);
        }
    }




}
