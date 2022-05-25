package task_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.StreamSupport;

public class TaskCNewAlgorithm {
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
        int[] arrayOut = sumBetwenPointsNewHash(array, k);
        return Arrays.toString(arrayOut).substring(1)
                .replaceFirst("]", "")
                .replace(", ", " ");
    }

    //function with sort array
    static int[] sumBetwenPointsNew(int[] array, int k) {
        int[] arrayOut = new int[array.length];


        int[] arraySort = Arrays.copyOf(array, array.length);

        Arrays.parallelSort(arraySort);

        for (int i = 0; i < array.length; i++) {
            int mainPoint = array[i];
            int mainPosition = 0;
            int sumPointsForOut = 0;

            for (int j = 0; j < arraySort.length; j++) {
                if (mainPoint == arraySort[j]) {
                    mainPosition = j;
                    break;
                }
            }

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

    static int[] sumBetwenPointsNewHash(int[] array, int k) {
        int[] arrayOut = new int[array.length];

        //search count uniq value
        HashMap<Integer,Integer> hashMapCountValue = new HashMap<>();
        for(int i = 0; i < array.length; i++){
            if(hashMapCountValue.get(array[i]) == null){
                hashMapCountValue.put(array[i],1);
            } else {
                hashMapCountValue.put(array[i],hashMapCountValue.get(array[i])+1);
            }
        }

        //create array with uniq value and sorting
        int[] arraySort = new int[hashMapCountValue.size()];
        int iC = 0;
        for (Map.Entry<Integer, Integer> entry : hashMapCountValue.entrySet()){
            arraySort[iC] = entry.getKey();
            iC++;
        }
        Arrays.parallelSort(arraySort);

        //search index place in search array
        HashMap<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < arraySort.length; i++) {
            index.put(arraySort[i], i);
        }


        for (int i = 0; i < array.length; i++) {
            int mainPoint = array[i];
            int mainPosition = 0;
            int sumPointsForOut = 0;

            mainPosition = index.get(mainPoint);


            int indexBefore = mainPosition - 1;
            int indexAfter = mainPosition + 1;
            for (int kCount = (k+1); kCount >= 1; kCount--) {
                if (indexBefore < 0) {
                    int sumAfter = Math.abs(arraySort[indexAfter] - mainPoint);

                    if (hashMapCountValue.get(arraySort[indexAfter]) > kCount){
                        sumPointsForOut += sumAfter * kCount;
                        break;
                    } else {
                        sumPointsForOut += sumAfter * hashMapCountValue.get(arraySort[indexAfter]);
                        kCount -= hashMapCountValue.get(arraySort[indexAfter]);
                    }
                    indexAfter++;
                    continue;
                }
                if (indexAfter > arraySort.length - 1) {
                    int sumBefore = Math.abs(arraySort[indexBefore] - mainPoint);
                    if (hashMapCountValue.get(arraySort[indexBefore]) > kCount){
                        sumPointsForOut += sumBefore * kCount;
                        break;
                    } else {
                        sumPointsForOut += sumBefore * hashMapCountValue.get(arraySort[indexBefore]);
                        kCount -= hashMapCountValue.get(arraySort[indexBefore]);
                    }
                    indexBefore--;
                    continue;
                }

                int sumBefore = Math.abs(arraySort[indexBefore] - mainPoint);
                int sumAfter = Math.abs(arraySort[indexAfter] - mainPoint);

                if (sumBefore < sumAfter) {
                    if (hashMapCountValue.get(arraySort[indexBefore]) > kCount){
                        sumPointsForOut += sumBefore * kCount;
                        break;
                    } else {
                        sumPointsForOut += sumBefore * hashMapCountValue.get(arraySort[indexBefore]);
                        kCount -= hashMapCountValue.get(arraySort[indexBefore]);
                    }
                    indexBefore--;
                } else {
                    if (hashMapCountValue.get(arraySort[indexAfter]) > kCount){
                        sumPointsForOut += sumAfter * kCount;
                        break;
                    } else {
                        sumPointsForOut += sumAfter * hashMapCountValue.get(arraySort[indexAfter]);
                        kCount -= hashMapCountValue.get(arraySort[indexAfter]);
                    }
                    indexAfter++;
                }

            }

            arrayOut[i] = sumPointsForOut;
        }

        return arrayOut;

    }

}


