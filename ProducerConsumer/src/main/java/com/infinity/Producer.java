package com.infinity;

public class Producer extends Thread {
    private final Database database;

    public Producer(Database database) {
        this.database = database;
    }

    @Override
    public void run() {
        produceElements();
    }

    private void produceElements() {
        int elementToAdd = 0;
        while (true) {
            try {
                this.database.addElement(elementToAdd);
                System.out.println("Producing the element " + elementToAdd);
                elementToAdd++;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
