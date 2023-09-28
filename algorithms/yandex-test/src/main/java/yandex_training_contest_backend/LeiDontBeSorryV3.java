package yandex_training_contest_backend;
import java.util.*;
import java.io.*;

public class LeiDontBeSorryV3 {
    static class Order {
        int start, end, cost;
        public Order(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Order> orders = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);
            orders.add(new Order(start, end, cost));
        }
        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            String[] queryInput = br.readLine().split(" ");
            int start = Integer.parseInt(queryInput[0]);
            int end = Integer.parseInt(queryInput[1]);
            int type = Integer.parseInt(queryInput[2]);
            if (type == 1) {
                int totalCost = orders.stream()
                        .filter(order -> start <= order.start && order.start <= end)
                        .mapToInt(order -> order.cost)
                        .sum();
                System.out.print(totalCost + " ");
            } else if (type == 2) {
                int totalDuration = orders.stream()
                        .filter(order -> start <= order.end && order.end <= end)
                        .mapToInt(order -> order.end - order.start)
                        .sum();
                System.out.print(totalDuration + " ");
            }
        }
        System.out.println();
    }
}