package com.crashcourse.threadCommunication;

public class Consumer implements Runnable {

    private SharedResource resource;

    public Consumer(SharedResource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            resource.consume();
        }
    }

}
