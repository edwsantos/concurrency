package com.infinity.concurrency;

import java.util.LinkedList;

public class Database {
    private final LinkedList<Integer> database;
    private final Integer maxDatabaseSize;

    public Database(int databaseSize) {
        this.maxDatabaseSize = databaseSize;
        this.database = new LinkedList<>();
    }

    public synchronized void addElement(Integer element) {
        if (this.database.size() >= this.maxDatabaseSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.database.offer(element);
        notify();
    }

    public synchronized Integer getElement() {
        if (this.database.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        notify();
        return this.database.poll();

    }
}
