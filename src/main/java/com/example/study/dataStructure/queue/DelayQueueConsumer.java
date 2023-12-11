package com.example.study.dataStructure.queue;

import java.sql.Date;
import java.time.Instant;
import java.util.concurrent.BlockingQueue;

public class DelayQueueConsumer implements Runnable{
    private final BlockingQueue<DelayedObject> queue;
    private final int numberOfElements;

    public DelayQueueConsumer(BlockingQueue<DelayedObject> queue, int numberOfElements) {
        this.queue = queue;
        this.numberOfElements = numberOfElements;
    }

    // standard constructors

    @Override
    public void run() {
        for (int i = 0; i < numberOfElements; i++) {
            try {
                DelayedObject object = queue.take();
                System.out.println("(" + Date.from(Instant.now()) + ") Get Object : " + object.getData());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
