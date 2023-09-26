package yandex_introductory_contest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskG {
    public static void main(String[] args) {
        String s;
        Integer result;
        List<String> stringList = new ArrayList<>(2);

        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            while ((s = br.readLine()) != null){
                stringList.add(s);
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        result = testLogic(stringList.get(1), stringList.get(0));

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
            if (result != null) {
                bw.write(String.valueOf(result));
            }
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Integer mainLogic(String str1, String str2){
        Integer result = 0;
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        for (int i = 0; i < arr1.length; i++){
            for (int j = 0; j < arr2.length; j++){
                if (arr1[i] == arr2[j]){
                    result++;
                }
            }
        }
        return result;
    }

    private static Integer testLogic(String str1, String str2){
        Integer result = 0;
        for (int i = 0; i < str1.length(); ++i){
            char a = str1.charAt(i);
            if (str2.indexOf(a) >= 0){
                ++result;
            }
        }
        return result;
    }
}


























