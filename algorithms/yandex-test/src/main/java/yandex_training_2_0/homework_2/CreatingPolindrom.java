package yandex_training_2_0.homework_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreatingPolindrom {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(mainLogic(bufferedReader.readLine()));
    }

    public static int mainLogic(String strIn){
        char[] arrChar = strIn.toCharArray();
        int coin = 0;
        if (arrChar.length == 1){
            return coin;
        }
        for (int i = 0; i < arrChar.length/2; i++){
            if (arrChar[i] != arrChar[arrChar.length - 1 - i]){
                coin++;
            }
        }
        return coin;
    }
}
