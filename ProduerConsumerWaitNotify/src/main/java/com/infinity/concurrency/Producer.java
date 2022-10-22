package com.infinity.concurrency;

public class Producer extends Thread {
    private final Database database;

    public Producer(Database database) {
        this.database = database;
    }

    @Override
    public void run() {
        try {
            int elementToAdd = 0;
            while (true) {
                this.database.addElement(elementToAdd);
                System.out.println("Producing element " + elementToAdd);
                elementToAdd++;

                sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
