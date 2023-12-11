package com.example.study.dataStructure.queue;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService excutor = Executors.newFixedThreadPool(2);

        BlockingQueue<DelayedObject> queue = new DelayQueue<DelayedObject>();
        int numberOfElements = 3;
        int interval = 1000;
        int delay = 5000;

        DelayQueueProducer producer = new DelayQueueProducer(queue, numberOfElements, delay, interval);
        DelayQueueConsumer consumer = new DelayQueueConsumer(queue, numberOfElements);

        // Run Porducer / Consumer
        excutor.submit(producer);
        excutor.submit(consumer);

        // Wait for termination
        excutor.shutdown();
        excutor.awaitTermination(10, TimeUnit.SECONDS);

    }
}
