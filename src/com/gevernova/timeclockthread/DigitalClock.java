package com.gevernova.timeclockthread;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DigitalClock implements Runnable{
    private volatile boolean running = true;

    @Override
    public void run(){
        // java.time.format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        while(running){
            // get the current time
            LocalTime now = LocalTime.now();
            // print the formatted time
            System.out.println("Current time : "+now.format(formatter));

            try{
                Thread.sleep(1000); // sleep for 1 second
            } catch (InterruptedException e){
                running = false;
                Thread.currentThread().interrupt();  // preserve interrupt status
            }
        }
        System.out.println("clock stopped");
    }
    // method to stop the clock
    public void stop() {
        running = false;
    }
}
