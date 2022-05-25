package task_c;


import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class TaskWithDouble {
    public static void main(String[] args) throws IOException {
        long time4 = System.currentTimeMillis();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
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

//        System.out.println(mainLogicFunction(array, k));

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        long time2 = System.currentTimeMillis();
        String strQ = mainLogicFunction(array, k);
        System.out.println("main logic time:");
        System.out.println(System.currentTimeMillis() - time4);
        writer.write(strQ);
        System.out.println("all time:");
        System.out.println(System.currentTimeMillis() - time4);
    }

    //main logic
    static String mainLogicFunction(int[] array, int k) {
        long[] arrayOut = sumBetwenPointsNewHash(array, k);
        return Arrays.toString(arrayOut).substring(1)
                .replaceFirst("]", "")
                .replace(", ", " ");
    }


    static long[] sumBetwenPointsNewHash(int[] array, int k) {
        long[] arrayOut = new long[array.length];

        long time1 = System.currentTimeMillis();
        int[] arraySort = Arrays.copyOf(array, array.length);
        Arrays.parallelSort(arraySort);
        System.out.println("sorting time:");
        System.out.println(System.currentTimeMillis() - time1);

        long time12 = System.currentTimeMillis();
        HashMap<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            index.put(arraySort[i], i);
        }
        System.out.println("hashmaping time:");
        System.out.println(System.currentTimeMillis() - time12);


        for (int i = 0; i < array.length; i++) {
            int mainPoint = array[i];
            int mainPosition = 0;
            int sumPointsForOut = 0;

            mainPosition = index.get(mainPoint);


            int indexBefore = mainPosition - 1;
            int indexAfter = mainPosition + 1;
            for (int kCount = 0; kCount < k; kCount++) {
                if (indexBefore < 0) {
                    int sumAfter = Math.abs(arraySort[indexAfter] - mainPoint);
                    sumPointsForOut += sumAfter;
                    indexAfter++;
                    continue;
                }
                if (indexAfter > array.length - 1) {
                    int sumBefore = Math.abs(arraySort[indexBefore] - mainPoint);
                    sumPointsForOut += sumBefore;
                    indexBefore--;
                    continue;
                }

                int sumBefore = Math.abs(arraySort[indexBefore] - mainPoint);
                int sumAfter = Math.abs(arraySort[indexAfter] - mainPoint);

                if (sumBefore < sumAfter) {
                    sumPointsForOut += sumBefore;
                    indexBefore--;
                } else {
                    sumPointsForOut += sumAfter;
                    indexAfter++;
                }

            }

            arrayOut[i] = sumPointsForOut;
        }

        return arrayOut;

    }

}



