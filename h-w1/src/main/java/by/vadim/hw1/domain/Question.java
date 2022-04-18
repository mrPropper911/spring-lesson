package by.vadim.hw1.domain;

import lombok.Data;

@Data
public class Question implements Appliance{
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
        return "Question" +
                " : " + numberQuestion +
                "\n" + currentQuestion + '\'' +
                "\n" + answerQuestion + '\'';
    }
}
