package com.gevernova.evenoddprinter;

public class OddEvenPrinter {

    int counter = 1;
    int limitN; // till n

    // constructor
    public OddEvenPrinter(int limitN){
        this.limitN = limitN;
    }

    public void printOdd(){
        synchronized (this){
            while(counter <= limitN){
                if(counter % 2 == 0){
                    try{
                        wait(); // wait for odd
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                else {
                    System.out.println("ODD NUMBER FOUND : "+counter);
                    counter++;
                    notify(); // signal even number thread
                }
            }
        }
    }
    public void printEven(){
        synchronized (this) // ensures only one thread runs inside at a time
        {
            while(counter <= limitN){
                if(counter % 2 != 0) {
                    try {
                        wait(); // wait until even's turn
                        // pauses the current thread until another thread calls notify()
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    System.out.println("EVEB NUMBER FOUND : "+counter);
                    counter++;
                    notify(); // signal odd number thread
                }
            }
        }
    }
}
