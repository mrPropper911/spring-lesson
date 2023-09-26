package yandex_training_2_0.homework_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DateEx {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] arrStrIn = bufferedReader.readLine().split(" ");
        System.out.println(mainLogic(Integer.parseInt(arrStrIn[0]), Integer.parseInt(arrStrIn[1]),
                Integer.parseInt(arrStrIn[2])));
    }

    public static int mainLogic(int x, int y, int year) {
        if (x == y) {
            return 1;
        } else if (x <= 12 && y <= 12) {
            return 0;
        } else {
            return 1;
        }
    }
}
