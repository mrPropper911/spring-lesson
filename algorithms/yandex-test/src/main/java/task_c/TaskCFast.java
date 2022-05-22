package task_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TaskCFast {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n;//long array
        int k;//count of sum

        String firstStrIn = bufferedReader.readLine();
        String secondStrIn = bufferedReader.readLine();

        String[] firstArray = firstStrIn.split(" ");
        String[] secondArray = secondStrIn.split(" ");

        n = Integer.parseInt(firstArray[0]);
        k = Integer.parseInt(firstArray[1]);

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(secondArray[i]);
        }

        System.out.println(mainLogicFunction(array, k));

    }

    //main logic
    static String mainLogicFunction(int[] array, int k) {
        StringBuilder outStr = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            outStr.append(sumBetwenPoints(array, i, k)).append(" ");
        }
        return outStr.toString();
    }

    //min dist(i,S)
    static int sumBetwenPoints(int[] array, int mainPoint, int k) {
        int sumpointsForOut = 0;
        HashMap<Integer, Integer> mappoints = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (i != mainPoint) {
                int valueBetwenpoint = Math.abs(array[mainPoint] - array[i]);
                mappoints.put(i, valueBetwenpoint);
            }
        }
        //get min k value
        Map<Integer, Integer> mappointsSorted = sortByValue(mappoints);
        for (Map.Entry<Integer, Integer> entry : mappointsSorted.entrySet()){
            if(k == 0){
                break;
            }
            sumpointsForOut += entry.getValue();
            k--;
        }

        return sumpointsForOut;
    }

    // function to sort hashmap by values
    public static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Integer> > list =
                new LinkedList<Map.Entry<Integer, Integer> >(hm.entrySet());

        // Sort the list
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
