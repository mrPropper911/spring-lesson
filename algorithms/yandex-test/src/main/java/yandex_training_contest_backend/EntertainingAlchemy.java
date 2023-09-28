package yandex_training_contest_backend;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class EntertainingAlchemy {
    private static final HashMap<Integer, Receipt> receipts = new HashMap<>();
    private static final Queue<String> queue = new LinkedList<>();

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

        String result = mailLogic(dataList);

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
            bw.write(result);
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String mailLogic(List<String> inputStrList) {
        StringBuilder stringBuilder = new StringBuilder();
        int N = Integer.parseInt(inputStrList.get(0));
        for (int i = 1; i <= N - 2; i++) {
            mapToReceipt(i + 2, inputStrList.get(i));
        }

        while (!queue.isEmpty()) {
            String[] s = queue.poll().split(" ");
            int id = Integer.parseInt(s[0]);
            StringBuilder builder = new StringBuilder();
            for (int i = 1; i < s.length; i++) {
                builder.append(s[i]).append(" ");
            }
            String s1 = builder.toString();
            mapToReceiptRepeat(id, s1);
        }

        int Q = Integer.parseInt(inputStrList.get(N - 1));
        for (int i = 0; i < Q; i++) {
            stringBuilder.append(checkQuestion(inputStrList.get(N + i)));
        }
        return stringBuilder.toString();
    }

    private static int checkQuestion(String str) {
        List<Integer> integerListIn = Arrays.stream(str.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int numberOfA = integerListIn.get(0);
        int numberOfB = integerListIn.get(1);
        int searchingReceiptId = integerListIn.get(2);
        Receipt receipt = receipts.get(searchingReceiptId);
        if (receipt == null) {
            return 0;
        } else if (receipt.A > numberOfA ||
                receipt.B > numberOfB) {
            return 0;
        }
        return 1;
    }

    private static void mapToReceiptRepeat(int id, String str) {
        List<Integer> stringListParse = Arrays.stream(str.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int numberOfComponents = stringListParse.get(0);
        int countOfA = 0;
        int countOfB = 0;
        for (int i = 1; i <= numberOfComponents; i++) {
            int searchingReceipt = stringListParse.get(i);
            if (searchingReceipt == 1) {
                countOfA++;
            } else if (searchingReceipt == 2) {
                countOfB++;
            } else {
                if (receipts.get(searchingReceipt) == null) {
                    return;
                }
                Receipt searchungReceipt = receipts.get(searchingReceipt);
                countOfA += searchungReceipt.A;
                countOfB += searchungReceipt.B;
            }
        }
        receipts.put(id, new Receipt(countOfA, countOfB));
    }

    private static void mapToReceipt(int id, String str) {
        List<Integer> stringListParse = Arrays.stream(str.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int numberOfComponents = stringListParse.get(0);
        int countOfA = 0;
        int countOfB = 0;
        for (int i = 1; i <= numberOfComponents; i++) {
            int searchingReceipt = stringListParse.get(i);
            if (searchingReceipt == 1) {
                countOfA++;
            } else if (searchingReceipt == 2) {
                countOfB++;
            } else {
                if (receipts.get(searchingReceipt) == null && searchingReceipt > id) {
                    queue.add(id + " " + str);
                    return;
                } else if (receipts.get(searchingReceipt) == null) {
                    return;
                }
                Receipt searchungReceipt = receipts.get(searchingReceipt);
                countOfA += searchungReceipt.A;
                countOfB += searchungReceipt.B;
            }
        }
        receipts.put(id, new Receipt(countOfA, countOfB));
    }

    public static class Receipt {
        int id;
        int A;
        int B;

        public Receipt(int id, int a, int b) {
            this.id = id;
            A = a;
            B = b;
        }

        public Receipt(int a, int b) {
            A = a;
            B = b;
        }
    }
}
