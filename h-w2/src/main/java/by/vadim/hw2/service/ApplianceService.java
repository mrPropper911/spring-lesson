package by.vadim.hw2.service;

import by.vadim.hw2.entity.Question;

import java.util.ArrayList;

public interface ApplianceService {
    ArrayList<Question> getQuestion();

    void printQuestion(ArrayList<Question> arrayQuestion, int numberOfQuestion);
}
