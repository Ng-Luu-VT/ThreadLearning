package com.example.threadlearning;

public class CountTheNumberThread extends Thread {
    private int count = 0;
    private boolean stop = false;

    @Override
    public void run() {
        while (!stop){
            count++;
            if (count > 100){
                count = 0;
            }
        }
    }

    public void end(){
        stop = true;
    }

    public int getCount(){
        return count;
    }
}
