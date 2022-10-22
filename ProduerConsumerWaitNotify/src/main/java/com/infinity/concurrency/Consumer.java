package com.infinity.concurrency;

public class Consumer extends Thread {
    private final Database database;

    public Consumer(Database database) {
        this.database = database;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer element = this.database.getElement();
                System.out.println("Consuming element " + element);
                sleep(8000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
