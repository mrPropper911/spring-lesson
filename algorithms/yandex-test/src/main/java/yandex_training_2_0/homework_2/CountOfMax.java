package yandex_training_2_0.homework_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CountOfMax {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> integerList = new ArrayList<>();
        int temp = Integer.parseInt(bufferedReader.readLine());
        while (temp != 0){
            integerList.add(temp);
            temp = Integer.parseInt(bufferedReader.readLine());
        }
        System.out.println(mainLogic(integerList));
    }

    public static int mainLogic(List<Integer> list){
        int answerCount = 1;
        list.sort(Collections.reverseOrder());
        for (int i = 0; i < list.size() - 1; i++){
            if (Objects.equals(list.get(i), list.get(i + 1))){
              answerCount++;
            }
            else {
                return answerCount;
            }
        }
        return answerCount;
    }
}