package com.infinity.concurrency;

public class Main {
    public static void main(String[] args) {
        Database database = new Database(5);
        Producer producer = new Producer(database);
        Consumer consumer = new Consumer(database);

        producer.start();
        consumer.start();
    }
}