package by.vadim.hw1.dao.impl;

import by.vadim.hw1.dao.ApplianceDAO;

import java.util.Objects;
import java.util.Scanner;

public class ApplianceDAOImplCSV implements ApplianceDAO {

    public StringBuilder findQuestion() {
        StringBuilder outLine = new StringBuilder();
        Scanner scanner =
                new Scanner(Objects.requireNonNull(ApplianceDAOImplCSV.class.getResourceAsStream("/question.csv")));
        while (scanner.hasNext()){
            outLine.append(scanner.nextLine() + "\n");
        }
        return outLine;
    }



}
