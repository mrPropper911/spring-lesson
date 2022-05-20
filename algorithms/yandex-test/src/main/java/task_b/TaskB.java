package task_b;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) throws IOException{
        TaskB taskB = new TaskB();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();//long airplane
        scanner.nextLine();
        char[][] seats = new char[n][7];
        taskB.createAirplaneStartSeating(seats, n, scanner);

        int passengersCount = scanner.nextInt();//count of passengers
        scanner.nextLine();

        for (int i = 0; i < passengersCount; i++){
            String preferPosition = "";
            preferPosition = scanner.nextLine();
            taskB.landingToAirplane(seats, preferPosition);
        }
    }

    //search seats to chose group
    void landingToAirplane(char[][] seats, String preferPosition){
        String[] preferPositionArray = preferPosition.split(" ");

        int numOfPassengers = Integer.parseInt(preferPositionArray[0]);
        String sideOfPassengers = preferPositionArray[1];
        String positionOfPassengers = preferPositionArray[2];

        for (int i = 0; i < seats.length; i++){
            if (stepLandingToAirplane(seats[i], numOfPassengers, sideOfPassengers, positionOfPassengers, i, seats)){
                break;
            } else if (seats.length -1 == i &&
                    !stepLandingToAirplane(seats[i], numOfPassengers, sideOfPassengers, positionOfPassengers, i, seats)){
                System.out.println("Cannot fulfill passengers requirements");
            }

        }
    }

    //num(1,2,3) side(left,right) position(aisle, window)

    //check line sets to group
    boolean stepLandingToAirplane(char[] stepSeats,
                                  int numOfPassengers, String sideOfPassengers, String positionOfPassengers ,
                                  int placeLine,
                                  char[][] seats){
        boolean choseSide = false;

        //LEFT
        if (sideOfPassengers.equals("left")){
            //left + aisle
            if (checkThreeChosePosition(stepSeats, numOfPassengers, 0, 2) && !choseSide){
                if (positionOfPassengers.equals("aisle")){
                    for (int k = 2; k > (2 - numOfPassengers); k--){
                        if (stepSeats[k] == '#'){
                            return false;
                        }
                    }
                    for (int k = 2; k > (2 - numOfPassengers); k--){
                        stepSeats[k] = 'X';
                    }
                    System.out.println("Passengers can take seats:" + checkPlaceX(stepSeats, placeLine));
                    showAirplaneSeating(seats);
                    for (int k = 2; k > (2 - numOfPassengers); k--){
                        stepSeats[k] = '#';
                    }

                    choseSide = true;//end search found sets
                }
            }

            //left + windows
            if (checkThreeChosePosition(stepSeats, numOfPassengers, 0, 2) && !choseSide){
                if (positionOfPassengers.equals("window")){
                    for (int k = 0; k < numOfPassengers; k++){
                        if (stepSeats[k] == '#'){
                            return false;
                        }
                    }
                    for (int k = 0; k < numOfPassengers; k++){
                        stepSeats[k] = 'X';
                    }
                    System.out.println("Passengers can take seats:" + checkPlaceX(stepSeats, placeLine));
                    showAirplaneSeating(seats);
                    for (int k = 0; k < numOfPassengers; k++){
                        stepSeats[k] = '#';
                    }
                    choseSide = true;//end search found sets
                }
            }
        }

        //RIGHT
        if(sideOfPassengers.equals("right")){
            //right + aisle
            if (checkThreeChosePosition(stepSeats, numOfPassengers, 4, 6) && !choseSide){
                if (positionOfPassengers.equals("aisle")){
                    for (int k = 4; k < (4 + numOfPassengers); k++){
                        if (stepSeats[k] == '#'){
                            return false;
                        }
                    }
                    for (int k = 4; k < (4 + numOfPassengers); k++){
                        stepSeats[k] = 'X';
                    }
                    System.out.println("Passengers can take seats:" + checkPlaceX(stepSeats, placeLine));
                    showAirplaneSeating(seats);
                    for (int k = 4; k < (4 + numOfPassengers); k++){
                        stepSeats[k] = '#';
                    }
                    choseSide = true;//end search found sets
                }
            }

            //right + windows
            if (checkThreeChosePosition(stepSeats, numOfPassengers, 4, 6) && !choseSide){
                if (positionOfPassengers.equals("window")){
                    for (int k = 6; k > (6 - numOfPassengers); k--){
                        if (stepSeats[k] == '#'){
                            return false;
                        }
                    }
                    for (int k = 6; k > (6 - numOfPassengers); k--){
                        stepSeats[k] = 'X';
                    }
                    System.out.println("Passengers can take seats:" + checkPlaceX(stepSeats, placeLine));
                    showAirplaneSeating(seats);
                    for (int k = 6; k > (6 - numOfPassengers); k--){
                        stepSeats[k] = '#';
                    }
                    choseSide = true;//end search found sets
                }
            }
        }

        return choseSide;
    }

    //check count of free space
    boolean checkThreeChosePosition(char[] stepSeats, int countPassenger, int start, int finish){
        int countOfFreeSeats = 0;
        for (int i = start; i <= finish; i++){
            if(stepSeats[i] == '.'){
                countOfFreeSeats++;
            }
        }
        return countOfFreeSeats >= countPassenger;
    }

    //check placeX
    String checkPlaceX(char[] stepSeats, int lineSeats){
        //todo can create with ASCI if we use more RAM
        Map<Integer, Character> alphabet = new HashMap<>();
        alphabet.put(0, 'A');
        alphabet.put(1, 'B');
        alphabet.put(2, 'C');
        alphabet.put(4, 'D');
        alphabet.put(5, 'E');
        alphabet.put(6, 'F');
        String outStr = "";
        for (int i = 0; i < stepSeats.length; i++){
            if (stepSeats[i] == 'X'){
                outStr = outStr + " " + (lineSeats + 1) + alphabet.get(i);
            }
        }
        return outStr;
    }

    //show airplane seats
    void showAirplaneSeating(char[][] seats){
        for (int i = 0; i < seats.length; i++){
            for (int j = 0; j < seats[0].length; j++ ){
                System.out.print(seats[i][j]);
            }
            System.out.println("");
        }
    }

    //starting airplane seats
    void createAirplaneStartSeating(char[][] seats, int n, Scanner scanner) throws IOException {
        for (int i = 0; i < n; i ++){
            //scanner.nextLine();
            String set = scanner.nextLine();
            char[] charsSet = set.toCharArray();
            for (int j = 0; j < 7; j++){
                seats[i][j] = charsSet[j];
            }
        }
    }
}