package yandex_training_2_0.homework_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HousesAndShops {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strIn = bufferedReader.readLine().split(" ");
        int[] arrayInt = new int[strIn.length];
        for (int i = 0; i < strIn.length; i ++){
            arrayInt[i] = Integer.parseInt(strIn[i]);
        }
        System.out.println(mainLogic(arrayInt));
    }

    //1 - house
    //2- shop
    //0 - office
    // Max distance from 1 to 2
    //2 0 1 1 0 1 0 2 1 2
    public static int mainLogic(int [] arrayBuildings){
        HashMap<Integer, Integer> leftToRightMap = new HashMap<>();
        HashMap<Integer, Integer> rightToLeftMap = new HashMap<>();
        List<Integer> minDistance = new ArrayList<>();
        //-->>
        int tempIShop = 0;
        boolean checkShop = false;
        for (int i = 0; i < arrayBuildings.length; i++){
            if (arrayBuildings[i] == 2){
                tempIShop = i;
                checkShop = true;
            } else if (arrayBuildings[i] == 1 && checkShop){
                leftToRightMap.put(i, Math.abs(tempIShop - i));
            } else if (arrayBuildings[i] == 1 && !checkShop){
                for (int j = i + 1; j < arrayBuildings.length; j++){
                    if (arrayBuildings[j] == 2){
                        leftToRightMap.put(i, Math.abs(j - i));
                        break;
                    }
                }
            }
        }
        //<<--
        tempIShop = 0;
        checkShop = false;
        for (int i = arrayBuildings.length - 1; i >= 0; i--){
            if (arrayBuildings[i] == 2){
                tempIShop = i;
                checkShop = true;
            } else if (arrayBuildings[i] == 1 && checkShop){
                rightToLeftMap.put(i, Math.abs(tempIShop - i));
            } else if (arrayBuildings[i] == 1 && !checkShop){
                for (int j = i - 1; j > 0; j--){
                    if (arrayBuildings[j] == 2){
                        rightToLeftMap.put(i, Math.abs(j - i));
                        break;
                    }
                }
            }
        }
        //searching min distance for all houses
        for (Map.Entry<Integer, Integer> entry : leftToRightMap.entrySet()){
            if (entry.getValue() < rightToLeftMap.get(entry.getKey())){
                minDistance.add(entry.getValue());
            } else {
                minDistance.add(rightToLeftMap.get(entry.getKey()));
            }
        }
        //searching max distance
        minDistance.sort(Collections.reverseOrder());
        return minDistance.get(0);
    }
}
