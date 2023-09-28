package yandex_training_contest_backend;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class LeiDontBeSorry {
    private static Set<Order> orders = new HashSet<>();
    private static List<Request> requests = new ArrayList<>();
    private static List<Order> sortedUniqOrder = new ArrayList<>();


    public static void main(String[] args) throws InterruptedException {
//        long sT5 = System.currentTimeMillis();
//
//        try {
//            BufferedWriter bw = new BufferedWriter(new FileWriter("input.txt"));
//            int N = 90_000;
//            bw.write(String.valueOf(N + "\n"));
//            for (int i = 0; i < N; i++) {
//                bw.write("10 100 1000\n");
//            }
//            int Q = 90_000;
//            bw.write(String.valueOf(Q + "\n"));
//            for (int i = 0; i < Q; i++) {
//                bw.write("1 10 1\n");
//            }
//            bw.close();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//        System.out.println("Time Generate: " + (System.currentTimeMillis() - sT5));


//        long sT3 = System.currentTimeMillis();

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

//        System.out.println("Time 1: " + (System.currentTimeMillis() - sT3));


        List<Long> result = mailLogic(dataList);

//        long sT4 = System.currentTimeMillis();

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
            for (Long index : result) {
                bw.write(index + " ");
            }
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
//        System.out.println("Time 2: " + (System.currentTimeMillis() - sT4));

    }

    private static List<Long> mailLogic(List<String> inputList) throws InterruptedException {
        List<Long> resultList = new ArrayList<>();

//        long sT = System.currentTimeMillis();

        int N = Integer.parseInt(inputList.get(0)); //count of orders
        orders = inputList.stream()
                .skip(1)
                .map(LeiDontBeSorry::mapStringToOrders)
                .limit(N)
                .collect(Collectors.toSet());
        sortedUniqOrder = orders.stream()
                .sorted(Comparator.comparingInt(Order::getStart).thenComparingInt(Order::getEnd))
                .collect(Collectors.toList());

        int Q = Integer.parseInt(inputList.get(N + 1));//count of request
        requests = inputList.stream()
                .skip(N + 2)
                .map(LeiDontBeSorry::mapStringToRequest)
                .collect(Collectors.toList());

//        System.out.println("Time parsing: " + (System.currentTimeMillis() - sT));

        long sT1 = System.currentTimeMillis();

        for (Request request : requests) {
            switch (request.type) {
                case 1:
//                    System.out.print(sumCostOfOrders(request.start, request.end) + " ");
                    if (request.start > sortedUniqOrder.get(sortedUniqOrder.size()- 1).end){
                        resultList.add(0L);
                        break;
                    }
                    resultList.add(sumCostOfOrders(request.start, request.end));
                    break;
                case 2:
//                    System.out.print(sumTimesOfOrders(request.start, request.end) + " ");
                    if (request.start > sortedUniqOrder.get(sortedUniqOrder.size()- 1).end){
                        resultList.add(0L);
                        break;
                    }
                    resultList.add(sumTimesOfOrders(request.start, request.end));
                    break;
            }
        }
//        Thread.sleep(1);
//        System.out.println("Time logic: " + (System.currentTimeMillis() - sT1));

        return resultList;
    }

    //1
    private static long sumCostOfOrders(int startOfRequest, int endOfRequest) {
        long summaryCost = 0;
        for (Order order : sortedUniqOrder) {
            if (order.start >= startOfRequest && order.start <= endOfRequest) {
                summaryCost += order.cost;
            }
            if (order.start > endOfRequest){
                return summaryCost;
            }
        }
        return summaryCost;
    }

    //2
    private static long sumTimesOfOrders(int startOfRequest, int endOfRequest) {
        long summaryTime = 0;
        for (Order order : sortedUniqOrder) {
            if (order.end >= startOfRequest && order.end <= endOfRequest) {
                summaryTime = summaryTime + (order.end - order.start);
            }
            if (order.start > endOfRequest){
                return summaryTime;
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

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public Order(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;


        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Order order = (Order) o;

            if (start != order.start) return false;
            if (end != order.end) return false;
            return cost == order.cost;
        }

        @Override
        public int hashCode() {
            int result = start;
            result = 31 * result + end;
            result = 31 * result + cost;
            return result;
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
