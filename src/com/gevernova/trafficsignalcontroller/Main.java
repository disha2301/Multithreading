package com.gevernova.trafficsignalcontroller;

public class Main {
    public static void main(String[] args) {
        TrafficSignalController controller = new TrafficSignalController();

        // Create and start threads for each direction
        new SignalThread(Direction.NORTH, controller).start();
        new SignalThread(Direction.SOUTH, controller).start();
        new SignalThread(Direction.EAST, controller).start();
        new SignalThread(Direction.WEST, controller).start();
    }
}
