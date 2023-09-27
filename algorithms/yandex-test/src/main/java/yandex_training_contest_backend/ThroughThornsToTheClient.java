package yandex_training_contest_backend;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ThroughThornsToTheClient {
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

    private static List<Integer> mailLogic(List<String> dataList) {
        List<Integer> result = new ArrayList<>();
        List<Rocket> rocketList = new ArrayList<>();

        //mapping in Rocket entity with converting date to minutes
        for (int i = 1; i < dataList.size(); i++) {
            String[] logField = dataList.get(i).split(" ");
            Rocket rocket = new Rocket(
                    Integer.parseInt(logField[3]),
                    Integer.parseInt(logField[0]) * 60 * 24 + Integer.parseInt(logField[1]) * 60 +
                            Integer.parseInt(logField[2]),
                    logField[4]);
            rocketList.add(rocket);
        }

        //Sorting by id and time
        List<Rocket> sortedByIdRocket = rocketList.stream()
                .sorted(Comparator.comparingInt(Rocket::getId)
                        .thenComparingInt(Rocket::getTime))
                .collect(Collectors.toList());

        int time = 0;
        boolean tempStation = false;
        for (int i = 0; i < sortedByIdRocket.size() - 1; i++) {
            if (sortedByIdRocket.get(i).id == sortedByIdRocket.get(i + 1).id) {
                if (sortedByIdRocket.get(i).status.equals("A")) {
                    //A - C
                    if (sortedByIdRocket.get(i + 1).status.equals("C")) {
                        time = time + (sortedByIdRocket.get(i + 1).time - sortedByIdRocket.get(i).time);

                    } else if (sortedByIdRocket.get(i + 1).status.equals("B")) {
                        tempStation = true;
                    }
                } else if (sortedByIdRocket.get(i).status.equals("B") && tempStation) {
                    //A - B - C
                    if (sortedByIdRocket.get(i + 1).status.equals("C")) {
                        time = time + (sortedByIdRocket.get(i + 1).time - sortedByIdRocket.get(i - 1).time);
                    }
                    //A - B - S
                    else if (sortedByIdRocket.get(i + 1).status.equals("S")) {
                        time = time + (sortedByIdRocket.get(i + 1).time - sortedByIdRocket.get(i - 1).time);
                    }
                }

                //If last iteration, saving result
                if (time > 0 && sortedByIdRocket.size() == (i + 2)) {
                    result.add(time);
                }

            } else {
                result.add(time);
                tempStation = false;
                time = 0;
            }
        }
        return result;
    }

    private static class Rocket {
        int id;
        int time;
        String status;

        public Rocket(int id, int time, String status) {
            this.id = id;
            this.time = time;
            this.status = status;
        }

        public int getId() {
            return id;
        }

        public int getTime() {
            return time;
        }
    }
}