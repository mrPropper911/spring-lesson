package yanbdex_conference;

public class Rle {
    public static void main(String[] args) {

        System.out.println(parseStringToRange("A123GF555GGG") + "");
        System.out.println(parseStringToRange("Z123XY") + "");

        System.out.println(parseStringToRange("ABCDR") + "");

        int answer = parseStringToRange("A15BA5");
        System.out.println(answer + "");


    }

    public static int parseStringToRange(String str) {
        char[] arrayChar = str.toCharArray();
        int answer = 0;
        StringBuilder tempStr = new StringBuilder();

        for (int i = 0; i < arrayChar.length - 1; i++) {
            if ((arrayChar[i] >= '0' && arrayChar[i] <= '9')) {
                if (arrayChar[i + 1] >= '0' && arrayChar[i + 1] <= '9') {
                    tempStr.append(arrayChar[i]);
                } else if ('A' <= arrayChar[i + 1] && arrayChar[i + 1] <= 'Z') {
                    tempStr.append(arrayChar[i]);
                    answer += Integer.parseInt(tempStr.toString());
                    tempStr.delete(0, tempStr.length());
                }
            } else if ('A' <= arrayChar[i] && arrayChar[i] <= 'Z') {
                if ((arrayChar[i + 1] >= '0' && arrayChar[i + 1] <= '9') && (i == (arrayChar.length - 2))) {
                    tempStr.append(arrayChar[i + 1]);
                    answer += Integer.parseInt(tempStr.toString());
                } else if ('A' <= arrayChar[i + 1] && arrayChar[i + 1] <= 'Z' && (i == (arrayChar.length - 2))) {
                    answer += 2;
                } else if ('A' <= arrayChar[i + 1] && arrayChar[i + 1] <= 'Z') {
                    answer++;
                }
            }
        }

        return answer;
    }

}
