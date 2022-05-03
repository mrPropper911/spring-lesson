package by.vadim.hw3.entity;

import lombok.Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

@Data
public class Student {
    //single tone
    private static final Student instance = new Student();

    private Student() {}

    public static Student getInstance() {
        return instance;
    }

    private String name;
    private String surname;
    private int numberOfGroup;
    private int age;
    private int score;

//    @Override
//    public String toString() {
//        return name +
//                " " + surname + " " +
//                ", Number group = " + numberOfGroup +
//                ", Age = " + age +
//                ", Score = " + score;
//    }

    public void printStudentMessage(Student student){

    }
}
