package yandex_introductory_contest;

import java.io.*;

public class TestB {
    public static void main(String[] args) {
        String s = " ";
        String result = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));

            while ((s = br.readLine()) != null){
                String[] arr = s.split(" ");
                Long a = Long.valueOf(arr[0]);
                Long b = Long.valueOf(arr[1]);
                result = String.valueOf(sum(a, b));
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
            if (result != null) {
                bw.write(result);
            }
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Long sum(Long a, Long b){
        return a + b;
    }
}
