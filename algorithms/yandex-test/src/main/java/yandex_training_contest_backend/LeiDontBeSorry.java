package yandex_training_contest_backend;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LeiDontBeSorry {
    private static List<Order> orders = new ArrayList<>();
    private static List<Request> requests = new ArrayList<>();


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

        List<Integer> result = mailLogic(dataList);

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
            for (Integer index : result) {
                bw.write(index + " ");
            }
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<Integer> mailLogic(List<String> inputList) {
        List<Integer> resultList = new ArrayList<>();
        int N = Integer.parseInt(inputList.get(0)); //count of orders
        orders = inputList.stream()
                .skip(1)
                .map(LeiDontBeSorry::mapStringToOrders)
                .limit(N)
                .collect(Collectors.toList());
        int Q = Integer.parseInt(inputList.get(N + 1));//count of request
        requests = inputList.stream()
                .skip(N + 2)
                .map(LeiDontBeSorry::mapStringToRequest)
                .collect(Collectors.toList());

        for (Request request : requests) {
            switch (request.type) {
                case 1:
                    resultList.add(sumCostOfOrders(request.start, request.end));
                    break;
                case 2:
                    resultList.add(sumTimesOfOrders(request.start, request.end));
                    break;
            }
        }
        return resultList;
    }

    //1
    private static int sumCostOfOrders(int startOfRequest, int endOfRequest) {
        int summaryCost = 0;
        for (Order order : orders){
            if (order.start >= startOfRequest && order.start <= endOfRequest){
                summaryCost += order.cost;
            }
        }
            return summaryCost;
    }

    //2
    private static int sumTimesOfOrders(int startOfRequest, int endOfRequest) {
        int summaryTime = 0;
        for (Order order : orders){
            if (order.end >= startOfRequest && order.end <= endOfRequest){
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
