package com.gevernova.multiplethreads;

import java.util.concurrent.atomic.AtomicInteger;

public class ArraySumWithThreads{
    int arr[];
    AtomicInteger totalSum = new AtomicInteger(0);

    public ArraySumWithThreads(int[] arr){
        this.arr = arr;
    }

    public void calculateSum() throws InterruptedException{
        Thread threadOne = new Thread( ()->{
            int partialSumFromStart = 0;
            for(int i = 0; i<= (arr.length/2); i++){
                partialSumFromStart += arr[i];
            }
            totalSum.addAndGet(partialSumFromStart); //atomic updation
            System.out.println("Thread 1 partial sum is : "+partialSumFromStart);
        });

        Thread threadTwo = new Thread( ()->{
            int partialSumFromEnd = 0;
            for(int i = (arr.length/2); i < arr.length; i++){
                partialSumFromEnd += arr[i];
            }
            totalSum.addAndGet(partialSumFromEnd);
            System.out.println("Thread 2 partial sum is : "+partialSumFromEnd);
        });

        threadOne.start();
        threadTwo.start();

        threadOne.join(); // wait for threadOne to finish
        threadTwo.join();

        System.out.println("Total sum = " + totalSum.get());
    }
}
