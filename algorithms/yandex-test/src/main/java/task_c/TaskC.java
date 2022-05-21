package task_c;

import java.util.*;

public class TaskC {
    int n;//long array
    int k;//count of sum
    List<Integer> array = new ArrayList<>();

    public static void main(String[] args) {
        TaskC taskC = new TaskC();
        Scanner scanner = new Scanner(System.in);

        String firstStrIn = scanner.nextLine();
        String secondStrIn = scanner.nextLine();
        taskC.parseInputString(firstStrIn, secondStrIn);

        int[] outArray = taskC.mainLogicFunction();

        StringBuilder outStr = new StringBuilder("");
        for (int i = 0; i < taskC.n; i++) {
            outStr.append(outArray[i]).append(" ");
        }
        System.out.println(outStr.substring(0, outStr.length() - 1));

    }

    //parsing input value
    private void parseInputString(String first, String second) {
        String[] firstArray = first.split(" ");
        String[] secondArray = second.split(" ");
        n = Integer.parseInt(firstArray[0]);
        k = Integer.parseInt(firstArray[1]);
        for (int i = 0; i < n; i++) {
            array.add(i, Integer.parseInt(secondArray[i]));
        }
    }

    //main logic
    private int[] mainLogicFunction() {
        int[] answerArrayOut = new int[n];
        for (int i = 0; i < n; i++) {
            answerArrayOut[i] = sumBetwenPoints(i);
        }
        return answerArrayOut;
    }

    //min dist(i,S)
    int sumBetwenPoints(int mainPoint) {
        int sumpointsForOut = 0;
        Map<Integer, Integer> mappoints = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (i != mainPoint) {
                int valueBetwenpoint = Math.abs(array.get(mainPoint) - array.get(i));
                mappoints.put(i, valueBetwenpoint);
            }
        }
        //get min k value
        for (int j = 0; j < k; j++) {
            //get first element from hashmap
            Map.Entry<Integer, Integer> entryFirst = mappoints.entrySet().stream().findFirst().get();
            int minValue = entryFirst.getValue();
            int rememberKey = entryFirst.getKey();

            for (Map.Entry<Integer, Integer> entry : mappoints.entrySet()) {
                if (entry.getValue() < minValue) {
                    minValue = entry.getValue();
                    rememberKey = entry.getKey();
                }
            }

            mappoints.remove(rememberKey);
            sumpointsForOut += minValue;
        }

        return sumpointsForOut;
    }
}
