package com.gevernova.timeclockthread;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DigitalClock clock = new DigitalClock();
        Thread clockThread = new Thread(clock);
        clockThread.start();

        // Let the clock run for 10 seconds
        Thread.sleep(10000);

        // Stop the clock
        clock.stop();

        // Wait for the clock thread to finish
        clockThread.join();

        System.out.println("Main thread exiting.");
    }
}
