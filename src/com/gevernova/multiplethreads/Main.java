package com.gevernova.multiplethreads;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        int[] arr = {1,2,3,4,5,6,7,8};
        ArraySumWithThreads sum = new ArraySumWithThreads(arr);
        sum.calculateSum();
    }
}
