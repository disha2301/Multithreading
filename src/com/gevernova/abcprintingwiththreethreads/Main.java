package com.gevernova.abcprintingwiththreethreads;

public class Main {
    public static void main(String args[]){
        PrintABC obj = new PrintABC();

        Thread t1 = new Thread(() -> obj.printA());
        Thread t2 = new Thread(() -> obj.printB());
        Thread t3 = new Thread(() -> obj.printC());

        t1.start();
        t2.start();
        t3.start();
    }
}
