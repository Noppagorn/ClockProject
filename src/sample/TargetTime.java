package sample;

import java.io.IOException;

public class TargetTime{
    private int hour;
    private  int minute;
    private int second;
    public TargetTime(){
        hour = 0;
        minute = 0;
        second = 0;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour)  throws  IOException{
        if (hour > 24 || hour < 0){
            throw new IOException("MUST BE HOUR IN A DAY!");
        }
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) throws IOException{
        if (minute > 60 || minute < 0){
            throw new IOException("MUST BE MINUTE IN A HOUR!");
        }
        this.minute = minute;
    }
    public boolean check(int hour,int minute,int second){
        if (this.hour == hour && this.minute == minute && second == 0){
            System.out.println("ALARM!!!");
            return true;
        }
        else{
            return false;
        }
    }
}
