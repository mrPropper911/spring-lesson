package task_leetcode_5;

public class ReverseInteger {
    public static void main(String[] args) {


        System.out.println(reverse(123) + " 321");
        System.out.println(reverse(1534236469) + " 0");
        System.out.println(reverse(-123) + " -321");
        System.out.println(reverse(120) + " 21");
    }

    public static int reverse(int x) {
        int result = 0;
        while (x != 0){
            int outX = x % 10;
            int newResult = result*10 + outX;

            if ((newResult - outX)/10 != result){
                return 0;
            }
            result =newResult;
            x = x/10;
        }
        return result;
    }
}
