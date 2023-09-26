package yandex_training_2_0.packA.homework_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckSituationCorrect {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[][] array = new int[3][3];
        for (int i = 0; i < 3; i++){
            String[] sLine = bufferedReader.readLine().split(" ");
            for (int j = 0; j < 3; j++){
                array[i][j] = Integer.parseInt(sLine[j]);
            }
        }
        System.out.println(mainLogic(array));
    }

    public static String mainLogic(int[][] array){
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (array[i][j] == 1){
                    count1++;
                } else if (array[i][j] == 2) {
                    count2++;
                }
            }
        }

        if(count1 > 5 || count2 > 4 || count1 < count2 ||  Math.abs(count1 - count2) > 1){
            return "NO";
        }

        int countOfWin1 = 0;
        int countOfWin2 = 0;
        //up
        if(array[0][0] == array[0][1] && array[0][0] == array[0][2] && array[0][2] != 0){
            if (array[0][0] == 1){
                countOfWin1++;
            } else {
                countOfWin2++;
            }
        }
        //down
        if(array[2][0] == array[2][1] && array[2][0] == array[2][2] && array[2][2] != 0){
            if (array[2][0] == 1){
                countOfWin1++;
            } else {
                countOfWin2++;
            }
        }
        //left
        if(array[0][0] == array[1][0] && array[0][0] == array[2][0] && array[2][0] != 0){
            if (array[0][0] == 1){
                countOfWin1++;
            } else {
                countOfWin2++;
            }
        }
        //right
        if(array[0][2] == array[1][2] && array[0][2] == array[2][2] && array[2][2] != 0){
            if (array[0][2] == 1){
                countOfWin1++;
            } else {
                countOfWin2++;
            }
        }
        //diag from left up to right down
        if(array[0][0] == array[1][1] && array[0][0] == array[2][2] && array[2][2] != 0){
            if (array[0][0] == 1){
                countOfWin1++;
            } else {
                countOfWin2++;
            }
        }
        //diag from left down to right up
        if(array[2][0] == array[1][1] && array[2][0] == array[0][2] && array[0][2] != 0){
            if (array[2][0] == 1){
                countOfWin1++;
            } else {
                countOfWin2++;
            }
        }
        //centre gor
        if(array[1][0] == array[1][1] && array[1][0] == array[1][2] && array[1][2] != 0){
            if (array[1][0] == 1){
                countOfWin1++;
            } else {
                countOfWin2++;
            }
        }
        //centre ver
        if(array[0][1] == array[1][1] && array[0][1] == array[2][1] && array[2][1] != 0){
            if (array[0][1] == 1){
                countOfWin1++;
            } else {
                countOfWin2++;
            }
        }

        if ((countOfWin1 + countOfWin2) > 1){
            return "NO";
        }

        if ((count1 != count2 && countOfWin2 == 1) || (countOfWin1 == 1 && count1 == count2)){
            return "NO";
        }

        return "YES";
    }
}
