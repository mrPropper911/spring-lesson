package by.vadim.hw2.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Student {
    private String name;
    private String surname;
    private int numberOfGroup;
    private int dayOfBirthday;
    private int score;

    @Override
    public String toString() {
        return "Student" +
                "'" + name + '\'' +
                "" + surname + '\'' +
                ", numberOfGroup=" + numberOfGroup +
                ", dayOfBirthday=" + dayOfBirthday +
                ", score=" + score +
                '}';
    }
}
