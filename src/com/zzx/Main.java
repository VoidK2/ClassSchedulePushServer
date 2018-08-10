package com.zzx;



public class Main extends Thread{

    public static void main(String[] args) throws Exception {
	System.out.println("asdas");
	msg s1=new msg();
	new Main().start();
    }
    public void run() {
        while (true) {
            gettime gt = new gettime();
            int nextWeek=0;
            int hour = gt.getHour();
            int nowweekday = gt.getWeekday();
            int minute = gt.getMinute();
            if((hour==7||hour==9||hour==13||hour==15||hour==18)&&minute==20){
//                当天课程通知
                db db1 = new db();
                String sql = String .format("select name,stime,etime,place,teacher from 16se3 where " +
                        "shour=%d and week=%d",hour+1,nowweekday);

            }
            if(hour==21&&minute==30){
//                第二天课程汇总
                if(nowweekday<=6){ nextWeek=nowweekday+1;}
                if(nowweekday==7){ nextWeek=1;}
                String sql = String.format("select name,stime,etime,place,teacher from 16se3 where week=%d",nextWeek);
                db db2 = new db();
                db2.dbConnect(sql);

            }
            try {
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

