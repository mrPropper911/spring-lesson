package by.vadim.hw3.controller;

import by.vadim.hw3.entity.Student;

public interface Quiz {
    void startTest(Student student) throws InterruptedException;
}
