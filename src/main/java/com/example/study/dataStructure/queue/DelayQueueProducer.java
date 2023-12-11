package com.example.study.dataStructure.queue;

import java.sql.Date;
import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;

public class DelayQueueProducer implements Runnable{

    private final BlockingQueue<DelayedObject> queue;
    private final Integer numberOfElements;
    private final int delay;
    private final int interval;

    public DelayQueueProducer(BlockingQueue<DelayedObject> queue, Integer numberOfElements, int delay, int interval) {
        this.queue = queue;
        this.numberOfElements = numberOfElements;
        this.delay = delay;
        this.interval = interval;
    }

    @Override
    public void run() {
        for (int i = 0; i< numberOfElements; i++) {
            DelayedObject object = new DelayedObject(UUID.randomUUID().toString(), delay);
            System.out.println("(" + Date.from(Instant.now()) + ") Put object: " + object.getData());

            try {
                queue.put(object);
                Thread.sleep(interval);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}
