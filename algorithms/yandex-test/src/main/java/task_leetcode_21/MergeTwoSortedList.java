package task_leetcode_21;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MergeTwoSortedList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        list.add("Six");
        list.add("Seven");
        list.add("Eight");
        list.add("Nine");
        list.add("Ten");
        Stream<String> stringStream = list.stream();
        stringStream.filter(x -> x.length() == 3).forEach(x -> System.out.println());
    }


}
