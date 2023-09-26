package yandex_backend_try;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class StonesAndJewelry {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = bufferedReader.readLine();
        String str2 = bufferedReader.readLine();
        System.out.println(mainLogic(str1, str2));
    }

    public static int mainLogic(String str1, String str2){
        int answerCount = 0;
        char[] arrayCharStr1 = str1.toCharArray();
        char[] arrayCharStr2 = str2.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char item : arrayCharStr1) {
            set.add(item);
        }

        for (char value : set) {
            for (char c : arrayCharStr2) {
                if (value == c) {
                    answerCount++;
                }
            }
        }

        return answerCount;
    }
}
