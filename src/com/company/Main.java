package com.company;
import java.text.DecimalFormat;
import java.time.LocalDateTime;


public class Main {


    public static void main(String[] args) {
        // write your code here
        int hr = LocalDateTime.now().getHour();
        int min = LocalDateTime.now().getMinute();
        int sec = LocalDateTime.now().getSecond();
        Clock myclock = new Clock(hr, min, sec);
    }

}

class Clock {
    int hr;
    int min;
    int sec;

    public Clock(int h, int m, int s) {
        this.hr = h;
        this.min = m;
        this.sec = s;
        try {
            counter();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void counter() throws InterruptedException {
        DecimalFormat df = new DecimalFormat("00");
        String h, m, se = "";
        while (true) {
            h = df.format(this.hr);
            m = df.format(this.min);
            se = df.format(this.sec);
            System.out.println(h + ":" + m + ":" + se);
            Thread.sleep(1000);
            this.sec = increment(this.sec);
            if (this.sec == 60) {
                this.sec = 0;
                this.min = increment(this.min);
            }
            if (this.min == 60) {
                this.min = 0;
                this.hr = increment(this.hr);
            }
            if (this.hr == 24) {
                this.sec = 0;
                this.min = 0;
                this.hr = 0;
            }

        }

    }


    public int increment(int temp) {
        return temp + 1;
    }
}