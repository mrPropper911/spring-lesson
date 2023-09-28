package yandex_training_contest_backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LeiDontBeSorryV2 {
    private static final List<Order> orders = new ArrayList<>();
    private static final List<Request> requests = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            Order order = mapStringToOrders(s);
            orders.add(order);
        }
        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            requests.add(mapStringToRequest(br.readLine()));
        }

        for (Request request : requests) {
            if (request.type == 1) {
                System.out.print(sumCostOfOrders(request.start, request.end) + " ");
            } else {
                System.out.print(sumTimesOfOrders(request.start, request.end) + " ");
            }
        }
    }

    //1
    private static int sumCostOfOrders(int startOfRequest, int endOfRequest) {
        int summaryCost = 0;
        for (Order order : orders) {
            if (order.start >= startOfRequest && order.start <= endOfRequest) {
                summaryCost += order.cost;
            }
        }
        return summaryCost;
    }

    //2
    private static int sumTimesOfOrders(int startOfRequest, int endOfRequest) {
        int summaryTime = 0;
        for (Order order : orders) {
            if (order.end >= startOfRequest && order.end <= endOfRequest) {
                summaryTime = summaryTime + (order.end - order.start);
            }
        }
        return summaryTime;
    }

    private static Order mapStringToOrders(String str) {
        String[] strNumber = str.split(" ");
        return new Order(Integer.parseInt(strNumber[0]),
                Integer.parseInt(strNumber[1]),
                Integer.parseInt(strNumber[2]));
    }

    private static Request mapStringToRequest(String str) {
        String[] strNumber = str.split(" ");
        return new Request(Integer.parseInt(strNumber[0]),
                Integer.parseInt(strNumber[1]),
                Integer.parseInt(strNumber[2]));
    }

    public static class Order {
        int start;
        int end;
        int cost;

        public Order(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    public static class Request {
        int start;
        int end;
        int type;

        public Request(int start, int end, int type) {
            this.start = start;
            this.end = end;
            this.type = type;
        }
    }
}
