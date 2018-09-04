package com.zzx;


import java.util.logging.*;

public class Main extends Thread{

    public static void main(String[] args) throws Exception {
	    new Main().start();
    }
    public void run() {
        while (true) {
            gettime gt = new gettime();
            int nextWeek=0;
            int hour = gt.getHour();
            int nowweekday = gt.getWeekday();
            int nowweek  =  gt.getWeek();
            int minute = gt.getMinute();

            System.out.println("时间"+hour+":"+minute+" 第"+nowweek+"周"+" 星期"+nowweekday);
            if((hour==7||hour==9||hour==13||hour==15||hour==18)&&minute==20){
//                当天
                String sql = String .format("select name,stime,etime,place,teacher from 16SoftwareEngineering3 where " +
                        "shour=%d and week=%d and " +
                        "sweek<=%d and eweek>=%d",hour+1,nowweekday,nowweek,nowweek);
                System.out.println(sql);

                db db1 = new db();
                db1.dbConnect(sql);

                try {
                    db1.db2msgNextHour();
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
            if(hour==21&&minute==30){
//                次日
                if(nowweekday<=6){ nextWeek=nowweekday+1;}
                if(nowweekday==7){ nextWeek=1;}
                String sql = String.format("select name,stime,etime,place,teacher " +
                        "from 16SoftwareEngineering3 where week=%d",nextWeek);//构造sql查询
                System.out.println(sql);

                db db2 = new db();
                db2.dbConnect(sql);

                try {
                    db2.db2msgNextDay();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            try {
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

