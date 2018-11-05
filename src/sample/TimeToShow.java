package sample;

import java.util.Locale;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Month;

public class TimeToShow {
    private LocalDateTime currentTime;
    public TimeToShow(){

    }

    public int showMinute(){
        currentTime = LocalDateTime.now();
        return currentTime.getMinute();
    }

    public int showHours(){
        currentTime = LocalDateTime.now();
        return currentTime.getHour();
    }

    public int showSecond(){
        currentTime = LocalDateTime.now();
        return currentTime.getSecond();
    }
}

