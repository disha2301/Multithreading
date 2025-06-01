package com.gevernova.trafficsignalcontroller;

// Thread class for each direction
public class SignalThread extends Thread {
    private final Direction direction;
    private final TrafficSignalController controller;

    public SignalThread(Direction direction, TrafficSignalController controller) {
        this.direction = direction;
        this.controller = controller;
    }

    @Override
    public void run() {
        while (true) {
            controller.changeLight(direction);
        }
    }
}