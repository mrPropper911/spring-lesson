package task_leetcode_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestPalindromicString {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("adam"));
        System.out.println(longestPalindrome("aba"));
        System.out.println(longestPalindrome("ccd"));
        System.out.println(longestPalindrome("ccc"));
        System.out.println(longestPalindrome("bb"));
        System.out.println(longestPalindrome("ac"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("babad"));

    }

    public static String longestPalindrome(String s) {
        if (s.length() == 1){
            return s;
        }
        char[] inStr = s.toCharArray();
        char[] reverseInStr = new char[inStr.length];
        String palindrom = "";

        List<String> listOfPalindrom = new ArrayList<>();

        for (int i = 0; i < inStr.length; i++){
            reverseInStr[inStr.length - 1 - i] = inStr[i];
        }

        listOfPalindrom.add(inStr[0]+"");

        boolean cheT = false;

        for (int i = 0; i < inStr.length - 1; i++){
            if (inStr[i] == inStr[i+1]){
                palindrom = palindrom + inStr[i];
                if (i == inStr.length - 2){
                    palindrom = palindrom + inStr[i];
                }
                listOfPalindrom.add(palindrom);
                cheT = true;
            }

            if (inStr[i] != inStr[i+1] && cheT){
                palindrom = palindrom + inStr[i];
            }


        }
        boolean chet2 = false;

        for (int j = 0; j < reverseInStr.length; j++){
            for (int i = j; i < inStr.length; i++){
                if (inStr[i] == reverseInStr[i]){
                    palindrom += inStr[i];

                } else {
                    listOfPalindrom.add(palindrom);
                    palindrom = "";
                    chet2 = true;
                }

                if (i == inStr.length-1 && !chet2 && !cheT){
                    listOfPalindrom.add(palindrom);
                    palindrom = "";
                }
            }
        }

        int maxLen = 0;
        for (String index : listOfPalindrom){
            if (index.length() > maxLen){
                maxLen = index.length();
            }
        }

        for (String index : listOfPalindrom) {
            if (index.length() == maxLen){
                return index;
            }
        }

        return "";
    }
}
