package yandex_training_2_0.homework_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BuildingSchool {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int countOfStudent = Integer.parseInt(bufferedReader.readLine());
        String[] strArrayIn = bufferedReader.readLine().split(" ");
        System.out.println(Integer.parseInt(mainLogic(countOfStudent, strArrayIn)));
    }

    public static String mainLogic(int countOfStudents, String[] houseCoordinate){
        return houseCoordinate[countOfStudents/2];
    }
}
