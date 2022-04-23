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

    private Student() {
    }

    public static Student getInstance() {
        return instance;
    }

    private String name;
    private String surname;
    private int numberOfGroup;
    private int age;
    private int score;

    @Override
    public String toString() {
        return name +
                " " + surname + " " +
                ", Number group = " + numberOfGroup +
                ", Age = " + age +
                ", Score = " + score;
    }

    public void setStudentInformation() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Hello, what is your name?");
            this.name = bufferedReader.readLine();
            System.out.println("Nice!\nWhat is your surname?");
            this.surname = bufferedReader.readLine();
            System.out.println("It's a great!\nCan I get information about your student group?");
            this.numberOfGroup = Integer.parseInt(bufferedReader.readLine());
            System.out.println("It's cute!\nAnd In the end say your age?");
            this.age = (Integer.parseInt(bufferedReader.readLine()));
            System.out.println("Awesome!!! You personal information will be save!\n");
            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("Error #bufferReader1" + Arrays.toString(e.getStackTrace()));
        }
    }
}
