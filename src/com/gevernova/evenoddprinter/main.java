package com.gevernova.evenoddprinter;

public class main {
    public static void main(String[] args){
        OddEvenPrinter printer = new OddEvenPrinter(10);
        Thread oddThread = new Thread(() -> printer.printOdd());
        Thread evenThread = new Thread(() -> printer.printEven());

        oddThread.start();
        evenThread.start();
    }
}