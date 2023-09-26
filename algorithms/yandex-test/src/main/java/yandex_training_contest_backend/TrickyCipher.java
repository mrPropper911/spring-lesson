package yandex_training_contest_backend;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TrickyCipher {
    public static void main(String[] args) {
        String s;
        List<String> dataList = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            while ((s = br.readLine()) != null) {
                dataList.add(s);
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        List<String> result = mailLogic(dataList);

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
            for (String index: result){
                bw.write(index + " ");
            }
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<String> mailLogic(List<String> dataList) {
        List<String> resultList = new ArrayList<>();

        for (int i = 1; i < dataList.size(); i++){
            String[] arrayStr = dataList.get(i).split(",");

            int deferenceCharacter = countOfDeferenceCharacter(List.of(arrayStr[0],arrayStr[1],arrayStr[2]));
            int sumOfDate = sumOfDayAndMonth(List.of(arrayStr[3],arrayStr[4]));
            int numberOfAlphabet = numberLaterOfAlphabet(arrayStr[0]);
            int shiftNumeric = deferenceCharacter + sumOfDate * 64 + numberOfAlphabet * 256;

            String convertToHex = Integer.toHexString(shiftNumeric).toUpperCase();
            String last3reg = convertToHex.substring(convertToHex.length() - 3);
            resultList.add(last3reg);
        }

        return resultList;
    }

    private static int numberLaterOfAlphabet(String s) {
        char[] chars = s.toCharArray();
        return  chars[0] - 'A' + 1;
    }


    private static int countOfDeferenceCharacter(List<String> arrayStr){
        Set<Character> characterSet = new HashSet<>();
        for (int j = 0; j < 3; j++){
            char[] chars = arrayStr.get(j).toCharArray();
            for (char aChar : chars) {
                characterSet.add(aChar);
            }
        }
        return characterSet.size();
    }

    private static int sumOfDayAndMonth(List<String> listOfDate) {
        int result = 0;
        for (String index: listOfDate){
            for (char c : index.toCharArray()) {
                result+= Character.getNumericValue(c);
            }

        }
        return result;
    }
}
