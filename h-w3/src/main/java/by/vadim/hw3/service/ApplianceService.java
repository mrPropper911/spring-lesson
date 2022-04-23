package by.vadim.hw3.service;

import by.vadim.hw3.entity.Question;

import java.util.ArrayList;

public interface ApplianceService {
    ArrayList<Question> getQuestion();

    void printQuestion(ArrayList<Question> arrayQuestion, int numberOfQuestion);
}
