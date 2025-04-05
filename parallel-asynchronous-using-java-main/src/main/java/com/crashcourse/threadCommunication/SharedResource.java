package com.crashcourse.threadCommunication;

public class SharedResource {

    private int data;
    private boolean hasData;

    public synchronized void produce(int value){
        // when data is there then wait for consumer to consume
        while(hasData){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        // produce data when buffer is empty
        data = value;
        hasData = true;
        System.out.println("Produced: " + value);
        notify(); // notify the consumer that data is produced
    }

    public synchronized void consume(){
        // when buffer is empty then wait for producer to produce data
        while(!hasData){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        // after consumption set hasData to false
        hasData = false;
        System.out.println("Consumed: " + data);
        notify(); // notify the producer that data is consumed
    }

}
