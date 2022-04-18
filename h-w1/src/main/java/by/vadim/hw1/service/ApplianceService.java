package by.vadim.hw1.service;

import by.vadim.hw1.domain.Question;

import java.util.ArrayList;

public interface ApplianceService {
    ArrayList<Question> getQuestion();
    void printQuestion(ArrayList<Question> arrayQuestion);
}
