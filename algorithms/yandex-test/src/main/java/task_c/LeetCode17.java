package task_c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode17 {
    public static void main(String[] args) {
        LeetCode17 test = new LeetCode17();
        List<String> testList = test.letterCombinations("23");
        for (String index : testList){
            System.out.println(index);
        }
    }

    public List<String> letterCombinations(String digits) {
        char[] dig2 = {'a','b','c'};
        char[] dig3 = {'d','e','f'};
        char[] dig4 = {'g','h','i'};
        char[] dig5 = {'j','k','l'};
        char[] dig6 = {'m','n','o'};
        char[] dig7 = {'p','q','r','s'};
        char[] dig8 = {'t','u','v'};
        char[] dig9 = {'w','x','y','z'};

        HashMap<Integer, char[]> phoneKey = new HashMap<>();
        phoneKey.put(2, dig2);
        phoneKey.put(3, dig3);
        phoneKey.put(4, dig4);
        phoneKey.put(5, dig5);
        phoneKey.put(6, dig6);
        phoneKey.put(7, dig7);
        phoneKey.put(8, dig8);
        phoneKey.put(9, dig9);

        List<String> outStr = new ArrayList<>();
        char[] inNumbers = digits.toCharArray();
        int checkNumberOfLine = inNumbers.length;
        
        for(int i = 0; i < inNumbers.length; i++){
            String sAdd = phoneKey.get(2) + "";
            int count = 0;

            while (true){
                if(checkNumberOfLine > (i+1)){
                    break;
                }
                else 
                    for(int j = 0; j < inNumbers.length; j++){
                        sAdd = sAdd + phoneKey.get(inNumbers[j])[count];
                    }

            }
        }

        return outStr;
    }

}
