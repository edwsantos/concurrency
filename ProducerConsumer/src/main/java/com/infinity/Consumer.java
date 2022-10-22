package com.infinity;

public class Consumer extends Thread {
    private final Database database;

    public Consumer(Database database) {
        this.database = database;
    }

    @Override
    public void run() {
        consumeElements();
    }

    private void consumeElements() {
        while (true) {
            try {
                Integer returnedElement = this.database.getElement();
                System.out.println("The consumed element is " + returnedElement);
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
