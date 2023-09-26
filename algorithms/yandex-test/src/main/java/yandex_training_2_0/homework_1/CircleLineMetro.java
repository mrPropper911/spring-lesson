package yandex_training_2_0.homework_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CircleLineMetro {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inStr = bufferedReader.readLine();
        String[] arrInStr = inStr.split(" ");
        System.out.println(
                mainLogic(Integer.parseInt(arrInStr[0]), Integer.parseInt(arrInStr[1]), Integer.parseInt(arrInStr[2])));
    }

    public static int mainLogic(int countOfStation, int firstStation, int secondStation) {
        //-->>
        int direct_station = Math.abs(secondStation - firstStation);
        //<<--
        int revers_station = Math.abs(countOfStation - direct_station);
        return Math.min(direct_station, revers_station) - 1;

    }
}
