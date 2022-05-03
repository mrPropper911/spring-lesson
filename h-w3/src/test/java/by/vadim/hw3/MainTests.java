package by.vadim.hw3;

import by.vadim.hw3.controller.Quiz;
import by.vadim.hw3.entity.Student;
import lombok.experimental.Accessors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@DisplayName("Test 1awdawdwddddddddaww")
@SpringBootTest
class MainTests {

    @MockBean
    Quiz test;

    @MockBean
    Student student;


    @DisplayName("Test 1awdawdwddddddddaww")
    @Test
    void contextLoads() throws Exception {
        test.startTest(student);


    }

}