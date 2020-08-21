package com.example.threadlearning;

import android.widget.Toast;

import java.util.ArrayList;

public class CountDownThread extends Thread {
    public void setCountDownThreadInterface(CountDownThreadInterface countDownThreadInterface) {
        this.countDownThreadInterface = countDownThreadInterface;
    }

    CountDownThreadInterface countDownThreadInterface;



    @Override
    public void run() {
        int count = 10;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = count; i > 0; i--) {
            list.add(i);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        countDownThreadInterface.getViewNow(list);
    }

}
