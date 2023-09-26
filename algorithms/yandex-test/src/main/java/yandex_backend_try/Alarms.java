package yandex_backend_try;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Alarms {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = bufferedReader.readLine().split(" ");
        String[] str2 = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(str1[0]);//count of alarms
        int X = Integer.parseInt(str1[1]);//time of repeat
        int K = Integer.parseInt(str1[2]);//count to wake up
        int[] arrayOfAlarms = new int[str2.length];
        for (int i = 0; i < arrayOfAlarms.length; i++) {
            arrayOfAlarms[i] = Integer.parseInt(str2[i]);
        }
        System.out.println(mainLogic(N, X, K, arrayOfAlarms));
    }

    public static int mainLogic(int countOfAlarms, int timeOfRepeat, int countToWakeUp, int[] arrayOfAlarms) {
        SortedSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < countOfAlarms; i++){
            for (int j = 0; j <= countToWakeUp; j++){
                set.add(arrayOfAlarms[i] + timeOfRepeat * j);
            }
        }
        List<Integer> list = new ArrayList<>(set);
        return list.get(countToWakeUp - 1);
    }
}
