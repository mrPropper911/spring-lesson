package stream_api_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestA {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        while (list.size() != 1000){
            int randNumber = (int)(Math.random() * 1000);
            if (randNumber>=100 && randNumber<=200){
                list.add(randNumber);
            }
        }

        List<String> filtred = list.stream()
                .filter(integer -> integer % 2 == 0 && integer % 5 == 0)
                .map(Math::sqrt)
                .map(aDouble -> "Sqrt" + aDouble)
                .collect(Collectors.toList());



        for (String index : filtred){
            System.out.println(index);
        }


    }




}
