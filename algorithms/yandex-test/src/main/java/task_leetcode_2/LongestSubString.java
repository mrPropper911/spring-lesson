package task_leetcode_2;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {
    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("jbpnbwwd") + "-4");

        System.out.println(lengthOfLongestSubstring("dvdf") + "-3");

        System.out.println(lengthOfLongestSubstring("abcabcbb") + "-3");

        System.out.println(lengthOfLongestSubstring("au") + "-2");

        System.out.println(lengthOfLongestSubstring("bbbbb") + "-1");

        System.out.println(lengthOfLongestSubstring("pwwkew") + "-3");

        System.out.println(lengthOfLongestSubstring(" ") + "-1");
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==1){
            return 1;
        }

        int maxCountSearched = 0;
        int maxCountRound = 0;
        char[] inStr = s.toCharArray();

        Set<Character> characterSet = new HashSet<>();
        for (int j = 0; j < inStr.length; j++){
            for (int i = j; i < inStr.length; i++) {
                if (!characterSet.add(inStr[i])) {
                    if (maxCountRound > maxCountSearched) {
                        maxCountSearched = maxCountRound;
                    }
                    characterSet.clear();
                    maxCountRound = 0;
                    break;
                }
                maxCountRound++;
                if (i == inStr.length-1){
                    if (maxCountRound > maxCountSearched){
                        maxCountSearched = maxCountRound;
                    }
                }
            }
        }

        return maxCountSearched;
    }
}
