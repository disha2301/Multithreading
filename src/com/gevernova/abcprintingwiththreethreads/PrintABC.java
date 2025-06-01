package com.gevernova.abcprintingwiththreethreads;

public class PrintABC {
    int currentStatus = 0;
    int numberOfTimes = 5;

    public void printA() {
        for (int i = 0; i < numberOfTimes; i++) {
            synchronized (this) {
                while (currentStatus % 3 != 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("A");
                currentStatus++;
                notifyAll();
            }
        }
    }
    public void printB() {
        for (int i = 0; i < numberOfTimes; i++) {
            synchronized (this) {
                while (currentStatus % 3 != 1) { // B should come second
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("B");
                currentStatus++;
                notifyAll();
            }
        }
    }
    public void printC() {
        for (int i = 0; i < numberOfTimes; i++) {
            synchronized (this) {
                while (currentStatus % 3 != 2) { // C should come third
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("C");
                currentStatus++;
                notifyAll();
            }
        }
    }
}
