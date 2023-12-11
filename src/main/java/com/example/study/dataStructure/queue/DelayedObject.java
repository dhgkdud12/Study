package com.example.study.dataStructure.queue;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

public class DelayedObject implements java.util.concurrent.Delayed {

    private final String data;
    private final long expTime;

    public DelayedObject(String data, long delayInMillis) {
        this.data = data;
        this.expTime = System.currentTimeMillis() + delayInMillis;
    }

    public String getData () {
        return data;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(expTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }


    @Override
    public int compareTo(@NotNull java.util.concurrent.Delayed o) {
        DelayedObject that = (DelayedObject) o;
        int c = Long.compare(expTime, this.expTime);
        if (c != 0) {
            return c;
        }
        return Integer.compare(System.identityHashCode(this), System.identityHashCode(that));
    }
}
