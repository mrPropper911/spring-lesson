package task_c;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class TastCMostFast15 {
    public static void main(String[] args) throws IOException {
//        Random random = new Random();
//        String ass = "231";
//
//        try {
//            FileWriter myWriter = new FileWriter("input.txt");
//            for (int i = 0; i < 10000; i++){
//                ass+= " " + random.nextInt(1_000_000);
//                myWriter.write(ass);
//            }
//            myWriter.close();
//            System.out.println("Successfully wrote to the file.");
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }

//        try {
//            File myObj = new File("output.txt");
//            if (myObj.createNewFile()) {
//                System.out.println("File created: " + myObj.getName());
//            } else {
//                System.out.println("File already exists.");
//            }
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }



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
        long time4 = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(secondArray[i]);
        }
        System.out.println("parsing time:");
        System.out.println(System.currentTimeMillis() - time4);


//        System.out.println(mainLogicFunction(array, k));

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        writer.write(mainLogicFunction(array, k));

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

        int[] arraySort = Arrays.copyOf(array, array.length);
        Arrays.parallelSort(arraySort);

        HashMap<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            index.put(arraySort[i], i);
        }


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


