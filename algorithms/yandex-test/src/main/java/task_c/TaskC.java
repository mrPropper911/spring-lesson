package task_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class TaskC {

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
            outStr.append(sumBetwenPointsNew(array, i, k)).append(" ");
        }
        return outStr.toString();
    }

    //function with sort array
    static int sumBetwenPointsNew(int[] array, int mainPoint, int k){
        int[] arrayNew = new int[array.length];
        int sumpointsForOut = 0;
        for (int i = 0; i < arrayNew.length; i++) {
            if(i == mainPoint){
                arrayNew[i] = -1;
            }  else {
                arrayNew[i] = Math.abs(array[mainPoint] - array[i]);
            }
        }

        Arrays.parallelSort(arrayNew);

        for (int m = 1; m <= k; m++){
            sumpointsForOut += arrayNew[m];
        }

        return sumpointsForOut;
    }



    // function with sort list
    static int sumBetwenPointsNewList(int[] array, int mainPoint, int k){
        List<Integer> arrayNew = new ArrayList<>(array.length-1);
        int sumpointsForOut = 0;
        for (int i = 0; i < array.length; i++) {
            if(i != mainPoint){
                arrayNew.add(Math.abs(array[mainPoint] - array[i]));
            }
        }

        Collections.sort(arrayNew);

        for (int m = 0; m < k; m++){
            sumpointsForOut += arrayNew.get(m);
        }

        return sumpointsForOut;
    }

}
