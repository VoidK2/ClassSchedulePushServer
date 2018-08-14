package com.zzx;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class gettime {
    public int getWeekday(){
        Calendar ct = Calendar.getInstance();
        int dayForWeek;
        if(ct.get(Calendar.DAY_OF_WEEK) == 1){
            dayForWeek = 7;
        }else{
            dayForWeek = ct.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return dayForWeek;
    }
    public int getHour(){
        Date dt = new Date();
        SimpleDateFormat fth = new SimpleDateFormat("H");
        int hour = Integer.parseInt(fth.format(dt));
        return hour;
    }
    public int getMinute(){
        Date dt1 = new Date();
        SimpleDateFormat ftm = new SimpleDateFormat("m");
        int minute = Integer.parseInt(ftm.format(dt1));
        return minute;
    }
    public int getWeek(){
        Date dt2 =new Date();
        SimpleDateFormat ftw = new SimpleDateFormat("w");
        int week = Integer.parseInt(ftw.format(dt2));
        week = week - 29;
        return week;
    }
}
