package com.gevernova.trafficsignalcontroller;

public class TrafficSignalController {private Direction currentGreen = Direction.NORTH; // Initial green

    // Synchronized method to change lights
    public synchronized void changeLight(Direction direction) {
        while (direction != currentGreen) {
            try {
                wait(); // Wait for your turn
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Green signal is on for this direction
        System.out.println(direction + " light is GREEN");
        try {
            Thread.sleep(3000); // Green for 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Change to next direction
        switch (currentGreen) {
            case NORTH:
                currentGreen = Direction.EAST;
                break;
            case EAST:
                currentGreen = Direction.SOUTH;
                break;
            case SOUTH:
                currentGreen = Direction.WEST;
                break;
            case WEST:
                currentGreen = Direction.NORTH;
                break;
        }
        notifyAll(); // Let other threads check if it's their turn
    }
}
