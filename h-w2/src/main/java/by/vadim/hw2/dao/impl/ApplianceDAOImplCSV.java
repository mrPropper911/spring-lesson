package by.vadim.hw2.dao.impl;

import by.vadim.hw2.dao.ApplianceDAO;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Scanner;


@Component
public class ApplianceDAOImplCSV implements ApplianceDAO {

    public StringBuilder findQuestion(String pathTest) {
        StringBuilder outLine = new StringBuilder();

        Scanner scanner = new Scanner(Objects.requireNonNull(ApplianceDAOImplCSV.
                class.getResourceAsStream(pathTest)));

        while (scanner.hasNext()){
            outLine.append(scanner.nextLine() + "\n");
        }

        return outLine;
    }
}
