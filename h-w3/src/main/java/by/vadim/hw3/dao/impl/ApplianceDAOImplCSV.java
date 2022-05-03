package by.vadim.hw3.dao.impl;

import by.vadim.hw3.configs.AppProps;
import by.vadim.hw3.dao.ApplianceDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.util.Objects;
import java.util.Scanner;

@Service
public class ApplianceDAOImplCSV implements ApplianceDAO {

    private final MessageSource messageSource;
    private final AppProps appProps;

    public ApplianceDAOImplCSV(MessageSource messageSource, AppProps appProps) {
        this.messageSource = messageSource;
        this.appProps = appProps;
    }

    @Override
    public StringBuilder findQuestion() {
        StringBuilder outLine = new StringBuilder();
        String url = setUrl();

        Scanner scanner = new Scanner(Objects.requireNonNull(ApplianceDAOImplCSV.
                class.getResourceAsStream(url)));
        while (scanner.hasNext()){
            outLine.append(scanner.nextLine() + "\n");
        }
        return outLine;
    }

    @PreDestroy
    private String setUrl(){
        var message = messageSource.getMessage("question.url", new String[]{} , appProps.getLocale());
        return message;
    }
}
