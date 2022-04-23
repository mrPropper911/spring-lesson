package by.vadim.hw3.entity;

import lombok.Data;

@Data
public class Question {
    private int numberQuestion;
    private String currentQuestion;
    private String answerQuestion;
    private String trueAnswerQuestion;

    public Question(int numberQuestion, String currentQuestion,
                    String answerQuestion, String trueAnswerQuestion) {
        this.numberQuestion = numberQuestion;
        this.currentQuestion = currentQuestion;
        this.answerQuestion = answerQuestion;
        this.trueAnswerQuestion = trueAnswerQuestion;
    }

    @Override
    public String toString() {
        return "\nQuestion" +
                " : " + numberQuestion +
                "\n" + currentQuestion + '\'' +
                "\n" + answerQuestion + '\'';
    }
}
