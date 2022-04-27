package by.vadim.hw3.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cglib.core.Local;

import java.util.Locale;

@ConfigurationProperties(prefix = "application")
public class AppProps {
    private Locale locale;
    private int achieveScore;
    private int timeDelay;

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public int getAchieveScore() {
        return achieveScore;
    }

    public void setAchieveScore(int achieveScore) {
        this.achieveScore = achieveScore;
    }

    public int getTimeDelay() {
        return timeDelay;
    }

    public void setTimeDelay(int timeDelay) {
        this.timeDelay = timeDelay;
    }
}
