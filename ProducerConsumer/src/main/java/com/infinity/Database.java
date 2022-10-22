package com.infinity;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Database {
    private final BlockingQueue<Integer> elements;

    public Database(int numberOfElements) {
        this.elements = new ArrayBlockingQueue<>(numberOfElements);
    }

    public void addElement(Integer value) throws InterruptedException {
        this.elements.put(value);
    }

    public Integer getElement() throws InterruptedException {
        return this.elements.take();
    }
}
