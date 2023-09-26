package task_leetcode_2;

import task_leetcode_1.ListNode;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;



public class LongestSubString {
    public static void main(String[] args) {

        DoubleStream s = DoubleStream.of(1.2, 2.3);
        s.peek(System.out::print).filter(x -> x>2).count();

//        System.out.println(lengthOfLongestSubstring("jbpnbwwd") + "-4");
//
//        System.out.println(lengthOfLongestSubstring("dvdf") + "-3");
//
//        System.out.println(lengthOfLongestSubstring("abcabcbb") + "-3");
//
//        System.out.println(lengthOfLongestSubstring("au") + "-2");
//
//        System.out.println(lengthOfLongestSubstring("bbbbb") + "-1");
//
//        System.out.println(lengthOfLongestSubstring("pwwkew") + "-3");
//
//        System.out.println(lengthOfLongestSubstring(" ") + "-1");
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
