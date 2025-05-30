package com.gevernova.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    Queue<Integer> buffer = new LinkedList<>();
    int capacity = 5;

    // Method to start producer and consumer threads
    public void startSimulation(){

        // Producer thread using lambda
        Thread producer = new Thread(() ->{
            int value = 0;
            while(value <= capacity){
                synchronized (buffer){
                    // Wait while the buffer is full
                    while(buffer.size() == capacity){
                        try{
                            buffer.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    // Add item to buffer
                    buffer.add(value);
                    System.out.println("Produced: " + value);
                    value++;

                    // Notify any waiting consumer threads
                    buffer.notifyAll();
                }
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        // Consumer thread using lambda
        Thread consumer = new Thread(()->{
            while(true){
                synchronized (buffer){
                    // Wait while the buffer is empty
                    while (buffer.isEmpty()){
                        try{
                            buffer.wait();
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    // remove the items from the buffer
                    int value = buffer.poll();
                    System.out.println("Consumed: " + value);
                    // Notify any waiting producer threads
                    buffer.notifyAll();
                }
                try {
                    Thread.sleep(1000); // Simulate time to consume
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // Start both threads
        producer.start();
        consumer.start();
    }

}
